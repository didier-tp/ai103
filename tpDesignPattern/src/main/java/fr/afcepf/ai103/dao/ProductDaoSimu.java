package fr.afcepf.ai103.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.afcepf.ai103.data.Produit;

public class ProductDaoSimu implements ProductDao {
	
	private Map<Long,Produit> mapProduits= new HashMap<Long,Produit>();
	private Long lastNumero;
	
	ProductDaoSimu(){
		mapProduits.put(1L, new Produit(1L,"p1", 2.5));
		mapProduits.put(2L, new Produit(2L,"p2", 3.5));
		lastNumero=2L;
	}
	@Override
	public Produit insererNouveauProduit(Produit p) {
		lastNumero++; //simuler auto_incr
		p.setNumero(lastNumero);
		mapProduits.put(lastNumero,p);
		return p;
	}

	@Override
	public List<Produit> rechercherProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mettreAjourProduit(Produit p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerProduit(Long numero) {
		// TODO Auto-generated method stub

	}

}
