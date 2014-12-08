package hadl.interfaces.model;

import java.util.ArrayList;
import java.util.List;
import hadl.component.meta.model.Configuration;
import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;

public class PortProvidedM extends PortProvided implements Observable, Observer {

	public List<Observer> observers = new ArrayList<Observer>();
	
	public PortProvidedM(String name) {
		super(name);
	}

	@Override
	public void update(Observable observable, Message message) {
		notifyObservers(observable, message);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
			if(observable instanceof SimpleComponent ){
				for(Observer ob: observers){
					if(ob instanceof Configuration){
						ob.update(this, message);
						break;
					}
				}
				
			}else{
					if(observable instanceof Configuration ){
						for(Observer ob: observers){
							if(ob instanceof SimpleComponent){
								ob.update(this, message);
								break;
							}
						}
					}
			}
	}
	
	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		observers.remove(ob);
	}
}
