package hadl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hadl.component.meta.model.Component;
import hadl.component.model.Client;
import hadl.component.model.ConnectionManager;
import hadl.component.model.DataBase;
import hadl.component.model.GlobalConfig;
import hadl.component.model.Server;
import hadl.connector.meta.model.Connector;
import hadl.connector.model.GlueRPC;
import hadl.connector.model.GlueSQLQUERY;
import hadl.connector.model.RPC;
import hadl.connector.model.SqlQuery;
import hadl.interfaces.meta.model.PortProvided;
import hadl.interfaces.meta.model.PortRequired;
import hadl.interfaces.meta.model.Role_Provide;
import hadl.interfaces.meta.model.Role_Required;
import hadl.interfaces.meta.model.ServiceProvided;
import hadl.interfaces.meta.model.ServiceRequired;
import hadl.interfaces.model.PortProvidedM;
import hadl.interfaces.model.PortRequiredM;
import hadl.interfaces.model.RoleProvidedM;
import hadl.interfaces.model.RoleRequiredM;
import hadl.interfaces.model.ServiceProvidedM;
import hadl.interfaces.model.ServiceRequiredM;
import hadl.link.meta.model.Attachement;
import hadl.link.meta.model.Binding;
import hadl.link.meta.model.Link;
import hadl.tools.interfaces.Observer;
import hadl.utils.Message;
import hadl.utils.meta.model.Pair;

public class Launcher {
	
