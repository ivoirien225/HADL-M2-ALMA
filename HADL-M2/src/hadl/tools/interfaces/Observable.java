package hadl.tools.interfaces;

public interface Observable {
	public boolean notifyObservers();
	public boolean addObserver(Observer ob);
	public boolean deleteObserver(Observer ob);
}
