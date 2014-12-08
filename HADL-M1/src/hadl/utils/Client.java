package hadl.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	@XmlElement
	String name;
	
	@XmlElement
	int commandeId;
	
	@XmlElement
	String etat;
	
	public Client() {
	}
	public Client(String name, int commandeId, String etat) {
		this.name = name;
		this.commandeId = commandeId;
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Client [name=" + name + ", commandeId=" + commandeId
				+ ", etat=" + etat + "]";
	}
	public String getName() {
		return name;
	}
	public int getCommandeId() {
		return commandeId;
	}
	public String getEtat() {
		return etat;
	}
	
	
}
