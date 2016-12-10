package models;

/**
 * Repr�sente un type de machine.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class TypeMachine
{
	/**
	 * Num�ro unique repr�sentant le type de machine.
	 */
	private int num;
	
	/**
	 * Libell� du type de machine.
	 */
	private String libelle;
	
	/**
	 * Constructeur param�tr� dont on sp�cifie le num�ro et le libell� du type de
	 * machine.
	 * 
	 * @param num Num�ro du type de machine.
	 * @param libelle Libell� du type de machine.
	 */
	public TypeMachine(int num, String libelle)
	{
		this.num = num;
		this.libelle = libelle;
	}
}
