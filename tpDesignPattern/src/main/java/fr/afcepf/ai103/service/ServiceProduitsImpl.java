package fr.afcepf.ai103.service;

import java.util.List;

import fr.afcepf.ai103.dao.ProductDao;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.factory.DaoFactory;

public class ServiceProduitsImpl implements ServiceProduit {
	/* private ProductDao productDao ; avec @EJB ou @Inject */
	private ProductDao productDao = DaoFactory.getInstance().createProductDao();

	@Override
	public List<Produit> rechercherListeProduits() {
		return productDao.rechercherProduits();
	}

}
