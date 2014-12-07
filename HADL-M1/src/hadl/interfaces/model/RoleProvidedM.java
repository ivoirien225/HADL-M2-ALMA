package hadl.interfaces.model;

import hadl.interfaces.meta.model.Role_Provide;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;

public class RoleProvidedM extends Role_Provide implements Observable, Observer{

	public RoleProvidedM(String name) {
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
