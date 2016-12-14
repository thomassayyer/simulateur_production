package repositories;

import java.util.LinkedList;
import java.util.List;
import models.TypeMachine;

/**
 * Entrepôt de TypeMachine.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class TypeMachineRepository extends Repository<TypeMachine>
{
	private static TypeMachineRepository instance;
	
	public static TypeMachineRepository getInstance()
	{
		if (instance == null)
		{
			instance = new TypeMachineRepository();
		}
		
		return (TypeMachineRepository)instance;
	}
	
	/**
	 * Retourne le type de machine de numéro en paramètre.
	 * 
	 * @param num Numéro du type de machine à récupérer.
	 * @return Type de machine ayant le numéro en paramètre.
	 */
	public TypeMachine getType(int num)
	{
		for (TypeMachine t : this.list)
		{
			if (t.getNum() == num)
			{
				return t;
			}
		}
		
		return null;
	}
}
