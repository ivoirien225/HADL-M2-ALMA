package hadl.component.meta.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;

import java.util.ArrayList;
import java.util.List;


public class SimpleComponent extends Component{
	
	List<PortProvided> portProvided = new ArrayList<PortProvided>();
	List<PortRequired> portRequired = new ArrayList<PortRequired>();
	List<ServiceProvided> serviceProvided = new ArrayList<ServiceProvided>();
	List<ServiceRequired> serviceRequired = new ArrayList<ServiceRequired>();
	
	public SimpleComponent() {
	}

	public SimpleComponent(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> serviceRequired) {
		this.name = name;
		this.portProvided = portProvided;
		this.portRequired = portRequired;
		this.serviceProvided = serviceProvided;
		this.serviceRequired = serviceRequired;
	}

	public List<PortProvided> getPortProvided() {
		return portProvided;
	}

	public void setPortProvided(List<PortProvided> portProvided) {
		this.portProvided = portProvided;
	}

	public List<PortRequired> getPortRequired() {
		return portRequired;
	}

	public void setPortRequired(List<PortRequired> portRequired) {
		this.portRequired = portRequired;
	}

	public List<ServiceProvided> getServiceProvided() {
		return serviceProvided;
	}

	public void setServiceProvided(List<ServiceProvided> serviceProvided) {
		this.serviceProvided = serviceProvided;
	}

	public List<ServiceRequired> getServiceRequired() {
		return serviceRequired;
	}

	public void setServiceRequired(List<ServiceRequired> serviceRequired) {
		this.serviceRequired = serviceRequired;
	}

	public String getName() {
		return name;
	}

	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String receiveMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
