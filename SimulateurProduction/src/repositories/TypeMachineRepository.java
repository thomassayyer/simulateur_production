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
	
	/**
	 * Retourne tous les types de machine créés.
	 * 
	 * @return Types de machine créés.
	 */
	public List<TypeMachine> getTypes()
	{
		return this.types;
	}
	
	/**
	 * Retourne un type de machine à l'indice en paramètre.
	 * 
	 * @param index Indice du type de machine à récupérer.
	 * @return Type de machine à l'indice en paramètre.
	 */
	public TypeMachine recuperer(int index)
	{
		return this.types.get(index);
	}
	
}
