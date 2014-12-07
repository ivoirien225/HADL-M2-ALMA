package hadl.interfaces.model;

import java.util.List;

import hadl.component.model.Client;
import hadl.component.model.Server;
import hadl.interfaces.meta.model.PortProvided;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.tools.message.Message;

public class PortProvidedM extends PortProvided implements Observable, Observer {

	public List<Observer> observers;
	
	public PortProvidedM(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable observable, Message message) {
		// TODO Auto-generated method stub
		notifyObservers(observable, message);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		// TODO Auto-generated method stub
		
			if(observable instanceof Client ){
				
				for(Observer ob: observers){
					if(ob instanceof Server){
						ob.update(this, message);
					}
				}
				
			}else{
				
					if(observable instanceof Server ){
						
						for(Observer ob: observers){
							if(ob instanceof Client){
								ob.update(this, message);
							}
						}
					}
			}
			
	}
	
	@Override
	public void addObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.remove(ob);
	}
}
