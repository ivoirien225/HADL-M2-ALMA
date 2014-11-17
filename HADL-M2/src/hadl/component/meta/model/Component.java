package hadl.component.meta.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;

import java.util.ArrayList;
import java.util.List;

public interface Component {

	public List<PortProvided> portProvided = new ArrayList<PortProvided>();
	public List<PortRequired> portRequired = new ArrayList<PortRequired>();
	
	public List<ServiceProvided> serviceProvided = new ArrayList<ServiceProvided>();
	public List<ServiceRequired> Required = new ArrayList<ServiceRequired>();
	
}
