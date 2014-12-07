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
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DataBase extends SimpleComponent implements Observable, Observer{
	List<Observer> listObserver;
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
				
			}
		}
		return req;
	}
	public static void main(String[] args) {
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Database database = (Database) jaxbUnmarshaller.unmarshal(new File("Repository/database_file.xml"));
		System.out.println(database.toString());
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
