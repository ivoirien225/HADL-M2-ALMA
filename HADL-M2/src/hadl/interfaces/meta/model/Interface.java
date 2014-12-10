package hadl.interfaces.meta.model;

public abstract class Interface {
	
	public String name;
	
	public String getName() {
		return name;
	}

	public Interface(String name) {
		this.name = name;
	}
	
}
