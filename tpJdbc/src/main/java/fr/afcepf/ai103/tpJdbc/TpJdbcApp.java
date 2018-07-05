package fr.afcepf.ai103.tpJdbc;

import java.util.List;

public class TpJdbcApp {

	public static void main(String[] args) {
		IProductDao productDao = new ProductDaoJdbc();
		
		Produit nouveauProd = new Produit(null,"nouveau produit que j'aime",2.56);
		nouveauProd = productDao.insererNouveauProduit(nouveauProd);
		System.out.println("numero du produit insere=" + nouveauProd.getNumero());
		
		Produit produit2Modifie = new Produit(2L,"super super stylo",4.23);
		productDao.mettreAjourProduit(produit2Modifie);
		
		Long numDeleted = 6L; 
	    System.out.println("avant suppression du numero " + numDeleted);
		affListProd(productDao);
		
		productDao.supprimerProduit(numDeleted);
		
		System.out.println("apres suppression du numero " + numDeleted);
		affListProd(productDao);
		
	}
	
	public static void affListProd(IProductDao productDao) {
		List<Produit> listeProd = productDao.rechercherProduits();
		if(listeProd!=null)
          for(Produit p : listeProd) {
			System.out.println(p);
		}
	}

}
