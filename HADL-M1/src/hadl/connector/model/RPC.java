package hadl.connector.model;

import hadl.connector.meta.model.Glue;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;

import java.util.List;

public class RPC extends SimpleConnectorOO{

	public RPC(String name, List<Role_Provide> listRole_Provide,
			List<Role_Required> listRole_Required, Glue glue) {
		super(name, listRole_Provide, listRole_Required, glue);
		// TODO Auto-generated constructor stub
	}

}
