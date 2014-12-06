package hadl.connector.meta.model;

import java.util.HashMap;
import java.util.Map;
import hadl.utils.meta.model.Pair;

public class Glue{
	
	Map<String,Pair> pairMap = new HashMap<String, Pair>(); 
	
	public Glue(Map<String,Pair> pairMap) {
		this.pairMap = pairMap;
	}
}
