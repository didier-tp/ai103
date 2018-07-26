package fr.afcepf.ai103.ioc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import fr.afcepf.ai103.annotations.MyComponent;
import fr.afcepf.ai103.annotations.MyInject;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.service.ServiceProduit;

public class MyLittleInjectThechno {
	
	private static Map<String,Object> mapTypeInstance = new HashMap<String,Object>();
	
	//main temporaire (de test)
	public static void main(String[] args) {
		initialiser();
		ServiceProduit serviceProduit = (ServiceProduit) getBean((ServiceProduit.class).getName());
		for(Produit p : serviceProduit.rechercherListeProduits()) {
			System.out.println("\t" + p.toString());
		}
	}
	
	public static void initialiser() {
		instancierLeNecessaire();
		relierViaInjections();
	}
	
	public static Object getBean(String typeName) {
		return mapTypeInstance.get(typeName);
	}
	
	public static void relierViaInjections() {
		try {
			Class mc = Class.forName("fr.afcepf.ai103.service.ServiceProduitsImpl");
			Field[] tabFields = mc.getDeclaredFields();
			for(Field f : tabFields) {
				if(f.isAnnotationPresent(MyInject.class)) {
					f.setAccessible(true);
					System.out.println("MyInject detecté sur " + f.getName());
					f.set(mapTypeInstance.get("fr.afcepf.ai103.service.ServiceProduit"), 
						  mapTypeInstance.get(f.getType().getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void instancierLeNecessaire() {
		try {
			String itfName="fr.afcepf.ai103.dao.ProductDao";
			
			Class mc = Class.forName("fr.afcepf.ai103.dao.ProductDaoJdbc");
			if(mc.getAnnotation(MyComponent.class)!= null) {
				mapTypeInstance.put(itfName, mc.newInstance());
			}
			
			mc = Class.forName("fr.afcepf.ai103.dao.ProductDaoSimu");
			if(mc.getAnnotation(MyComponent.class)!= null) {
				mapTypeInstance.put(itfName, mc.newInstance());
			}
			
			String itfName2="fr.afcepf.ai103.service.ServiceProduit";
			
			Class mc2 = Class.forName("fr.afcepf.ai103.service.ServiceProduitsImpl");
			if(mc2.getAnnotation(MyComponent.class)!= null) {
				mapTypeInstance.put(itfName2, mc2.newInstance());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
