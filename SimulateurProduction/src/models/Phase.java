package models;

/**
 * Représente une phase (opération à un instant t pour une gamme).
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Phase
{
	/**
	 * Numéro unique de la phase (permet d'ordonner les phases dans une gamme).
	 * 
	 * @see auxiliary.comparators.PhasesComparator
	 */
	private int num;
	
	/**
	 * Opération concernée par la phase.
	 */
	private Operation operation;
	
	/**
	 * Durée de la phase (en min.).
	 */
	private double duree;
	
	/**
	 * Construit une nouvelle phase simple.
	 * 
	 * @param num Numéro unique de la phase (permet d'ordonner les phases dans la gamme).
	 * @param o Opération concernée par la phase.
	 * @param d Durée de la phase.
	 */
	public Phase(int num, Operation o, double d)
	{
		this.num = num;
		this.operation = o;
		this.duree = d;
	}
	
	/**
	 * Retourne l'opération de la phase.
	 * 
	 * @return Opération concernée par la phase.
	 */
	public Operation getOperation()
	{
		return this.operation;
	}
	
	/**
	 * Retourne le numéro de la phase.
	 * 
	 * @return Le numéro de la phase (permet d'ordonner la liste des phases dans la gamme).
	 */
	public int getNum()
	{
		return this.num;
	}
	
	/**
	 * Retourne la durée de la phase.
	 * 
	 * @return Durée de la phase (en min.).
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
