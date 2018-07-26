package fr.afcepf.ai103.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.service.ServiceProduit;
import fr.afcepf.ai103.service.ServiceProduitsImpl;

public class TestService {
	
	private ServiceProduit serviceProduit = null; //à tester
	
	@Before
	public void initService() {
		this.serviceProduit = new ServiceProduitsImpl();
	}
	
	@Test
	public void testRecherche() {
		
		List<Produit> listeProd = serviceProduit.rechercherListeProduits();
		if(listeProd!=null)
          for(Produit p : listeProd) {
			System.out.println(p);
		}
		
	}
	

}
