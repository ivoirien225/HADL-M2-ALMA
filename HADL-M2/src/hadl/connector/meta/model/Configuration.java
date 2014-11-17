package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Connector;

public class Configuration implements Connector {
	
	List<Connector> listConnector = new ArrayList<Connector>();
	
	public Configuration() {}
	
}
