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
public class TypeMachineRepository {
	
	/**
	 * Types de machines cr��s.
	 */
	private List<TypeMachine> types;
	
	/**
	 * Constructeur non param�tr� qui instancie la liste cha�n�e des types de machine.
	 */
	public TypeMachineRepository()
	{
		this.types = new LinkedList<TypeMachine>();
	}
	
}
