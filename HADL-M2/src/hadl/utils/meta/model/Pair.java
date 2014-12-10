package hadl.utils.meta.model;

import hadl.interfaces.meta.model.PortProvided;


public class Pair {
	
	private Object firstObject;
	private Object secondObject;
	
	public Pair(Object firstObject, Object secondObject) {
		this.firstObject = firstObject;
		this.secondObject = secondObject;
	}
	public Object getFirstObject() {
		return firstObject;
	}
	public Object getSecondObject() {
		return secondObject;
	}

	public void setFirstObject(Object firstObject) {
		this.firstObject = firstObject;
	}
	public void setSecondObject(Object secondObject) {
		this.secondObject = secondObject;
	}
	
	/**Permit to obtain object associated to a object.
	 * To achieve this the methode need to the object couple.
	 * 
	 * @param obj Id to find its associated object 
	 * * @return The associated object of obj
	 */
	public Object get(Object obj){
		
		if(this.getFirstObject().equals(obj)){
			return this.getSecondObject();
		}
		else{
			if(this.getSecondObject().equals(obj)){
				return this.getFirstObject();
			}
		}
		return null;
		
	} 
	
	public boolean exist(Object ob){
		
		return (this.getFirstObject()== ob)||(this.getSecondObject()== ob); 
		
	}
	
	public static void main(String[] args) {
		PortProvided server = new PortProvided("serverPortProvided");
		PortProvided connectionManager = new PortProvided("connectionManagerPort");
		//Pair interfaces = new Pair(server,connectionManager);
		Pair interfaces = new Pair(connectionManager,server);
		
		System.out.println(interfaces.get(server));
		System.out.println(interfaces.get(connectionManager));
		System.out.println(interfaces.exist(connectionManager));
	}
}
