package hadl.connector.meta.model;

import java.util.ArrayList;
import java.util.List;

import hadl.utils.meta.model.Pair;

public class Glue {
	

	private String name;
	private List<Pair> pairList = new ArrayList<Pair>();
	
	public Glue(String name, List<Pair> pairList) {
		this.name = name;
		this.pairList = pairList;
	}
	
	public String getName() {
		return name;
	}

	public List<Pair> getPairList() {
		return pairList;
	}
	
	public void addPairToListPair(Pair pair){
		this.pairList.add(pair);
	}
}
