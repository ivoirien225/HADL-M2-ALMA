package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.utils.meta.model.Pair;

public class Glue {
	
	public String getNameS() {
		return nameS;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	String nameS = ""; 
	List<Pair> pairList = new ArrayList<Pair>();
	
	public Glue(String nameS, List<Pair> pairList) {
		super();
		this.nameS = nameS;
		this.pairList = pairList;
	}
	
}
