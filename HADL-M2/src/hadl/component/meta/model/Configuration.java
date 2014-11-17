package hadl.component.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Connector;

public class Configuration implements Component, Connector {

	private List<Connector> listConnector = new ArrayList<Connector>();
	private List<Component> listComponent = new ArrayList<Component>();
	
	public Configuration() {
		// TODO Auto-generated constructor stub
	}

}
