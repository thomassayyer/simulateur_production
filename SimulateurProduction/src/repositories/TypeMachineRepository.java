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
	
	/**
	 * Ajoute un type de machine
	 * 
	 * @param typeMachine TypeMachine � ajouter
	 * @return Vrai si le type de machine a bien �t� cr��; faux sinon.
	 */
	public boolean ajouterTypeMachine(TypeMachine typeMachine)
	{		
		return this.types.add(typeMachine);
	}

	/**
	 * Retourne tous les types de machine cr��s.
	 * 
	 * @return Types de machine cr��s.
	 */
	public List<TypeMachine> getTypes()
	{
		return this.types;
	}
	
	/**
	 * Retourne un type de machine � l'indice en param�tre.
	 * 
	 * @param index Indice du type de machine � r�cup�rer.
	 * @return Type de machine � l'indice en param�tre.
	 */
	public TypeMachine recuperer(int index)
	{
		return this.types.get(index);
	}
	
}
