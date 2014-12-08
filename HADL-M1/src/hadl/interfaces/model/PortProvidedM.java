package hadl.interfaces.model;

import java.util.ArrayList;
import java.util.List;

import hadl.component.meta.model.Configuration;
import hadl.component.meta.model.SimpleComponent;
import hadl.component.model.Client;
import hadl.component.model.Server;
import hadl.interfaces.meta.model.PortProvided;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;

public class PortProvidedM extends PortProvided implements Observable, Observer {

	public List<Observer> observers = new ArrayList<Observer>();
	
	public PortProvidedM(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
		System.out.println("[INFO] "+this.getName()+" In method notifyObservers.");
			if(observable instanceof SimpleComponent ){
				System.out.println("[INFO] "+this.getName()+" The Sender of notification is a simple component.");
				for(Observer ob: observers){
					System.out.println("[INFO] "+this.getName()+" Searching of the configuration reference to transmit him the message.");
					if(ob instanceof Configuration){
						System.out.println("[INFO] "+this.getName()+" Configuration found.");
						System.out.println("[INFO] "+this.getName()+" Notification send to Configuration.");
						ob.update(this, message);
						break;
					}
				}
				
			}else{
				
					if(observable instanceof Configuration ){
						System.out.println("[INFO] "+this.getName()+" The Sender of notification is a simple component.");
						for(Observer ob: observers){
							System.out.println("[INFO] "+this.getName()+"Searching of the simple component reference to transmit him the message.");
							if(ob instanceof SimpleComponent){
								System.out.println("[INFO] "+this.getName()+" Simple component found.");
								System.out.println("[INFO] "+this.getName()+" Notification send to Simple component.");
								//ob.update(this, message);
								System.out.println("[INFO] Message Arrived"+message+"on port {"+this.getName()+"}");
								break;
							}
						}
					}
			}
			System.out.println("[INFO] "+this.getName()+" Out of method notifyObservers.");
	}
	
	@Override
	public void addObserver(Observer ob) {
		// TODO Auto-generated method stub
		System.out.println("[INFO]"+this.name+" In addObserver");
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.remove(ob);
	}
}
