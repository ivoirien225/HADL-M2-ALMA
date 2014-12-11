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

public class Client extends SimpleComponent implements Observable, Observer{
	
	List<Observer> listObserver = new ArrayList<Observer>();
	Message  response; 
	
	public Client(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
	}

	
	
	public Client(String name) {
		super(name);
	}

	@Override
	public void update(Observable observable, Message message){
		try {
			Logger.loggerWritter(this, "update", message);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(observable instanceof PortRequired){
			this.response = message;
			System.out.println("Acknowledgment of receipt\nResult of my request = "+this.response.response);
		}
		else{
			try {
				Logger.loggerExceptionWritter(this, "update", message);
			} catch (IOException e) {
				e.printStackTrace();
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
		for(Observer o : listObserver){
		  try{
			  o.update(this, message);
		  }catch(Exception e){
			  try {
				Logger.loggerExceptionWritter(this, "notifyObservers", message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  }
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
}
