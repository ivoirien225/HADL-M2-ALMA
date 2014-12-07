package hadl.interfaces.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.tools.message.Message;

public class PortProvidedM extends PortProvided implements Observable, Observer {

	public PortProvidedM(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable observable, Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers(Observable observable, Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObserver(Observer ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		
	}

}
