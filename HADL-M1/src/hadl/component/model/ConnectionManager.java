package hadl.component.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;

public class ConnectionManager extends SimpleComponent implements Observable,
		Observer {
	
	public List<Observer> observers = new ArrayList<Observer>();

	public ConnectionManager(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
	}

	
	
	public ConnectionManager(String name) {
		super(name);
	}



	@Override
	public void update(Observable observable, Message message) {
		
		try {
			Logger.loggerWritter(this, "update", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			notifyObservers(observable, message);
			
		} catch (Exception e) {
			try {
				Logger.loggerExceptionWritter(this, "update", message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}		}
	}

	public void notifyObservers(Observable observable, Message message) {
		try {
			Logger.loggerWritter(this, "notifyObservers", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		} 
		if(observable instanceof PortProvided){
			for(Observer ob: observers){
				if(ob instanceof PortRequired){
					try{
						ob.update(this, message);
						break;
					}catch(Exception e){
						try {
							Logger.loggerExceptionWritter(this, "notifyObservers", message);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			
		}else{
			
				if(observable instanceof PortRequired){
					try {
						Logger.loggerWritter(this, "notifyObservers", message);
					} catch (IOException e2) {
						e2.printStackTrace();
					} 
					for(Observer ob: observers){
						if(ob instanceof PortProvided){
							try{
								ob.update(this, message);
								break;
						}catch(Exception e){
							try {
								Logger.loggerExceptionWritter(this, "notifyObservers", message);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
					     }
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
