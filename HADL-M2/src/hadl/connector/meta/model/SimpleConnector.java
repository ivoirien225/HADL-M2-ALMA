package hadl.connector.meta.model;

import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;

public class SimpleConnector extends Connector implements Observable{

	private Glue glue;
	
	public SimpleConnector(String name, Glue glue) {
		this.name = name;
		this.glue = glue;
	}
	public Glue getGlue() {
		return glue;
	}
	public void setGlue(Glue glue) {
		this.glue = glue;
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
