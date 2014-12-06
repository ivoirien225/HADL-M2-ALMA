package hadl.component.meta.model;

import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;

import java.util.List;


public class SimpleComponent extends Component implements Observable{

	public SimpleComponent(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean notifyObservers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addObserver(Observer ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String callService(String nameService) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
