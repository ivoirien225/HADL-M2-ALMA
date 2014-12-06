package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;
import hadl.connector.meta.model.Connector;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;

public class Configuration extends Connector implements Observable{
	
	List<Connector> listConnector = new ArrayList<Connector>();
	
	public Configuration() {
	}

	public Configuration(String name, List<Connector> listConnector) {
		this.name = name;
		this.listConnector = listConnector;
	}

	public List<Connector> getListConnector() {
		return listConnector;
	}

	public void setListConnector(List<Connector> listConnector) {
		this.listConnector = listConnector;
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
