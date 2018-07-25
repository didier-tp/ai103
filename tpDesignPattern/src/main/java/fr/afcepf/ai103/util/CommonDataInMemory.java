package fr.afcepf.ai103.util;

import java.util.HashMap;
import java.util.Map;

public class CommonDataInMemory {

	/* Singleton : une seule instance pour une certaine classe : ici CommonDataInMemory */
	private static CommonDataInMemory uniqueInstance = null;
	
	public static synchronized CommonDataInMemory getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new CommonDataInMemory();
		}
		return uniqueInstance;
	}
	private CommonDataInMemory() {
		//constructeur privé pour interdire new CommonDataInMemory() depuis une autre classe
		//et obliger à appeler CommonDataInMemory.getInstance();
	}
	
	private Map<String,Object> mapOfAttributes = new HashMap<String,Object>();
	
	public Object getAttribute(String key) {
		return mapOfAttributes.get(key);
	}
	
	public void setAttribute(String key,Object obj) {
		mapOfAttributes.put(key,obj);
	}
	
}
