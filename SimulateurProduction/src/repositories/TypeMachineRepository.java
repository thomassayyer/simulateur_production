package repositories;

import java.util.LinkedList;
import java.util.List;
import models.TypeMachine;

/**
 * Entrep�t de TypeMachine.
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
	 * Retourne le type de machine de num�ro en param�tre.
	 * 
	 * @param num Num�ro du type de machine � r�cup�rer.
	 * @return Type de machine ayant le num�ro en param�tre.
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
