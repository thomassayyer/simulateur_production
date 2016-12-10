package repositories;

import java.util.LinkedList;
import java.util.List;

import models.Machine;
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
	 * Ajoute un type de machine
	 * 
	 * @param typeMachine TypeMachine à ajouter
	 * @return Vrai si le type de machine a bien été créé; faux sinon.
	 */
	public boolean ajouterTypeMachine(TypeMachine typeMachine)
	{		
		return this.types.add(typeMachine);
	}

private static boolean creerTypeMachine()
{
		System.out.print("Numéro : ");
		int num = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Libellé : ");
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
		
		System.out.println("Type de machine créé");
	
	System.out.println("Nouveau type de machine ?");
	System.out.println("1 - Oui");
	System.out.println("0 - Non");

	return sc.nextInt() == 1 ? true : false;
}
	
}
