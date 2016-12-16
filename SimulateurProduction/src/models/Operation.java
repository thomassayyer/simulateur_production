package models;

import models.Machine;

/**
 * Représente une opération.
 * 
 * @author Jérémi CHEVALLIER
 */
public class Operation
{
	/**
	 * Numéro unique de l'opération.
	 */
	private int num;
		
	/**
	 * Type de l'opération (lettre, exemple : t pour tournage, f pour fraisage ...).
	 */
	private char type;
		
	/**
	 * Type de machine concerné par l'opération.
	 */
	private TypeMachine typeMachine;
	
	/**
	 * Construit une opération simple.
	 * 
	 * @param num Numéro unique de l'opération.
	 * @param type Type de l'opération (lettre, exemple : t pour tournage, ...)
	 * @param typeMachine Type de machine concerné par l'opération.
	 */
	public Operation(int num, char type, TypeMachine typeMachine)
	{
		this.num = num;
		this.type = type;
		this.typeMachine = typeMachine;
	}
	
	/**
	 * Retourne le numéro unique de l'opération.
	 * 
	 * @return Numéro unique de l'opération.
	 */
	public int getNum()
	{
		return this.num;
	}
	
	/**
	 * Retourne le type de machine concerné par l'opération.
	 * 
	 * @return Type de machine concerné.
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
	
	
