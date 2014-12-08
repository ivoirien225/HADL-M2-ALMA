package hadl.interfaces.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hadl.component.meta.model.Configuration;
import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Logger;
import hadl.utils.Message;

public class PortProvidedM extends PortProvided implements Observable, Observer {

	public List<Observer> observers = new ArrayList<Observer>();
	
	public PortProvidedM(String name) {
		super(name);
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
			if(observable instanceof SimpleComponent ){
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
							}						}
					}
				}
				
			}else{
					if(observable instanceof Configuration ){
						for(Observer ob: observers){
							if(ob instanceof SimpleComponent){
								try{
									Logger.loggerWritter(this, "notifyObservers", message);
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
