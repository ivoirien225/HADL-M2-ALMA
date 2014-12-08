package hadl.connector.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Glue;
import hadl.connector.meta.model.SimpleConnector;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;
import hadl.utils.meta.model.Pair;

public class SimpleConnectorOO extends SimpleConnector implements Observable,
		Observer {

	public List<Observer> getObservers() {
		return observers;
	}

	public List<Observer> observers = new ArrayList<Observer>();
	
	public SimpleConnectorOO(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required, Glue glue) {
		super(name, listRole_Provide, listRole_Required, glue);
	}

	@Override
	public void addObserver(Observer ob) {
		System.out.println("[INFO]"+this.getName()+" In addObserver");
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		observers.remove(ob);
	}

	@Override
	public void update(Observable observable, Message message) {
		try {
			notifyObservers(observable, message);
			Logger.loggerWritter(this, "update", message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Logger.loggerExceptionWritter(this, "update", message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		Observer toNotify=null;
		for(Observer ob : observers){
			if(ob.equals((Observer)observable)){
				/*Search the corresponding reference of role in 
				 *the pair list of glue owning current simple connector*/
				for(Pair p : this.glue.getPairList()){
					toNotify=(Observer)p.get(ob);
					break;
				}
			}
		}
		try{
			toNotify.update(this, message);
			Logger.loggerWritter(this, "notifyObservers", message);
		}catch(Exception e){
			try {
				Logger.loggerExceptionWritter(this, "notifyObservers", message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		 		
	}

}
