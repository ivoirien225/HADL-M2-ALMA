package hadl.utils.meta.model;

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
		
		if(this.firstObject.equals(obj)){
			return this.secondObject;
		}
		else {
			return this.firstObject;
		}
		
	}
}
