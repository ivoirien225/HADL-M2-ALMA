package hadl.utils.meta.model;

public class Pair {
	
	Object firstObject;
	Object secondObject;
	
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
	 * @param obj 
	 * @param couple Containing the object associated to obj 
	 * @return The associated object of obj
	 */
	public static Object get(Object obj , Pair couple){
		
		if(couple.firstObject.equals(obj)){
			return couple.secondObject;
		}
		else {
			return couple.firstObject;
		}
		
	}
}
