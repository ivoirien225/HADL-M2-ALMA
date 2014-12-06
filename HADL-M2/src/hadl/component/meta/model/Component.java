package hadl.component.meta.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import java.util.ArrayList;
import java.util.List;

public abstract class Component{
	private String name;
	private List<PortProvided> portProvided = new ArrayList<PortProvided>();
	private List<PortRequired> portRequired = new ArrayList<PortRequired>();
	private List<ServiceProvided> serviceProvided = new ArrayList<ServiceProvided>();
	private List<ServiceRequired> serviceRequired = new ArrayList<ServiceRequired>();
	
    /**
     * Constructor
     * @param 
     */
	public Component(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired) {
		this.name = name;
		this.portProvided = portProvided;
		this.portRequired = portRequired;
		this.serviceProvided = serviceProvided;
		this.serviceRequired = serviceRequired;
	}

	public String getName() {
		return name;
	}

	public List<PortProvided> getPortProvided() {
		return portProvided;
	}

	public List<PortRequired> getPortRequired() {
		return portRequired;
	}

	public List<ServiceProvided> getServiceProvided() {
		return serviceProvided;
	}

	public List<ServiceRequired> getServiceRequired() {
		return serviceRequired;
	}
	public abstract String callService(String nameService);
	

}