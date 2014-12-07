package hadl.interfaces.model;

import java.util.List;

import hadl.interfaces.meta.model.PortRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;

public class PortRequiredM extends PortRequired implements Observable, Observer{

	List<Observer> observers;
	
	public PortRequiredM(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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

	@Override
	public void update(Observable observable, Message message) {
		// TODO Auto-generated method stub
		
	}

}
