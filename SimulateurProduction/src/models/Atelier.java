package models;

import java.util.LinkedList;
import java.util.List;

/**
 * Représente un atelier de machines.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Atelier
{
	/**
	 * Machines dans l'atelier.
	 */
	private List<Machine> machines;
	
	/**
	 * Construit un nouvel atelier vide (sans machine).
	 */
	public Atelier()
	{
		this.machines = new LinkedList<Machine>();
	}
	
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
	public boolean ajouterMachine(Machine machine) throws Exception
	{
		for (Machine m : this.machines)
		{
			if (m.getNum() == machine.getNum())
			{
				throw new Exception("Une machine porte déjà ce numéro.");
			}
		}
		
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
	
	/**
	 * Retourne la liste des machines présentes dans l'atelier.
	 * 
	 * @return Liste des machines présentes dans l'atelier.
	 */
	public List<Machine> getMachines()
	{
		return this.machines;
	}
}
