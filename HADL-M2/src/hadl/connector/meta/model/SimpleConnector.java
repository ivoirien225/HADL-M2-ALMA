package hadl.connector.meta.model;

import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;
import java.util.List;

public class SimpleConnector extends Connector {
	
	protected Glue glue;
	
	public SimpleConnector(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required, Glue glue) {
		super(name, listRole_Provide, listRole_Required);
		this.glue = glue;
	}
	
	public SimpleConnector(String name) {
		super(name);
	}

	public Glue getGlue() {
		return glue;
	}
	
	private void setGlue(Glue glue) {
		this.glue = glue;
	}
	
	public void addGlue(Glue glue){
		this.setGlue(glue);
	}
}