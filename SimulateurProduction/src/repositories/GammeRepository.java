package repositories;

import java.util.List;

import models.Gamme;

/**
 * Représente un entrepôt de gammes.
 * 
 * @author Jérémi Chevallier.
 * @version 2.0
 */
public class GammeRepository extends Repository<Gamme>
{
	private static GammeRepository instance;
	
	public static GammeRepository getInstance()
	{
		if (instance == null)
		{
			instance = new GammeRepository();
		}
		
		return (GammeRepository)instance;
	}
	
	/**
	 * Récupère la gamme correspondante au numéro en paramètre.
	 * 
	 * @param num Numéro de la gamme à récupérer.
	 * @return La gamme correspondante au numéro en paramètre.
	 */
	public Gamme getGamme(int num)
	{
		for (Gamme g : this.list)
		{
			if (g.getNum() == num)
			{
				return g;
			}
		}
		
		return null;
	}
	
	public List<Gamme> getGammes()
	{
		return this.list;
	}
}
