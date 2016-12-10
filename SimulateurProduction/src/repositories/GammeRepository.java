package repositories;

import java.util.List;

import models.Gamme;

public class GammeRepository {
	
	/**
	 * Tableau des gamme
	 */
	private List<Gamme> listGamme;
	
	/**
	 * Ajoute une nouvelle gamme dans la liste
	 * @param newGamme, nouvelle gamme.
	 */
	public void AjoutGamme(Gamme gamme ) throws Exception
	{
		for (Gamme g : listGamme)
		{
			if (g.getNum() == gamme.getNum())
			{
				throw new Exception("Une gamme porte d�j� ce num�ro.");
			}
		}
		listGamme.add(gamme);
	}
	
	/**
	 * Affiche la liste des gammes
	 */
	public void AfficheGamme()
	{	
		for (int i=0 ; i<listGamme.size(); i++ )
		{
			System.out.println( i + " - " + listGamme.get(i));
		}
	}
	
	/**
	 * Getter pour la liste des op�rations
	 * @param index
	 * @return la gamme � l'index choisie
	 */
	public Gamme getGamme(int index)
	{
		return listGamme.get(index);
	}
}
