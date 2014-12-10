package hadl.link.meta.model;

import hadl.utils.meta.model.Pair;

public abstract class Link {
	
	private String name;
	private Pair interfaces;

	public String getName() {
		return name;
	}

	public Link(String name, Pair interfaces) {
		super();
		this.name = name;
		this.interfaces = interfaces;
	}

	public Link(String name) {
		this.name = name;
	}

	public Pair getInterfaces() {
		return interfaces;
	}
}