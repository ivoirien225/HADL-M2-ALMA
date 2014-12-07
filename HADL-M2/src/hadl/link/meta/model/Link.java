package hadl.link.meta.model;

public abstract class Link {
	private String name;

	public String getName() {
		return name;
	}

	public Link(String name) {
		this.name = name;
	}
}