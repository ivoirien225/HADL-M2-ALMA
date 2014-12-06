package hadl.interfaces.meta.model;

import hadl.tools.interfaces.Observer;

public class Role_Required extends Role {

	@Override
	public boolean notifyObservers() {
		return false;
	}

	@Override
	public boolean addObserver(Observer ob) {
		return false;
	}

	@Override
	public boolean deleteObserver(Observer ob) {
		return false;
	}
	
}
