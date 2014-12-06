package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;
import hadl.connector.meta.model.Connector;

public class Configuration extends Connector{
	
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
}
