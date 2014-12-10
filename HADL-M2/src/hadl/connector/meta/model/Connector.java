package hadl.connector.meta.model;

import hadl.interfaces.meta.model.Role_Required;
import hadl.interfaces.meta.model.Role_Provide;
import java.util.ArrayList;
import java.util.List;

public abstract class Connector{
	String name;
	List<Role_Provide> listRole_Provide = new ArrayList<Role_Provide>();
	List<Role_Required> listRole_Required = new ArrayList<Role_Required>();
	
	public Connector(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required) {
		super();
		this.name = name;
		this.listRole_Provide = listRole_Provide;
		this.listRole_Required = listRole_Required;
	}
	
	public Connector(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public List<Role_Provide> getListRole_Provide() {
		return listRole_Provide;
	}
	public List<Role_Required> getListRole_Required() {
		return listRole_Required;
	}
	
	public void addRole_Provide(Role_Provide role_Provide){
		this.listRole_Provide.add(role_Provide);
	}
	
	public void addRole_Required(Role_Required role_Required){
		this.listRole_Required.add(role_Required);
	}
}
