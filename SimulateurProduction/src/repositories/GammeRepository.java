package repositories;

import java.util.List;

import models.Gamme;

/**
 * Repr�sente un entrep�t de gammes.
 * 
 * @author J�r�mi Chevallier.
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
	 * R�cup�re la gamme correspondante au num�ro en param�tre.
	 * 
	 * @param num Num�ro de la gamme � r�cup�rer.
	 * @return La gamme correspondante au num�ro en param�tre.
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
