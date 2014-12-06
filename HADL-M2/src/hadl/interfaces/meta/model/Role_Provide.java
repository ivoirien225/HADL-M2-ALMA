package hadl.interfaces.meta.model;

import hadl.tools.interfaces.Observer;

public class Role_Provide extends Role {

	@Override
	public boolean notifyObservers() {
		return false;
	}

	@Override
	public boolean addObserver(Observer ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		return false;
	}

}
