import java.util.Scanner;

import models.*;
import repositories.*;

/**
 * Programme principal.
 * Contient une m�thode statique "main" s'ex�cutant en premier lors de l'ex�cution
 * du programme.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Programme
{
	/**
	 * Scanner permettant de r�cup�rer les entr�es utilisateur.
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Entrep�t d'op�rations.
	 */
	private static OperationRepository operations = new OperationRepository();
	
	/**
	 * Entrep�t de types de machine.
	 */
	private static TypeMachineRepository typesMachine = new TypeMachineRepository();
	
	/**
	 * Atelier de machines.
	 */
	private static Atelier atelier = new Atelier();
	
	/**
	 * Effectue les op�rations de l'IHM permettant de cr�er un type de machine.
	 * 
	 * @return Vrai si l'utilisateur veut recr�er un type de machine suppl�mentaire;
	 * 		   faux sinon.
	 */
	private static boolean creerTypeMachine()
	{
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
			
		System.out.print("\nLibell� : ");
		String libelle = sc.next();
			
		System.out.println();
			
		TypeMachine type = new TypeMachine(num, libelle);
			
		try
		{
			typesMachine.ajouterTypeMachine(type);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
			
		System.out.println("Type de machine cr��.");
		
		System.out.println("Nouveau type de machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1 ? true : false;
	}
	
	/**
	 * Effectue les op�rations de l'IHM permettant de cr�er une machine.
	 * 
	 * @return Vrai si l'utilisateur veut recr�er une / des machine(s) suppl�mentaire;
	 *         faux sinon.
	 */
	private static boolean creerMachines()
	{
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
			
		System.out.print("\nStock max : ");
		int stockMax = sc.nextInt();
			
		System.out.println();
			
		System.out.println("Type : ");
			
		int i = 1;
		for (TypeMachine t : typesMachine.getTypes())
		{
			System.out.println(i + " - " + t);
			i++;
		}
			
		TypeMachine type = typesMachine.recuperer(sc.nextInt() - 1);
			
		System.out.println("Combien de machines voulez-vous cr�er ?");
		int nbMachines = sc.nextInt();
			
		for (int j = 0; j < nbMachines; j++)
		{
			try
			{
				atelier.ajouterMachine(new Machine(num, stockMax, type));
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				return true;
			}
				
			num++;
		}
			
		System.out.println("Machine(s) cr��e(s)");
		
		System.out.println("Nouvelle machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1 ? true : false;
	}
	
	/**
	 * M�thode statique appel�e en premier lors de l'ex�cution du programme.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Cr�ation de types de machine : ");
		
		boolean nouveauType;
		
		do
		{
			nouveauType = creerTypeMachine();
		} while (nouveauType);
		
		System.out.println("Cr�ation de machines : ");
		
		boolean nouvelleMachine;

		do
		{
			nouvelleMachine = creerMachines();
		} while (nouvelleMachine);
		
		// TODO Cr�ation des op�rations.
		
		// TODO Cr�ation des gammes.
		
		// TODO Cr�ation des produits.
		
		// TODO Lancement de la simulation.
	}
}
