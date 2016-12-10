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
public class TypeMachineRepository {
	
	/**
	 * Types de machines créés.
	 */
	private List<TypeMachine> types;
	
	/**
	 * Constructeur non paramétré qui instancie la liste chaînée des types de machine.
	 */
	public TypeMachineRepository()
	{
		this.types = new LinkedList<TypeMachine>();
	}
	
}
