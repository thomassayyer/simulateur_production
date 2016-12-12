package models;

/**
 * Représente un type de machine.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class TypeMachine
{
	/**
	 * Numéro unique représentant le type de machine.
	 */
	private int num;
	
	/**
	 * Libellé du type de machine.
	 */
	private String libelle;
	
	/**
	 * Constructeur paramétré dont on spécifie le numéro et le libellé du type de
	 * machine.
	 * 
	 * @param num Numéro du type de machine.
	 * @param libelle Libellé du type de machine.
	 */
	public TypeMachine(int num, String libelle)
	{
		this.num = num;
		this.libelle = libelle;
	}
	
	/**
	 * Retourne le numéro du type de machine.
	 * 
	 * @return Numéro du type de machine.
	 */
	public int getNum()
	{
		return this.num;
	}
	
	/**
	 * Retourne le libellé du type de machine.
	 * 
	 * @return Libellé du type de machine.
	 */
	public String getLibelle()
	{
		return this.libelle;
	}
	
	@Override
	public String toString()
	{
		return this.num + " - " + this.libelle;
	}
}
