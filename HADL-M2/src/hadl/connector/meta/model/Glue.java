package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.utils.meta.model.Pair;

public class Glue {
	
	public String getName() {
		return name;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	String name = ""; 
	List<Pair> pairList = new ArrayList<Pair>();
	
	public Glue(String name, List<Pair> pairList) {
		super();
		this.name = name;
		this.pairList = pairList;
	}
	
}
