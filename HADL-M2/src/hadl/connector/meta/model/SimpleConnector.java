package hadl.connector.meta.model;


public class SimpleConnector extends Connector {

	private Glue glue;
	
	public SimpleConnector(String name, Glue glue) {
		this.name = name;
		this.glue = glue;
	}
	public Glue getGlue() {
		return glue;
	}
	public void setGlue(Glue glue) {
		this.glue = glue;
	}
}