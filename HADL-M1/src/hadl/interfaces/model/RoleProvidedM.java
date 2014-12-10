package hadl.interfaces.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hadl.component.meta.model.Configuration;
import hadl.connector.meta.model.SimpleConnector;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;

public class RoleProvidedM extends Role_Provide implements Observable, Observer{

	public List<Observer> getObservers() {
		return observers;
	}

	public List<Observer> observers = new ArrayList<Observer>();
	
	public RoleProvidedM(String name) {
		super(name);
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		try {
			Logger.loggerWritter(this, "notifyObservers", message);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		if(observable instanceof SimpleConnector ){
			for(Observer ob: observers){
				if(ob instanceof Configuration){
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
			
				if(observable instanceof Configuration ){
					try {
						Logger.loggerWritter(this, "notifyObservers", message);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					for(Observer ob: observers){
						if(ob instanceof SimpleConnector){
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

}
