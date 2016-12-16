package auxiliary.comparators;

import java.util.Comparator;

import models.Machine;

/**
 * Comparateur qui pemet d'odonner un liste de machine en fonction des temps
 * machine déjà écoulés (ordre croissant).
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class MachinesTempsComparator implements Comparator<Machine> {

	@Override
	public int compare(Machine m0, Machine m1)
	{
		if (m0.getTemps() > m1.getTemps())
		{
			return 1;
		}
		
		if (m0.getTemps() < m1.getTemps())
		{
			return -1;
		}
		
		return 0;
	}

}
