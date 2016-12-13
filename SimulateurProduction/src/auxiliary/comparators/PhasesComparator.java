package auxiliary.comparators;

import java.util.Comparator;

import models.Phase;

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
