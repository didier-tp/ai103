package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Produit;

/* DAO  = Data Access Object 
 * = objet de traitement specialise dans l'acces aux donnees
 * avec methodes CRUD : Create , Recherche , Update , Delete
 */
public interface ProductDao {
    public Produit insererNouveauProduit(Produit p);
    public List<Produit> rechercherProduits();
    //... autres recherches ...
    public void mettreAjourProduit(Produit p);
    public void supprimerProduit(Long numero);
}
