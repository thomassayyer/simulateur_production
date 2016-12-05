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
	
	/**
	 * Ajoute une machine dans l'atelier.
	 * 
	 * @param machine Machine à ajouter.
	 * @return Vrai si la machine a bien été ajoutée; faux sinon.
	 */
	public boolean ajouterMachine(Machine machine)
	{
		return this.machines.add(machine);
	}
	
	/**
	 * Retire une machine dans l'atelier.
	 * 
	 * @param machine Machine à retirer.
	 * @return Vrai si la machine a bien été retirée; faux sinon.
	 */
	public boolean retirerMachine(Machine machine)
	{
		return this.machines.remove(machine);
	}
}
