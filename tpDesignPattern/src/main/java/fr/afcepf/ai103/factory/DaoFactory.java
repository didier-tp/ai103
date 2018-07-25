package fr.afcepf.ai103.factory;

import java.util.ResourceBundle;

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
		ProductDao productDao=null; //type de retour = interface ou classe abstraite
		
		/*
		//version 1 (sans fichier de config):
		productDao = new ProductDaoSimu();
		//ou bien 
		//productDao = new ProductDaoJdbc();
		//ou bien productDao = new ProductDaoJpa();
		*/
		
		//version 2 (avec config.properties)
		ResourceBundle ressources = ResourceBundle.getBundle("config") ; // config.properties
		String productDaoImplClassName = ressources.getString("ProductDao.impl"); 
		/*
		// version 2.a (sans astuce):
		switch(productDaoImplClassName) {
			case "fr.afcepf.ai103.dao.ProductDaoJdbc":
				productDao = new ProductDaoJdbc();
				break;
			case "fr.afcepf.ai103.dao.ProductDaoSimu":
			default:
				productDao = new ProductDaoSimu();
		}*/
		//version 2.b (avec astuce connue):
		try {
			productDao = (ProductDao) Class.forName(productDaoImplClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDao;
	}

}
