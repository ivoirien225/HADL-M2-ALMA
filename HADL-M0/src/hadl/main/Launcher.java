package hadl.main;

import java.util.ArrayList;
import java.util.List;
import hadl.component.model.Client;
import hadl.component.model.ConnectionManager;
import hadl.component.model.DataBase;
import hadl.component.model.GlobalConfig;
import hadl.component.model.Server;
import hadl.connector.model.GlueRPC;
import hadl.connector.model.GlueSQLQUERY;
import hadl.connector.model.RPC;
import hadl.connector.model.SqlQuery;
import hadl.interfaces.model.PortProvidedM;
import hadl.interfaces.model.PortRequiredM;
import hadl.interfaces.model.RoleProvidedM;
import hadl.interfaces.model.RoleRequiredM;
import hadl.link.meta.model.Attachement;
import hadl.link.meta.model.Binding;
import hadl.utils.Message;
import hadl.utils.meta.model.Pair;

public class Launcher {
	
	public static void init(){
		
		//////////////////Configuration Server//////////////////////////////////////
		
		Server server = new Server("ServerConfig");
		PortProvidedM receiveRequest = new PortProvidedM("receiveRequest");
		receiveRequest.addObserver(server);
		
		//////////////////Component Connection Manager///////////////////////////
				
		PortProvidedM externalSocket = new PortProvidedM("externalSocket");
		externalSocket.addObserver(server);
		PortRequiredM dbQuery = new PortRequiredM("dbQuery"); 
		dbQuery.addObserver(server);
		ConnectionManager connectionManager = new ConnectionManager("ConnectionManager");
		connectionManager.addInterface(externalSocket);
		connectionManager.addInterface(dbQuery);
		connectionManager.addObserver(externalSocket);
		connectionManager.addObserver(dbQuery);
		
		externalSocket.addObserver(connectionManager);
		dbQuery.addObserver(connectionManager);
		Binding serverBinding = new Binding("request-externalSoket", new Pair(receiveRequest,externalSocket)); 
		
		server.addObserver(receiveRequest);
		server.addObserver(externalSocket);
		server.addObserver(dbQuery);
		
		/////////////////////////////Component Databases////////////////////////////////////
		
		PortProvidedM queryIntDB = new PortProvidedM("queryIntDB");
		queryIntDB.addObserver(server);
		server.addObserver(queryIntDB);
		PortRequiredM portRequired = new PortRequiredM("port requis BD");

		DataBase database = new DataBase("HADL");
		queryIntDB.addObserver(database);
		database.addInterface(queryIntDB);
		database.addInterface(portRequired);
		database.addObserver(queryIntDB);
				
		//////////////Sql Query connector////////////////////////////////////////
		
		RoleProvidedM rolePSqlQuery = new RoleProvidedM("rolePSqlQuery");
		RoleRequiredM roleRSqlQuery = new RoleRequiredM("roleRSqlQuery");
		
		GlueSQLQUERY SqlQueryCon = new GlueSQLQUERY("Glue SqlQuery");
		SqlQueryCon.addPairToListPair(new Pair(rolePSqlQuery, roleRSqlQuery));
		
		SqlQuery conSqlQuery =  new SqlQuery("conSqlQuery");
		conSqlQuery.addGlue(SqlQueryCon);
		conSqlQuery.addRole_Provide(rolePSqlQuery);
		conSqlQuery.addRole_Required(roleRSqlQuery);
		rolePSqlQuery.addObserver(SqlQueryCon);
		roleRSqlQuery.addObserver(SqlQueryCon);
		roleRSqlQuery.addObserver(server);
		rolePSqlQuery.addObserver(server);
		server.addObserver(roleRSqlQuery);
		server.addObserver(rolePSqlQuery);
		SqlQueryCon.addObserver(roleRSqlQuery);
		SqlQueryCon.addObserver(rolePSqlQuery);
		
		//////////////////////Attachment of server Configuration////////////////////////////
		
		Attachement Manager2ConnectorSql = new Attachement("Manager2ConnectorSql", new Pair(dbQuery, rolePSqlQuery));
		Attachement Db2ConnectorSql = new Attachement("Db2ConnectorSql", new Pair(queryIntDB, roleRSqlQuery));
		
		
		
		/**
		 * Initializing server components 
		 * 
		 */
		server.addInterface(receiveRequest);
		server.addComponent(database);
		server.addComponent(connectionManager);
		
		server.addLink(serverBinding);
		server.addLink(Db2ConnectorSql);
		server.addLink(Manager2ConnectorSql);
		server.addConnector(conSqlQuery);
	
		
		///////////////////////////////Global Config/////////////////////////////////////
		GlobalConfig globalConfig = new GlobalConfig("Global Config");
		
		
		///////////////////////////ConnectorRPC//////////////////////////////////////////
		RoleProvidedM roleP = new RoleProvidedM("Role Provided RPC");
		RoleRequiredM roleR = new RoleRequiredM("Role Required RPC");
		GlueRPC glueRPC = new GlueRPC("Glue RPC ");
		glueRPC.addPairToListPair(new Pair(roleP, roleR));
		RPC rpc = new RPC("RPC");
		rpc.addGlue(glueRPC);
		rpc.addRole_Provide(roleP);
		rpc.addRole_Required(roleR);
		
		roleP.addObserver(glueRPC);
		roleP.addObserver(globalConfig);
		roleR.addObserver(glueRPC);
		roleR.addObserver(globalConfig);
		
		glueRPC.addObserver(roleR);
		glueRPC.addObserver(roleP);
		
		globalConfig.addObserver(roleR);
		globalConfig.addObserver(roleP);
		
		globalConfig.addObserver(receiveRequest);
		receiveRequest.addObserver(globalConfig);
		////////////////Client///////////////////////
		
		List<String> listParam = new ArrayList<String>();
		listParam.add("Client");
		listParam.add("commandeId");
		listParam.add("Yannis");
		Message resquest = new Message("SELECT", listParam, true, "", null);
	
		PortRequiredM sendRequest = new PortRequiredM("sendRequest");
		sendRequest.addObserver(globalConfig);
		globalConfig.addObserver(sendRequest);
		Client client = new Client("Client");
		client.addInterface(sendRequest);
		client.addObserver(sendRequest);
		sendRequest.addObserver(client);
		
		//////////////////////////Attachment GlobalConfig////////////////////////////
		
		Attachement client2RPC = new Attachement("clientRPC", new Pair(sendRequest, roleP));
		Attachement RPC2Serveur = new Attachement("RPCServeur", new Pair(roleR, receiveRequest));
				
		globalConfig.addComponent(client);
		globalConfig.addComponent(server);
		globalConfig.addConnector(rpc);
		globalConfig.addLink(client2RPC);
		globalConfig.addLink(RPC2Serveur);
		 
		System.out.println(client.getClass().getSimpleName()+" Sending request from ....");
		client.notifyObservers(client, resquest);
		
	}

	public static void main(String[] args) {
		/*
		 *  Application Launching entry point
		 */
		init();
		
	}
	
}
