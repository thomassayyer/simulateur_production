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
	public static ProduitRepository getInstance()
	{
		if (instance == null)
		{
			instance = new ProduitRepository();
		}
		
		return (ProduitRepository)instance;
	}
	
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