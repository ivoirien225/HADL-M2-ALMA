package hadl.tools.interfaces;

import hadl.utils.Message;

public interface Observer {
	public void update(Observable observable, Message message);
}
