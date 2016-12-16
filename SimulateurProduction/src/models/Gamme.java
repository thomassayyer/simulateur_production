package models;

import java.util.LinkedList;
import java.util.List;

import auxiliary.comparators.PhasesComparator;

/**
 * Repr�sente une gamme (suite d'op�ration memant � un produit).
 * 
 * @author J�r�mi CHEVALLIER
 * @version 1.0
 */
public class Gamme
{	
	/**
	 * Phases dans la gamme.
	 */
	private List<Phase> phases;
	
	/**
	 * Num�ro de la gamme.
	 */
	private int num;
	
	/**
	 * Constructeur initialisant une gamme vide muni d'un num�ro unique.
	 * 
	 * @param num Num�ro unique de la gamme � cr�er.
	 */
	public Gamme(int num) 
	{
		this.phases = new LinkedList<Phase>();
		this.num = num;
	}
	
	/**
	 * Ordonne les phases de la gamme selon les crit�res d�finis dans le PhasesComparator.
	 * 
	 * @see auxiliary.comparators.PhasesComparator
	 */
	public void ordonnerPhases()
	{
		this.phases.sort(new PhasesComparator());
	}
	
	/**
	 * Ajout d'une phase � la fin de la liste.
	 * 
	 * @param p Phase � ajouter.
	 * @return Vrai si la phase a �t� ajou�e; faux sinon.
	 */
	public boolean ajoutPhase(Phase p) throws Exception
	{
		for (Phase ph : this.phases)
		{
			if (ph.equals(p))
			{
				throw new Exception("Cette phase a d�j� �t� ajout�e.");
			}
		}
		
		return phases.add(p);
	}
	
	/**
	 * Retourne le num�ro de la gamme.
	 * 
	 * @return Num�ro de la gamme.
	 */
	public int getNum(){
		return this.num;
	}
	
	/**
	 * Retourne le nombre de phases pr�sentes dans la gamme.
	 * 
	 * @return Nombre de phases de la gamme.
	 */
	public int getNbPhases()
	{
		return this.phases.size();
	}
	
	/**
	 * Retourne la phase � l'index d�fini en param�tre.
	 * 
	 * @param index Index de la phase � r�cup�rer.
	 * @return La phase � l'index "index".
	 */
	public Phase getPhase(int index)
	{		
		return this.phases.get(index);
	}
	
	/**
	 * Retourne la position d'une phase dans la liste.
	 * 
	 * @param phase Phase de laquelle r�cup�rer la position.
	 * @return Index de la position de la phase dans la liste.
	 */
	public int getPosPhase(Phase phase)
	{
		return phases.indexOf(phase);
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.num);
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.num == ((Gamme)o).getNum();
	}
	
}
