package fr.afcepf.ai103.factory;

import fr.afcepf.ai103.dao.ProductDao;
import fr.afcepf.ai103.dao.ProductDaoJdbc;
import fr.afcepf.ai103.dao.ProductDaoSimu;

/*
 * utilisation externe:
 * version a : sans singleton:
 *    DaoFactory daoFactory = new DaoFactory();
 *    ProductDao productDao = daoFactory.createProductDao();
 *    
 * version b: avec singleton:
 *    ProductDao productDao = DaoFactory.getInstance().createProductDao();
 */
public class DaoFactory {
	
	/* method factory */
	public ProductDao createProductDao() {
		ProductDao productDao; //type de retour = interface ou classe abstraite
		
		//version 1 (sans fichier de config):
		productDao = new ProductDaoSimu();
		//ou bien 
		//productDao = new ProductDaoJdbc();
		//ou bien productDao = new ProductDaoJpa();
		
		return productDao;
	}

}
