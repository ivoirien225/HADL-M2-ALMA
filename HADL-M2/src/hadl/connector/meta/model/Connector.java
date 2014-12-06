package hadl.connector.meta.model;

import hadl.interfaces.meta.model.Role_Required;
import hadl.interfaces.meta.model.Role_Provide;
import java.util.ArrayList;
import java.util.List;

public abstract class Connector{
	String name = null;
	List<Role_Provide> listRole_Provide = new ArrayList<Role_Provide>();
	List<Role_Required> listRole_Required = new ArrayList<Role_Required>();
	public String getName() {
		return name;
	}
	public List<Role_Provide> getListRole_Provide() {
		return listRole_Provide;
	}
	public List<Role_Required> getListRole_Required() {
		return listRole_Required;
	}
}
