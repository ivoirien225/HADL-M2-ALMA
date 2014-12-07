package hadl.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Message {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public boolean isRequest() {
		return isRequest;
	}

	public void setRequest(boolean isRequest) {
		this.isRequest = isRequest;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<String> getListRoute() {
		return listRoute;
	}

	public void setListRoute(List<String> listRoute) {
		this.listRoute = listRoute;
	}

	public String name;
	public List<String> params = new ArrayList<String>();
	public boolean isRequest;
	public String response;
	public List<String> listRoute = new LinkedList<String>();
	
	public Message(String name, List<String> params, boolean isRequest,
			String response, List<String> listRoute) {
		super();
		this.name = name;
		this.params = params;
		this.isRequest = isRequest;
		this.response = response;
		this.listRoute = listRoute;
	}
	
	
}
