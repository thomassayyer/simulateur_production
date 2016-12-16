package repositories;

import java.util.LinkedList;
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
	/**
	 * Instance singleton du Repository.
	 */
	private static GammeRepository instance;
	
	/**
	 * Retourne l'instance singleton du Repository.
	 * 
	 * @return Instance singleton du Repository.
	 */
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
	
	/**
	 * Retourne la liste de toutes les gammes présentes dans l'entrepôt.
	 * 
	 * @return Liste de toutes les gammes présentes dans l'entrepôt.
	 */
	public List<Gamme> getGammes()
	{
		return new LinkedList<Gamme>(this.list);
	}
}
