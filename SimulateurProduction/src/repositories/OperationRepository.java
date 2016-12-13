package repositories;

import models.Machine;
import models.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Entrep�t d'op�rations.
 * 
 * @author J�r�mi Chevallier
 * @version 1.0
 */
public class OperationRepository extends Repository<Operation>
{	
	public static OperationRepository getInstance()
	{
		if (instance == null)
		{
			instance = new OperationRepository();
		}
		
		return (OperationRepository)instance;
	}
	
	/**
	 * Permet de r�cup�rer l'op�ration correspondante au num�ro en param�tre.
	 * 
	 * @param num Num�ro de l'op�ration � r�cup�rer.
	 * @return Op�ration correspondante au num�ro en param�tre..
	 */
	public Operation getOp(int num)
	{
		for (Operation o : this.list)
		{
			if (o.getNum() == num)
			{
				return o;
			}
		}
		
		return null;
	}
	
}
