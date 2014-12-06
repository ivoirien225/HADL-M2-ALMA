package hadl.connector.meta.model;

import java.util.HashMap;
import java.util.Map;
import hadl.tools.interfaces.Observable;
import hadl.tools.interfaces.Observer;
import hadl.utils.meta.model.Pair;

public class Glue implements Observable{
	
	Map<String,Pair> pairMap = new HashMap<String, Pair>(); 
	
	public Glue(Map<String,Pair> pairMap) {
		this.pairMap = pairMap;
	}

	@Override
	public boolean notifyObservers() {
		return false;
	}

	@Override
	public boolean addObserver(Observer ob) {
		return false;
	}

	@Override
	public boolean deleteObserver(Observer ob) {
		return false;
	}

	public Map<String, Pair> getPairMap() {
		return pairMap;
	}
}
