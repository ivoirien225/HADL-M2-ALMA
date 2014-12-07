package hadl.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produit {
	@XmlElement
	String name;
	
	@XmlElement
	String description;

	public Produit() {
	}
	
	public Produit(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Produit [name=" + name + ", description=" + description + "]";
	}
}
