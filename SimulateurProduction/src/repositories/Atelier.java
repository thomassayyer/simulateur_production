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
	public static Atelier getInstance()
	{
		if (instance == null)
		{
			instance = new Atelier();
		}
		
		return (Atelier)instance;
	}
	
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
	
	public void lancerSimulation()
	{
		for (Machine m : this.list)
		{
			m.lancerSimulation();
		}
	}
	
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
}
