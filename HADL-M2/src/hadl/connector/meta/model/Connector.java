package hadl.connector.meta.model;

import hadl.interfaces.meta.model.Role_Required;
import hadl.interfaces.meta.model.Role_Provide;
import java.util.ArrayList;
import java.util.List;

public abstract class Connector {
	String name = null;
	List<Role_Provide> listRole_Provide = new ArrayList<Role_Provide>();
	List<Role_Required> listRole_Required = new ArrayList<Role_Required>();
	public abstract String caller();
	public abstract String callee();
}
