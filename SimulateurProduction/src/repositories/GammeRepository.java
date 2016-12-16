package repositories;

import java.util.LinkedList;
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
	
	/**
	 * Retourne la liste de toutes les gammes pr�sentes dans l'entrep�t.
	 * 
	 * @return Liste de toutes les gammes pr�sentes dans l'entrep�t.
	 */
	public List<Gamme> getGammes()
	{
		return new LinkedList<Gamme>(this.list);
	}
}
