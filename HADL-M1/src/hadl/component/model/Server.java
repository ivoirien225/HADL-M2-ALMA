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

public class Server extends Configuration implements Observable, Observer{

	public List<Observer> observers =  new ArrayList<Observer>();
	
	public Server(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired,
			List<Connector> listConnector, List<Component> listComponent,
			List<Link> listLink) {
		super(name, portProvided, portRequired, serviceProvided, serviceRequired,
				listConnector, listComponent, listLink);
	}
	
	
	public Server(String name) {
		super(name);
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
		try {
			Logger.loggerWritter(this, "update", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try{
			notifyObservers(observable, message);
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
		try {
			Logger.loggerWritter(this, "notifyObservers", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		Observer toNotify = null;
		for(Observer ob : observers){
			if(ob.equals((Observer)observable)){
				//Search the corresponding element of the current object in 
				//the list of link of the configuration
				for(Link l : getListLink()){
					if(l.getInterfaces().exist(ob)){
						toNotify=(Observer)l.getInterfaces().get(ob);
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
