package hadl.component.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Connector;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;


public class Configuration extends Component implements Observable{
	
	List<Observer> listObservable = new ArrayList<Observer>();
	
	public Configuration(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required,
			List<Connector> listConnector,
			List<Component> listComponent) {
		super(name, portProvided, portRequired, serviceProvided, required);
		this.listComponent = listComponent;
		this.listConnector = listConnector;
				
		// TODO Auto-generated constructor stub
	}

	private List<Connector> listConnector = new ArrayList<Connector>();
	private List<Component> listComponent = new ArrayList<Component>();


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

	@Override
	public String callService(String nameService) {
		return null;
	}

	@Override
	public boolean notifyObservers() {
		// TODO Auto-generated method stub
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
