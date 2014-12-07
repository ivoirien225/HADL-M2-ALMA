package hadl.tools.interfaces;

import hadl.tools.message.Message;


public interface Observer {
	public void update(Observable observable, Message message);
}
