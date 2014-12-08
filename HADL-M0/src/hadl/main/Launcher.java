package hadl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hadl.component.model.Client;
import hadl.component.model.ConnectionManager;
import hadl.component.model.GlobalConfig;
import hadl.component.model.Server;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.model.PortProvidedM;
import hadl.interfaces.model.PortRequiredM;
import hadl.link.meta.model.Binding;
import hadl.link.meta.model.Link;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;
import hadl.utils.meta.model.Pair;

public class Launcher {
	
	public static void init(){
		///////////////////PortServer///////////////////////////////////
		PortProvidedM receiveRequest = new PortProvidedM("receiveRequest");
		
		
		///////////////////PortClient///////////////////////////////////////
		
		
		///////////////////PortConnectionManager///////////////////////////////////////
		
		PortProvidedM externalSocket = new PortProvidedM("externalSocket");
		PortRequiredM dbQuery = new PortRequiredM("dbQuery"); 
		
		
		///////////////////////////RoleRPC//////////////////////////////////////////
		
		///////////////////////////RoleSqlQuery///////////////////////////////////////
						
		
		//////////////////////////Binding Server config////////////////////////////
		
		Binding serverBinding = new Binding("request-externalSoket", new Pair(receiveRequest,externalSocket)); 
				
		//////////////////////////Attachment Server config////////////////////////////
		
		
		//////////////////////////Binding Server GlobalConfig////////////////////////////
		
		
		//////////////////////////Attachment Server GlobalConfig////////////////////////////
				
		
		//////////////////Server//////////////////////////////////////
		Server srv = new Server("ServerConfig", portProvidedServer, null, null, null, null, null, linkListServer);
		
		
		ArrayList<Link> linkListServer = new ArrayList<Link>(Arrays.asList(bd));
				
		
		
		
		
		

		
		
		////////////////Client///////////////////////
		
		List<String> listParam = new ArrayList<String>();
		listParam.add("Client");
		listParam.add("commandeId");
		listParam.add("Yannis");
		Message resquest = new Message("SELECT", listParam, true, "", null);
		
		PortProvidedM sendRequest = new PortProvidedM("sendRequest");
		
		List<PortProvided> clientPortProvided = new ArrayList<PortProvided>();
		clientPortProvided.add(sendRequest);
		
		Client client = new Client("Client", clientPortProvided, null, null, null);
		
		client.addObserver(sendRequest);
		
		//////////////////////////////ConnectionManager////////////////////////////
		
		
		
		
		List<PortProvided> connectionManagerPortProvided = new ArrayList<PortProvided>(Arrays.asList(externalSocket));
		List<PortRequired> rPortProvided = new ArrayList<PortRequired>(Arrays.asList(dbQuery));
		
		ConnectionManager connectionManager = new ConnectionManager("ConnectionManager", portProvided, portRequired, serviceProvided, required)
		
		
		/////////////////////////////Databases////////////////////////////////////
		List<String> list = new ArrayList<String>();
		list.add("Client");
		list.add("commandeId");
		list.add("Yannis");
		
		PortProvidedM pp = new PortProvidedM("portBase");

		List<PortProvided> listpp = new ArrayList<PortProvided>();
		listpp.add(pp);

		PortRequiredM pr = new PortRequiredM("portBase");
		List<PortRequired> listpr = new ArrayList<PortRequired>();
		listpr.add(pr);

		DataBase database = new DataBase("db", listpp, listpr, null, listsr);
		database.listObserver.add(pp);

		//adding database to port observer
		pp.addObserver(database);
		pp.notifyObservers(database, message);
		
		/////////////////////////Attachment//////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////////////
		PortProvidedM connectionManager = new PortProvidedM("connectionManagerPort");
		//Pair interfaces = new Pair(server,connectionManager);
		Pair interfaces = new Pair(connectionManager,connectionManager);//Condition d'arret sinon boucle "petit test"
		Binding bd =new Binding("portserverPortConnectionManager", interfaces);
		
		connectionManager.addObserver(srv);
		connectionManager.addObserver(client);
		
		//srv.addObserver(server);
		srv.addObserver((Observer) srv.getPortProvided().get(0));
		
		client.addObserver(connectionManager);
		
		client.notifyObservers(null, null);
		
		/////////////////GlobalConfig////////////////////////////////
		//GlobalConfig globalConfig = new GlobalConfig();
		
	}

	public static void main(String[] args) {
		
		init();
		
	}
	
}
