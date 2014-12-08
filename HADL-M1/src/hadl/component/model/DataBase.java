package hadl.component.model;

import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Database;
import hadl.utils.Message;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DataBase extends SimpleComponent implements Observable, Observer{
	List<Observer> listObserver;
	Message message;
	public DataBase(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
	}

	public File baseFile = new File("Repository/database_file.xml");
	

	@Override
	public void update(Observable observable, Message message) {
		if(observable instanceof PortProvided){
			this.message = this.resolveRequest(message);
		}
	}
	
	@Override
	public void notifyObservers(Observable observable, Message response) {
		for(Observer o : this.listObserver){
			o.update(this, response);
		}
	}

	@Override
	public void addObserver(Observer ob) {
		this.listObserver.add(ob);
	}

	@Override
	public void deleteObserver(Observer ob) {
		this.listObserver.remove(ob);
	}
	
	public Message resolveRequest(Message req){
		if(req.isRequest){
			if(req.name.equals("SELECT")){
				String table, valueRequested, constraint, result = null;
				table = req.params.get(0);
				valueRequested = req.params.get(1);
				constraint = req.params.get(2);
				try{
					JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					Database database = (Database) jaxbUnmarshaller.unmarshal(new File("Repository/database_file.xml"));
					if(database.getClient().getClass().getSimpleName().equals(table)){
						if(database.getClient().getName().equals(constraint))
							result = String.valueOf(database.getClient().getCommandeId());
							req.setResponse(result);
					}
					}catch(JAXBException e){
						e.printStackTrace();
					}
			}
		}
		return req;
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Client");
		list.add("commandeId");
		list.add("Yannis");
		Message message = new Message("SELECT", list, true, "", null);
		PortProvided pp = new PortProvided("portBase");
		List<PortProvided> listpp = new ArrayList<PortProvided>();
		listpp.add(pp);
		
		PortRequired pr = new PortRequired("portBase");
		List<PortRequired> listpr = new ArrayList<PortRequired>();
		listpr.add(pr);
		
		
		ServiceRequired sr = new ServiceRequired();
		List<ServiceRequired> listsr = new ArrayList<ServiceRequired>();
		listsr.add(sr);
		
		
		ServiceProvided sp = new ServiceProvided();
		List<ServiceProvided> listsp = new ArrayList<ServiceProvided>();
		listsp.add(sp);
		
		DataBase database = new DataBase("db", listpp, listpr, listsp, listsr);
		database.listObserver.add((Observer)pr);
		database.update(database,message);
	}
}
