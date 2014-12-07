package hadl.tools.interfaces;

public interface Observable {
	public void notifyObservers();
	public void addObserver(Observer ob);
	public void deleteObserver(Observer ob);
}
