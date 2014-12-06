package hadl.interfaces.meta.model;

import hadl.tools.interfaces.Observable;

public abstract class Port extends Interface implements Observable{
	public abstract String send();
	public abstract String receive();
}