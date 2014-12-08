package hadl.connector.model;

import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Glue;
import hadl.connector.meta.model.SimpleConnector;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;
import hadl.link.meta.model.Link;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addObserver(Observer ob) {
		// TODO Auto-generated method stub
		System.out.println("[INFO]"+this.getName()+" In addObserver");
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.remove(ob);
	}

	@Override
	public void update(Observable observable, Message message) {
		// TODO Auto-generated method stub
		System.out.println("[INFO] "+this.getName()+" In method update.");
		System.out.println("[INFO] "+this.getName()+" Message Received: "+message+".");
		System.out.println("[INFO] "+this.getName()+" Call method notifyObserver.");
		notifyObservers(observable, message);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		// TODO Auto-generated method stub
		System.out.println("[INFO] "+this.getName()+" In method notifyObserver.");
		
		Observer toNotify=null;
		
		for(Observer ob : observers){
			System.out.println("[INFO] "+this.getName()+" In method notifyObserver :In a cycle to find the associated role of role which sent the last notification to Configuration.");	
			if(ob.equals((Observer)observable)){
				/*Search the corresponding reference of role in 
				 *the pair list of glue owning current simple connector*/
				for(Pair p : this.glue.getPairList()){
					System.out.println("[INFO] "+this.getName()+" In method notifyObserver :In a cycle to find the associated role of observer found.");
					toNotify=(Observer)p.get(ob);
					break;
				}
				System.out.println("[INFO] "+this.getName()+" In method notifyObserver :In a cycle to find the associated role of observer found.");
			}
			
		}
		System.out.println("[INFO] "+this.getName()+" In method notifyObserver :Out a cycle to find the associated role of role which send the last notification to Configuration.");
	
		System.out.println("[INFO] "+this.getName()+" Send the notification to associated role of role which send the last notification to Configuration...");
		 toNotify.update(this, message);		
	}

}
