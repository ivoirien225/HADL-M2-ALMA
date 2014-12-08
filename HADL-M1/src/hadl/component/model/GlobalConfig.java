package hadl.component.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hadl.component.meta.model.Component;
import hadl.component.meta.model.Configuration;
import hadl.connector.meta.model.Connector;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.link.meta.model.Link;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;

public class GlobalConfig extends Configuration implements Observable, Observer {

	public List<Observer> observers = new ArrayList<Observer>();
	
	public GlobalConfig(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired,
			List<Connector> listConnector, List<Component> listComponent,
			List<Link> listLink) {
		super(name, portProvided, portRequired, serviceProvided, serviceRequired,
				listConnector, listComponent, listLink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		observers.remove(ob);
	}

	@Override
	public void update(Observable observable, Message message) {
		try{
			notifyObservers(observable, message);
			Logger.loggerWritter(this, "update", message);
		}catch(Exception e){
			try {
				Logger.loggerExceptionWritter(this, "update", message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		Observer toNotify = null;
		for(Observer ob : observers){
			if(ob.equals((Observer)observable)){
				//Search the corresponding element of the current object in 
				//the list of link of the configuration
				for(Link l : getListLink()){
					toNotify=(Observer)l.getInterfaces().get(ob);
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
