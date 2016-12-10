package repositories;

import java.util.LinkedList;
import java.util.List;

import models.Gamme;
import models.Produit;

/**
 * Stock une liste de produits disponibles.
 * 
 * @author Mialy ANDRIAMIARANTSOANAVALONA
 * @version 1.0
 */
public class ProduitRepository
{
	/**
	 * Liste de produits.
	 */
	private List<Produit> produits;
	
	/**
	 * Constructeur non param�tr� qui instancie la liste chain�e vide.
	 */
	public ProduitRepository()
	{
		this.produits = new LinkedList<Produit>();
	}
	
	/**
	 * Constructeur param�tr� avec liste de produits.
	 * 
	 * @param produits Produits � ajouter dans la liste chain�e.
	 */
	public ProduitRepository(List<Produit> produits)
	{
		this();
		
		for (Produit p : produits)
		{
			this.produits.add(p);
		}
	}
	
	/**
	 * Ajoute un produit dans la liste chain�e.
	 * 
	 * @param p Produit � ajouter.
	 * @return Vrai si le produit a �t� ajout�; faux sinon.
	 */
	public boolean ajouterProduit(Produit produit) throws Exception
	{
		for (Produit p : produits)
		{
			if (p.getId() == produit.getId())
			{
				throw new Exception("Un Produit porte d�j� cet identifiant.");
			}
		}
		return this.produits.add(produit);
	}
	
	/**
	 * Retire un produit de la liste chain�e.
	 * 
	 * @param p Produit � retirer.
	 * @return Vrai si le produit a �t� retir�; faux sinon.
	 */
	public boolean retirerProduit(Produit p)
	{
		return this.produits.remove(p);
	}
}
