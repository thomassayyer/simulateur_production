package repositories;

import models.Machine;
import models.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Entrepôt d'opérations.
 * 
 * @author Jérémi Chevallier
 * @version 1.0
 */
public class OperationRepository extends Repository<Operation>
{
	/**
	 * Permet de récupérer l'opération correspondante au numéro en paramètre.
	 * 
	 * @param num Numéro de l'opération à récupérer.
	 * @return Opération correspondante au numéro en paramètre..
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
