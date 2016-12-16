package auxiliary.comparators;

import java.util.Comparator;

import models.Phase;

/**
 * Comparateur qui compare de phases entre elles pour les trier par numéro (ordre croissant).
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class PhasesComparator implements Comparator<Phase>
{

	@Override
	public int compare(Phase o1, Phase o2)
	{
		if (o1.getNum() > o2.getNum())
		{
			return 1; 
		}
		
		if (o1.getNum() < o2.getNum())
		{
			return -1;
		}
		
		return 0;
	}

}
