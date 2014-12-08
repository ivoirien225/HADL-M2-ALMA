package hadl.component.model;

import hadl.component.meta.model.SimpleComponent;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.Database;
import hadl.utils.Logger;
import hadl.utils.Message;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DataBase extends SimpleComponent implements Observable, Observer{
	List<Observer> listObserver = new ArrayList<Observer>();
	Message message;
	public DataBase(String name, List<PortProvided> portProvided,
			List<PortRequired> portRequired,
			List<ServiceProvided> serviceProvided,
			List<ServiceRequired> required) {
		super(name, portProvided, portRequired, serviceProvided, required);
	}

	public File baseFile = new File("Repository/database_file.xml");

	@Override
	public void update(Observable observable, Message mes) {
		if(observable instanceof PortProvided){
			this.message = this.resolveRequest(mes);
			notifyObservers(observable,this.message);
			try {
				Logger.loggerWritter(this, "update", message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				Logger.loggerExceptionWritter(this, "update", message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void notifyObservers(Observable observable, Message response) {
		for(Observer o : this.listObserver){
			try{
			o.update(this, response);
			Logger.loggerWritter(this, "notifyObservers", message);
			}catch(Exception e){
				try {
					Logger.loggerExceptionWritter(this, "notifyObservers", message);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
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
				String table, constraint, result = null;
				table = req.params.get(0);
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
}
