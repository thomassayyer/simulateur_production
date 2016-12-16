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
public class ProduitRepository extends Repository<Produit>
{
	/**
	 * Instance singleton du Repository.
	 */
	private static ProduitRepository instance;
	
	/**
	 * Retourne l'instance singleton du Repository.
	 * 
	 * @return Instance singleton du Repository.
	 */
	public static ProduitRepository getInstance()
	{
		if (instance == null)
		{
			instance = new ProduitRepository();
		}
		
		return (ProduitRepository)instance;
	}
	
	/**
	 * Récupère une liste de produtis en fonction d'une gamme spécifiée.
	 * 
	 * @param g La gamme des produits à récupérer.
	 * @return La liste des produits correspondant.
	 */
	public List<Produit> getProduitsByGamme(Gamme g)
	{
		List<Produit> produits = new LinkedList<Produit>();
		
		for (Produit p : this.list)
		{
			if (p.getGamme().equals(g))
			{
				produits.add(p);
			}
		}
		
		return produits;
	}
}