	public static void init(){
		

		/////////////////////////////Databases////////////////////////////////////
		
		List<PortProvided> listPortProvided = new ArrayList<PortProvided>();
		PortProvidedM portProvidedDB = new PortProvidedM("port fourni BD");
		listPortProvided.add(portProvidedDB);


		List<PortRequired> listportRequired = new ArrayList<PortRequired>();
		PortRequiredM portRequired = new PortRequiredM("port requis BD");
		listportRequired.add(portRequired);


		List<ServiceProvided> listserviceProvided = new ArrayList<ServiceProvided>();
		ServiceProvidedM serviceProvided = new ServiceProvidedM("service fourni BD");
		listserviceProvided.add(serviceProvided);

		List<ServiceRequired> listServiceRequired = new ArrayList<ServiceRequired>();
		ServiceRequiredM serviceRequired = new ServiceRequiredM("service requis BD");
		listServiceRequired.add(serviceRequired);

		DataBase database = new DataBase("HADL", listPortProvided, listportRequired, listserviceProvided, listServiceRequired);
		
		
		//////////////////Connection Manager///////////////////////////
		
		PortProvidedM externalSocket = new PortProvidedM("externalSocket");
		PortRequiredM dbQuery = new PortRequiredM("dbQuery"); 
		ConnectionManager connectionManager = new ConnectionManager("ConnectionManager", new ArrayList<PortProvided>(Arrays.asList(externalSocket)), new ArrayList<PortRequired>(Arrays.asList(dbQuery)), null, null);
		
	
		//////////////Sql Query connector////////////////////////////////////////
		
		RoleProvidedM rolePSqlQuery = new RoleProvidedM("rolePSqlQuery");
		RoleRequiredM roleRSqlQuery = new RoleRequiredM("roleRSqlQuery");
		GlueSQLQUERY SqlQueryCon = new GlueSQLQUERY("Glue SqlQuery", new ArrayList<Pair>(Arrays.asList(new Pair(rolePSqlQuery, roleRSqlQuery))));
		SqlQuery conSqlQuery =  new SqlQuery("conSqlQuery", new ArrayList<Role_Provide>(Arrays.asList(rolePSqlQuery)), new ArrayList<Role_Required>(Arrays.asList(roleRSqlQuery)), SqlQueryCon);
		
		//////////////////////Attachment of serveurConfig////////////////////////////
		
		Attachement Manager2ConnectorSql = new Attachement("Manager2ConnectorSql", new Pair(dbQuery, rolePSqlQuery));
		Attachement Db2ConnectorSql = new Attachement("Db2ConnectorSql", new Pair(portProvidedDB, roleRSqlQuery));
		
		
		//////////////////Server//////////////////////////////////////
		PortProvidedM receiveRequest = new PortProvidedM("receiveRequest");		
		Binding serverBinding = new Binding("request-externalSoket", new Pair(receiveRequest,externalSocket)); 
		Server server = new Server("ServerConfig",  new ArrayList<PortProvided>(Arrays.asList(receiveRequest)), null, null, null, new ArrayList<Connector>(Arrays.asList(conSqlQuery)), new ArrayList<Component>(Arrays.asList(database,connectionManager)), new ArrayList<Link>(Arrays.asList(serverBinding,Db2ConnectorSql,Manager2ConnectorSql)));
		
		/**
		 * Initializing server components 
		 */
		
		server.getListComponent().add(database);
		server.getListComponent().add(connectionManager);
		
		server.getListLink().add(serverBinding);
		server.getListLink().add(Db2ConnectorSql);
		server.getListLink().add(Manager2ConnectorSql);
		server.getListConnector().add(conSqlQuery);
		
		///////////////////PortClient///////////////////////////////////////
		PortRequiredM sendRequest = new PortRequiredM("sendRequest");
		
		///////////////////////////RoleRPC//////////////////////////////////////////
		RoleProvidedM roleP = new RoleProvidedM("Role Provided RPC");
		RoleRequiredM roleR = new RoleRequiredM("Role Required RPC");
		GlueRPC glueRPC = new GlueRPC("Glue RPC ", new ArrayList<Pair>(Arrays.asList(new Pair(roleP, roleR))));
		RPC rpc = new RPC("RPC",  new ArrayList<Role_Provide>(Arrays.asList(roleP)),  new ArrayList<Role_Required>(Arrays.asList(roleR)), glueRPC);
		///////////////////////////RoleSqlQuery///////////////////////////////////////
						
		
		
		//////////////////////////Attachment Server GlobalConfig////////////////////////////
		
		Attachement clientRPC = new Attachement("clientRPC", new Pair(sendRequest, roleP));
		Attachement RPCServeur = new Attachement("RPCServeur", new Pair(roleR, receiveRequest));
		
		//Pair interfaces = new Pair(server,connectionManager);
		
		Pair interfaces = new Pair(connectionManager,connectionManager);//Condition d'arret sinon boucle "petit test"
		Binding bd =new Binding("portserverPortConnectionManager", interfaces);
		
		////////////////Client///////////////////////
		
		List<String> listParam = new ArrayList<String>();
		listParam.add("Client");
		listParam.add("commandeId");
		listParam.add("Yannis");
		Message resquest = new Message("SELECT", listParam, true, "", null);
		
		List<PortRequired> clientPortProvided = new ArrayList<PortRequired>();
		Client client = new Client("Client", null, clientPortProvided, null, null);
		clientPortProvided.add(sendRequest);
		client.addObserver(sendRequest);
		GlobalConfig globalConfig = new GlobalConfig("Global Config", null, null, null, null,  new ArrayList<Connector>(Arrays.asList(rpc)), new ArrayList<Component>(Arrays.asList(client,server)), new ArrayList<Link>(Arrays.asList(clientRPC,RPCServeur)));		
		
		/////////////////////////Attachment//////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////////////
		
		connectionManager.addObserver(server);
		connectionManager.addObserver(client);
		
		//srv.addObserver(server);
		server.addObserver((Observer) server.getPortProvided().get(0));
		
		client.addObserver(connectionManager);
		
		client.notifyObservers(client, resquest);
		
		/////////////////GlobalConfig////////////////////////////////
		//GlobalConfig globalConfig = new GlobalConfig();
		
	}

	public static void main(String[] args) {
		
		init();
		
	}
	
}
