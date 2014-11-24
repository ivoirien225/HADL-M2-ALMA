package hadl.connector.meta.model;



public class SimpleConnector extends Connector {

	Glue glue = new Glue();
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
	@Override
	public String caller() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String callee() {
		// TODO Auto-generated method stub
		return null;
	}

}
