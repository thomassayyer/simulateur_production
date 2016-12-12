package repositories;

import models.Machine;

/**
 * Repr�sente un atelier de machines.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Atelier extends Repository<Machine>
{
	/**
	 * R�cup�re la machine correspondante au num�ro en param�tre.
	 * 
	 * @param numero Num�ro de la machine � r�cup�rer.
	 * @return Machine correspondante au num�ro en param�tre.
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
