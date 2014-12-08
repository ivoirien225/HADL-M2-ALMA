package hadl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import hadl.component.model.Client;
import hadl.component.model.Server;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.model.PortProvidedM;
import hadl.link.meta.model.Binding;
import hadl.link.meta.model.Link;
import hadl.utils.meta.model.Pair;

public class Launcher {
	
	public static void init(){
		
		Client client = new Client("Client", null, null, null, null);
		PortProvidedM server = new PortProvidedM("serverPortProvided");
		PortProvidedM connectionManager = new PortProvidedM("connectionManagerPort");
		//Pair interfaces = new Pair(server,connectionManager);
		Pair interfaces = new Pair(connectionManager,connectionManager);//Condition d'arret sinon boucle "petit test"
		Binding bd =new Binding("portserverPortConnectionManager", interfaces);
		ArrayList<Link> linkListServer = new ArrayList<Link>(Arrays.asList(bd));
		List<PortProvided> portProvidedListServer = new ArrayList<PortProvided>(Arrays.asList(server));		
		
		Server srv = new Server("ServerConfig", portProvidedListServer, null, null, null, null, null, linkListServer);
		connectionManager.addObserver(srv);
		connectionManager.addObserver(client);
		
		//srv.addObserver(server);
		srv.addObserver(connectionManager);
		
		client.addObserver(connectionManager);
		
		client.notifyObservers(null, null);
		
	}

	public static void main(String[] args) {
		
		init();
		
	}
	
}
