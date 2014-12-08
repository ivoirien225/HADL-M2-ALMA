package hadl.component.model;

import java.util.ArrayList;
import java.util.List;

import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;

public class Client extends SimpleComponent implements Observable, Observer{
	
	List<Observer> listObserver = new ArrayList<Observer>();
	Message  response; 
	public Client(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
	}

	@Override
	public void update(Observable observable, Message message){
		if(observable instanceof PortRequired){
			this.response = message;
			afficheReponse(message);
		}
		else{
			logExceptionOnConsol("update");
		}
	}
	

	@Override
	public void notifyObservers(Observable observable, Message message) {
		for(Observer o : listObserver){
			o.update(this, message);
		}
	}

	@Override
	public void addObserver(Observer ob) {
		this.listObserver.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		this.listObserver.remove(ob);
	}
	
	public void afficheReponse(Message response){
		System.out.println("La reponse � la requ�te "+response.getName()+" est: "+response.getName()+response.getResponse());	
	}
	
	public void logExceptionOnConsol(String methode){
		System.out.println("Erreur � l'appel de la m�thode :"+methode);
	}
}
