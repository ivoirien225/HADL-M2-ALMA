package hadl.tools.interfaces;

import hadl.utils.Message;

public interface Observable {
	public void notifyObservers(Observable observable, Message message);
	public void addObserver(Observer ob);
	public void deleteObserver(Observer ob);
}
