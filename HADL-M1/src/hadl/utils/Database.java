package hadl.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Database {
	@XmlElement
	Client client;
	
	@XmlElement
	Commande commande;
	public Database(){};
	public Database(Client client, Commande commande) {
		this.client = client;
		this.commande = commande;
	}
	@Override
	public String toString() {
		return "Database "+client.toString()+ " " +commande.toString()+"]";
	}
	
	public Client getClient() {
		return client;
	}
	public Commande getCommande() {
		return commande;
	}
}
