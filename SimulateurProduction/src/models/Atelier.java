package models;

import java.util.List;

/**
 * Repr�sente un atelier de machines.
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
	
	/**
	 * Ajoute une machine dans l'atelier.
	 * 
	 * @param machine Machine � ajouter.
	 * @return Vrai si la machine a bien �t� ajout�e; faux sinon.
	 */
	public boolean ajouterMachine(Machine machine)
	{
		return this.machines.add(machine);
	}
	
	/**
	 * Retire une machine dans l'atelier.
	 * 
	 * @param machine Machine � retirer.
	 * @return Vrai si la machine a bien �t� retir�e; faux sinon.
	 */
	public boolean retirerMachine(Machine machine)
	{
		return this.machines.remove(machine);
	}
}
