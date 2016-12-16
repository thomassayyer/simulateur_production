package models;

/**
 * Repr�sente une phase (op�ration � un instant t pour une gamme).
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Phase
{
	/**
	 * Num�ro unique de la phase (permet d'ordonner les phases dans une gamme).
	 * 
	 * @see auxiliary.comparators.PhasesComparator
	 */
	private int num;
	
	/**
	 * Op�ration concern�e par la phase.
	 */
	private Operation operation;
	
	/**
	 * Dur�e de la phase (en min.).
	 */
	private double duree;
	
	/**
	 * Construit une nouvelle phase simple.
	 * 
	 * @param num Num�ro unique de la phase (permet d'ordonner les phases dans la gamme).
	 * @param o Op�ration concern�e par la phase.
	 * @param d Dur�e de la phase.
	 */
	public Phase(int num, Operation o, double d)
	{
		this.num = num;
		this.operation = o;
		this.duree = d;
	}
	
	/**
	 * Retourne l'op�ration de la phase.
	 * 
	 * @return Op�ration concern�e par la phase.
	 */
	public Operation getOperation()
	{
		return this.operation;
	}
	
	/**
	 * Retourne le num�ro de la phase.
	 * 
	 * @return Le num�ro de la phase (permet d'ordonner la liste des phases dans la gamme).
	 */
	public int getNum()
	{
		return this.num;
	}
	
	/**
	 * Retourne la dur�e de la phase.
	 * 
	 * @return Dur�e de la phase (en min.).
	 */
	public double getDuree()
	{
		return this.duree;
	}
	
	public String toString()
	{
		return this.num + " - " + this.duree + " (" + this.operation + ")";
	}
	
	public boolean equals(Object o)
	{
		return this.num == ((Phase)o).getNum();
	}
	
}
