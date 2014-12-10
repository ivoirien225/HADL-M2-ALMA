package hadl.component.meta.model;

import java.util.ArrayList;
import java.util.List;
import hadl.connector.meta.model.Connector;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.link.meta.model.Link;

public class Configuration extends Component{

	private List<Connector> listConnector = new ArrayList<Connector>();
	private List<Component> listComponent = new ArrayList<Component>();
	List<Link> listLink = new ArrayList<Link>();

	public Configuration(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired,
			List<Connector> listConnector,
			List<Component> listComponent, List<Link> listLink){
		super(name, portProvided, portRequired, serviceProvided, serviceRequired);
		this.listComponent = listComponent;
		this.listConnector = listConnector;
		this.listLink = listLink;
	}

	public Configuration(String name) {
		super(name);
	}

	public List<Connector> getListConnector() {
		return listConnector;
	}

	public void setListConnector(List<Connector> listConnector) {
		this.listConnector = listConnector;
	}

	public List<Component> getListComponent() {
		return listComponent;
	}

	public void setListComponent(List<Component> listComponent) {
		this.listComponent = listComponent;
	}
	
	public List<Link> getAttachement() {
		return this.listLink;
	}

	public void setAttachement(List<Link> listLink) {
		this.listLink = listLink;
	}
	
	public List<Link> getListLink() {
		return listLink;
	}

	public void setListLink(List<Link> listLink) {
		this.listLink = listLink;
	}
	
	public void addComponent(Component component){
		this.listComponent.add(component);
	}
	
	public void addConnector(Connector connector){
		this.listConnector.add(connector);
	}
	
	public void addLink(Link link){
		this.listLink.add(link);
	}
}
