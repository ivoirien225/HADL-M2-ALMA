package hadl.connector.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hadl.connector.meta.model.Glue;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;
import hadl.utils.meta.model.Pair;

public class GlueOO extends Glue implements Observable, Observer {
	
	public GlueOO(String name, List<Pair> pairList) {
		super(name, pairList);
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public List<Observer> observers = new ArrayList<Observer>();
	

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
			Logger.loggerWritter(this, "update", message);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			notifyObservers(observable, message);
		} catch (Exception e) {
			try {
				Logger.loggerExceptionWritter(this, "update", message);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		Observer toNotify = null;
		try {
			Logger.loggerWritter(this, "notifyObservers", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		for(Observer ob : observers){
			if(ob.equals((Observer)observable)){
				/*Search the corresponding reference of role in 
				 *the pair list of glue owning current simple connector*/
				for(Pair p : this.getPairList()){
					if(p.exist(ob)){
						toNotify=(Observer)p.get(ob);
						break;
					}
				}
			}
		}
		try{
			toNotify.update(this, message);
		}catch(Exception e){
			try {
				Logger.loggerExceptionWritter(this, "notifyObservers", message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		 		
	}


}
