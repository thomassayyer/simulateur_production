package repositories;

import java.util.LinkedList;
import java.util.List;

import auxiliary.comparators.MachinesTempsComparator;
import models.Gamme;
import models.Machine;
import models.Phase;
import models.Produit;
import models.TypeMachine;

/**
 * Représente un atelier de machines.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Atelier extends Repository<Machine>
{
	/**
	 * Instance singleton de l'atelier.
	 */
	private static Atelier instance;
	
	/**
	 * Retourne l'instance singleton de l'atelier.
	 * 
	 * @return Instance singleton de l'atelier.
	 */
	public static Atelier getInstance()
	{
		if (instance == null)
		{
			instance = new Atelier();
		}
		
		return (Atelier)instance;
	}
	
	/**
	 * Retourne une liste de machines dont le type est spécifié en paramètre.
	 * 
	 * @param type Type de machine des machines à récupérer.
	 * @return Liste des machines du type correspondant.
	 */
	public List<Machine> getMachinesByType(TypeMachine type)
	{
		List<Machine> machines = new LinkedList<Machine>();
		
		for (Machine m : this.list)
		{
			if (m.getType().equals(type))
			{
				machines.add(m);
			}
		}
		
		return machines;
	}
	
	/**
	 * Récupère la machine correspondante au numéro en paramètre.
	 * 
	 * @param numero Numéro de la machine à récupérer.
	 * @return Machine correspondante au numéro en paramètre.
	 */
	public Machine getMachine(int numero)
	{
		for (Machine m : this.list)
		{
			if (m.getNum() == numero)
			{
				return m;
			}
		}
		
		return null;
	}
	
	/**
	 * Lance la simulation de toutes les machines présentent dans l'atelier.
	 */
	public void lancerSimulation()
	{
		for (Machine m : this.list)
		{
			m.lancerSimulation();
		}
	}
	
	/**
	 * Détermine si l'atelier possède encore des machine avec du stock de produit.
	 * 
	 * @return Vrai si une ou plusieurs machines possèdent encore du stock; faux sinon.
	 */
	public boolean hasMachinesAvecStock()
	{
		for (Machine m : this.list)
		{
			if (m.getStockSize() > 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Retourne la liste des machines présentent dans l'atelier.
	 * 
	 * @return Liste des machines présentent dans l'atelier.
	 */
	public List<Machine> getMachines()
	{
		return new LinkedList<Machine>(this.list);
	}
}
