package hadl.component.model;

import java.util.ArrayList;
import java.util.List;
import hadl.component.meta.model.Component;
import hadl.connector.meta.model.Connector;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.link.meta.model.Link;
import hadl.tools.interfaces.Observer;

public class Server extends GlobalConfig{

	public List<Observer> observers =  new ArrayList<Observer>();
	
	public Server(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired,
			List<Connector> listConnector, List<Component> listComponent,
			List<Link> listLink) {
		super(name, portProvided, portRequired, serviceProvided, serviceRequired,
				listConnector, listComponent, listLink);
	}
	
	
	public Server(String name) {
		super(name);
	}

}
