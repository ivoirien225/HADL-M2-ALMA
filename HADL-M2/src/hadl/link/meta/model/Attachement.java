package hadl.link.meta.model;

import hadl.utils.meta.model.Pair;

public class Attachement extends Link {
	Pair interfaces;

	public Attachement(String name, Pair interfaces) {
		super(name);
		this.interfaces = interfaces;
	}
}
