package hadl.link.meta.model;

import hadl.utils.meta.model.Pair;

public class Binding extends Link {
	public Pair getInterfaces() {
		return interfaces;
	}

	Pair interfaces;

	public Binding(String name, Pair interfaces) {
		super(name);
		this.interfaces = interfaces;
	}
	
}
