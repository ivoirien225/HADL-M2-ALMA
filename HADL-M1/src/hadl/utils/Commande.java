package hadl.utils;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Commande {
	@XmlElement
	public int commandeId;
	
	@XmlElement
	Produit produit;

	public Commande() {
	}
	public Commande(int commandeId, Produit produit) {
		this.commandeId = commandeId;
		this.produit = produit;
	}
	@Override
	public String toString() {
		return "Commande [commandeId=" + commandeId + " " + produit.toString()+"]";
	}
	public int getCommandeId() {
		return commandeId;
	}
	public Produit getProduit() {
		return produit;
	}
	
}
