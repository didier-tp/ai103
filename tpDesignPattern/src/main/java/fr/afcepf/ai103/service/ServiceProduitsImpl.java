package fr.afcepf.ai103.service;

import java.util.List;

import fr.afcepf.ai103.annotations.MyComponent;
import fr.afcepf.ai103.annotations.MyInject;
import fr.afcepf.ai103.dao.ProductDao;
import fr.afcepf.ai103.data.Produit;

@MyComponent
public class ServiceProduitsImpl implements ServiceProduit {
	
	
	// l'annotation @MyInject ou un equivalent est un simple paramétrage
	// qui n'est utile que si c'est interprété/analysé par une technologie .
	
	// @MyInject (ou @Inject) demande à cette technologie d'initialiser la
	// référence en référencant un composant existant compatible avec l'interface
	
	/* ou bien avec @EJB des EJB3 ou @Inject de CDI ou @Autowired de Spring */
	@MyInject(comment="pour paramétrer besoin injection de dépendance") 
	private ProductDao productDao ; // sans @Inject ou @MyInject ça resterait à null .
	
	
	/*// sans injection de dépendances
	private ProductDao productDao = DaoFactory.getInstance().createProductDao();
	*/
	
	public ServiceProduitsImpl(){
		System.out.println("ServiceProduitsImpl");
	}

	@Override
	public List<Produit> rechercherListeProduits() {
		return productDao.rechercherProduits();
	}

}
