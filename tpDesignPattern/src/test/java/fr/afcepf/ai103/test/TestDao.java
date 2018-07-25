package fr.afcepf.ai103.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.ai103.dao.ProductDao;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.factory.DaoFactory;

public class TestDao {
	
	private ProductDao productDao = null; //à tester
	
	@Before
	public void initDao() {
		//version originale sans Fabrique ni singleton:
		//this.productDao = new ProductDaoJdbc();
		
		//version a : avec DaoFactory et sans singleton:
		//DaoFactory daoFactory = new DaoFactory();
		//this.productDao = daoFactory.createProductDao();//dao construit en version JDBC ou Simu ou JPA
		
		//version b : avec Singleton sur classe de Facbrique "DaoFactory":
		this.productDao = DaoFactory.getInstance().createProductDao();
		
	}
	
	@Test
	public void testCRUD() {
		Produit nouveauProd = new Produit(null,"nouveau produit que j'aime",2.56);
		nouveauProd = productDao.insererNouveauProduit(nouveauProd);
		System.out.println("numero du produit insere=" + nouveauProd.getNumero());
		Assert.assertTrue(nouveauProd.getNumero()>0);
		
		Produit produit2Modifie = new Produit(2L,"super super stylo",4.23);
		productDao.mettreAjourProduit(produit2Modifie);
		
		Long numDeleted = 6L; 
	    System.out.println("avant suppression du numero " + numDeleted);
		affListProd(productDao);
		
		productDao.supprimerProduit(numDeleted);
		
		System.out.println("apres suppression du numero " + numDeleted);
		affListProd(productDao);
		
	}
	
	
	public static void affListProd(ProductDao productDao) {
		List<Produit> listeProd = productDao.rechercherProduits();
		if(listeProd!=null)
          for(Produit p : listeProd) {
			System.out.println(p);
		}
	}

}
