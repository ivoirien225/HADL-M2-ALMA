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
}
