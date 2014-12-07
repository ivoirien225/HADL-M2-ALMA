package hadl.component.model;

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
import hadl.tools.message.Message;

public class Server extends Configuration implements Observer, Observable{

	public List<Observer> observers;
	
	public Server(String name, List<PortProvided> portProvided,
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
		// TODO Auto-generated method stub
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
		notifyObservers(observable, message);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		// TODO Auto-generated method stub
		Observer toNotify=null;
		for(Observer ob : observers){
			
			if(ob.equals((Observer)observable)){
				//Search the corresponding element of the current object in 
				//the list of link of the configuration
				for(Link l : getListLink()){
					
					toNotify=(Observer)l.getInterfaces().get(ob);
				}
			}
		}
		toNotify.update(this, message);		
	}

	

}
