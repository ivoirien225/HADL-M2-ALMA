package hadl.link.meta.model;

import hadl.utils.meta.model.Pair;

public class Binding extends Link {
	Pair interfaces;
	
	public Binding(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Binding(String name, Pair interfaces) {
		super(name);
		this.interfaces = interfaces;
	}
	
}
