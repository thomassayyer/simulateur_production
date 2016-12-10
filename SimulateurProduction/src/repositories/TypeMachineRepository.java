package repositories;

import java.util.LinkedList;
import java.util.List;

import models.Machine;
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

private static boolean creerTypeMachine()
{
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Libell� : ");
		int libelle = sc.nextInt();
		
		System.out.println();
		
		TypeMachine type = TypeMachine.values()[sc.nextInt() - 1];
		
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Type de machine cr��");
	
	System.out.println("Nouveau type de machine ?");
	System.out.println("1 - Oui");
	System.out.println("0 - Non");

	return sc.nextInt() == 1 ? true : false;
}
	
}
