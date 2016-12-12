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
}
