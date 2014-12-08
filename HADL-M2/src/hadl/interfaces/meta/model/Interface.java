package hadl.interfaces.meta.model;

public abstract class Interface {
	public String getName() {
		return name;
	}

	public String name;

	public Interface(String name) {
		this.name = name;
	}
	
}
