package hadl.interfaces.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hadl.component.meta.model.Configuration;
import hadl.connector.meta.model.Glue;
import hadl.connector.meta.model.SimpleConnector;
import hadl.interfaces.meta.model.Role_Required;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;

public class RoleRequiredM extends Role_Required implements Observable, Observer{

	public List<Observer> getObservers() {
		return observers;
	}

	public List<Observer> observers = new ArrayList<Observer>();
	
	public RoleRequiredM(String name){
		super(name);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		if(observable instanceof SimpleConnector ){
			for(Observer ob: observers){
				if(ob instanceof Configuration){
					try{
						Logger.loggerWritter(this, "notifyObservers", message);
						ob.update(this, message);
						break;
					}catch(Exception e){
						try {
							Logger.loggerExceptionWritter(this, "notifyObservers", message);
						} catch (IOException e1) {
							e1.printStackTrace();
						}}
				}
			}
			
		}else{
			
				if(observable instanceof Configuration ){
					for(Observer ob: observers){
						if(ob instanceof SimpleConnector){
							try{
								Logger.loggerWritter(this, "notifyObservers", message);
								ob.update(this, message);
								break;
							}catch(Exception e){
								try {
									Logger.loggerExceptionWritter(this, "notifyObservers", message);
								} catch (IOException e1) {
									e1.printStackTrace();
								}}
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

}
