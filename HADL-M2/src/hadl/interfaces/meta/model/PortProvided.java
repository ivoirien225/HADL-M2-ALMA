package hadl.interfaces.meta.model;

import hadl.tools.interfaces.Observer;

public class PortProvided extends Port{
	
	
	@Override
	public String send() {
		return null;
	}
	
	@Override
	public String receive() {
		return null;
	}

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
