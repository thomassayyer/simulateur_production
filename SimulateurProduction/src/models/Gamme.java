package models;

import java.util.LinkedList;
import java.util.List;

import auxiliary.comparators.PhasesComparator;

/**
 * Représente une gamme (suite d'opération memant à un produit).
 * 
 * @author Jérémi CHEVALLIER
 * @version 1.0
 */
public class Gamme
{	
	/**
	 * Phases dans la gamme.
	 */
	private List<Phase> phases;
	
	/**
	 * Numéro de la gamme.
	 */
	private int num;
	
	/**
	 * Constructeur initialisant une gamme vide muni d'un numéro unique.
	 * 
	 * @param num Numéro unique de la gamme à créer.
	 */
	public Gamme(int num) 
	{
		this.phases = new LinkedList<Phase>();
		this.num = num;
	}
	
	/**
	 * Ordonne les phases de la gamme selon les critères définis dans le PhasesComparator.
	 * 
	 * @see auxiliary.comparators.PhasesComparator
	 */
	public void ordonnerPhases()
	{
		this.phases.sort(new PhasesComparator());
	}
	
	/**
	 * Ajout d'une phase à la fin de la liste.
	 * 
	 * @param p Phase à ajouter.
	 * @return Vrai si la phase a été ajouée; faux sinon.
	 */
	public boolean ajoutPhase(Phase p) throws Exception
	{
		for (Phase ph : this.phases)
		{
			if (ph.equals(p))
			{
				throw new Exception("Cette phase a déjà été ajoutée.");
			}
		}
		
		return phases.add(p);
	}
	
	/**
	 * Retourne le numéro de la gamme.
	 * 
	 * @return Numéro de la gamme.
	 */
	public int getNum(){
		return this.num;
	}
	
	/**
	 * Retourne le nombre de phases présentes dans la gamme.
	 * 
	 * @return Nombre de phases de la gamme.
	 */
	public int getNbPhases()
	{
		return this.phases.size();
	}
	
	/**
	 * Retourne la phase à l'index défini en paramètre.
	 * 
	 * @param index Index de la phase à récupérer.
	 * @return La phase à l'index "index".
	 */
	public Phase getPhase(int index)
	{		
		return this.phases.get(index);
	}
	
	/**
	 * Retourne la position d'une phase dans la liste.
	 * 
	 * @param phase Phase de laquelle récupérer la position.
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
