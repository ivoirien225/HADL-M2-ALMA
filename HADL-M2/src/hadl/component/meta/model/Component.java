package hadl.component.meta.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Component{
	protected String name;
	protected List<PortProvided> portProvided = new ArrayList<PortProvided>();
	protected List<PortRequired> portRequired = new ArrayList<PortRequired>();
	
	protected List<ServiceProvided> serviceProvided = new ArrayList<ServiceProvided>();
	protected List<ServiceRequired> Required = new ArrayList<ServiceRequired>();
	
    /**
     * Constructor
     * @param 
     */
	public Component(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		this.name = name;
		this.portProvided = portProvided;
		this.portRequired = portRequired;
		this.serviceProvided = serviceProvided;
		Required = required;
	}
	
}
