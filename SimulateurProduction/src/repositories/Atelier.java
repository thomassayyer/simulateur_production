package repositories;

import models.Machine;

/**
 * Représente un atelier de machines.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Atelier extends Repository<Machine>
{
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
}
