package models;

import models.Machine;

/**
 * Repr�sente une op�ration.
 * 
 * @author J�r�mi CHEVALLIER
 */
public class Operation
{
	/**
	 * Num�ro unique de l'op�ration.
	 */
	private int num;
		
	/**
	 * Type de l'op�ration (lettre, exemple : t pour tournage, f pour fraisage ...).
	 */
	private char type;
		
	/**
	 * Type de machine concern� par l'op�ration.
	 */
	private TypeMachine typeMachine;
	
	/**
	 * Construit une op�ration simple.
	 * 
	 * @param num Num�ro unique de l'op�ration.
	 * @param type Type de l'op�ration (lettre, exemple : t pour tournage, ...)
	 * @param typeMachine Type de machine concern� par l'op�ration.
	 */
	public Operation(int num, char type, TypeMachine typeMachine)
	{
		this.num = num;
		this.type = type;
		this.typeMachine = typeMachine;
	}
	
	/**
	 * Retourne le num�ro unique de l'op�ration.
	 * 
	 * @return Num�ro unique de l'op�ration.
	 */
	public int getNum()
	{
		return this.num;
	}
	
	/**
	 * Retourne le type de machine concern� par l'op�ration.
	 * 
	 * @return Type de machine concern�.
	 */
	public TypeMachine getTypeMachine()
	{
		return this.typeMachine;
	}
	
	@Override
	public String toString()
	{
		return this.num + " - " + this.type;
	}
		
	@Override
	public boolean equals(Object o)
	{
		return this.num == ((Operation)o).getNum();
	}
}
	
	
