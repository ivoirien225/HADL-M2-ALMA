package hadl.connector.meta.model;

import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;

import java.util.List;

public class SimpleConnector extends Connector {
	
	public SimpleConnector(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required, Glue glue) {
		super(name, listRole_Provide, listRole_Required);
		this.glue = glue;
	}

	protected Glue glue;

	public Glue getGlue() {
		return glue;
	}
	
	public void setGlue(Glue glue) {
		this.glue = glue;
	}
	
}