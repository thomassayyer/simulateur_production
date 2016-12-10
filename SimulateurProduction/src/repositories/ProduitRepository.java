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
	 * Constructeur non paramétré qui instancie la liste chainée vide.
	 */
	public ProduitRepository()
	{
		this.produits = new LinkedList<Produit>();
	}
	
	/**
	 * Constructeur paramétré avec liste de produits.
	 * 
	 * @param produits Produits à ajouter dans la liste chainée.
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
	 * Ajoute un produit dans la liste chainée.
	 * 
	 * @param p Produit à ajouter.
	 * @return Vrai si le produit a été ajouté; faux sinon.
	 */
	public boolean ajouterProduit(Produit produit) throws Exception
	{
		for (Produit p : produits)
		{
			if (p.getId() == produit.getId())
			{
				throw new Exception("Un Produit porte déjà cet identifiant.");
			}
		}
		return this.produits.add(produit);
	}
	
	/**
	 * Retire un produit de la liste chainée.
	 * 
	 * @param p Produit à retirer.
	 * @return Vrai si le produit a été retiré; faux sinon.
	 */
	public boolean retirerProduit(Produit p)
	{
		return this.produits.remove(p);
	}
}
