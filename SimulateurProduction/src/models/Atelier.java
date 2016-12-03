package models;

import java.util.List;

/**
 * Représente un atelier de machines.
 * 
 * @author Thomas SAYER
 */
public class Atelier
{
	/**
	 * Machines dans l'atelier.
	 */
	private List<Machine> machines;
	
	/**
	 * Construit un nouvel atelier de machines.
	 * 
	 * @param machines Liste de machines dans l'atelier.
	 */
	public Atelier(List<Machine> machines)
	{
		this.machines = machines;
	}
}
