package fr.afcepf.ai103.dao;

import java.util.ArrayList;
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

	public Produit insererNouveauProduit(Produit p) {
		lastNumero++; //simuler auto_incr
		p.setNumero(lastNumero);
		mapProduits.put(lastNumero,p);
		return p;
	}

	public List<Produit> rechercherProduits() {
		return new ArrayList<Produit>(mapProduits.values());
	}

	public void mettreAjourProduit(Produit p) {
		mapProduits.put(p.getNumero(),p);
	}


	public void supprimerProduit(Long numero) {
		mapProduits.remove(numero);
	}
}
