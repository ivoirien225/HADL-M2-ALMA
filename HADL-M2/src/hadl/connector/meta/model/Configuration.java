package hadl.connector.meta.model;

import java.util.List;

import hadl.connector.meta.model.Connector;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;

public class Configuration extends Connector{
	
	List<SimpleConnector> listConnector;
	
	public Configuration(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required, List<SimpleConnector> listConnector){
		super(name, listRole_Provide, listRole_Required);
		this.listConnector = listConnector;
	}
	
	public Configuration(String name) {
		super(name);
	}

	public List<SimpleConnector> getListConnector() {
		return listConnector;
	}

	public void setListConnector(List<SimpleConnector> listConnector) {
		this.listConnector = listConnector;
	}
	
	public void addSimpleConnector(SimpleConnector simpleConnector){
		this.listConnector.add(simpleConnector);
	}
	
	public void addRole_Provide(Role_Provide role_Provide){
		this.listRole_Provide.add(role_Provide);
	}
	
	public void addRole_Required(Role_Required role_Required){
		this.listRole_Required.add(role_Required);
	}
}
