package hadl.component.model;

import hadl.utils.Database;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DataBase{

	public File baseFile = new File("Repository/database_file.xml");
	public DataBase(){
			
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
