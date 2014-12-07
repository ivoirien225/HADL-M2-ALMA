package hadl.tools.interfaces;

import hadl.tools.message.Message;

public interface Observable {
	public void notifyObservers(Observable observable, Message message);
	public void addObserver(Observer ob);
	public void deleteObserver(Observer ob);
}
