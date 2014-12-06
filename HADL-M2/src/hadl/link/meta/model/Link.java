package hadl.link.meta.model;

abstract class Link {
	private String name;

	public String getName() {
		return name;
	}

	public Link(String name) {
		this.name = name;
	}
}