package hadl.component.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.connector.meta.model.Connector;

public class Configuration extends Component {

	private List<Connector> listConnector = new ArrayList<Connector>();
	private List<Component> listComponent = new ArrayList<Component>();
	
	public Configuration() {}

	public Configuration(String name, List<Connector> listConnector,
			List<Component> listComponent) {
		this.name = name;
		this.listConnector = listConnector;
		this.listComponent = listComponent;
	}

	public String getName() {
		return name;
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
	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String receiveMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
