import java.util.Scanner;

import models.*;
import repositories.OperationRepository;

/**
 * Programme principal.
 * Contient une méthode statique "main" s'exécutant en premier lors de l'exécution
 * du programme.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Programme
{
	/**
	 * Scanner permettant de récupérer les entrées utilisateur.
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Entrepot d'opérations.
	 */
	private static OperationRepository operations = new OperationRepository();
	
	/**
	 * Atelier de machines.
	 */
	private static Atelier atelier = new Atelier();
	
	/**
	 * Effectue les opérations de l'IHM permettant de créer une machine.
	 * 
	 * @return Vrai si l'utilisateur veut recréer une machine; faux sinon.
	 */
	private static boolean creerMachine()
	{
			System.out.print("Numéro : ");
			int num = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Stock max : ");
			int stockMax = sc.nextInt();
			
			System.out.println();
			
			System.out.println("Type : ");
			
			int i = 1;
			for (TypeMachine t : TypeMachine.values())
			{
				System.out.println(i + " - " + t);
				i++;
			}
			
			TypeMachine type = TypeMachine.values()[sc.nextInt() - 1];
			
			try
			{
				atelier.ajouterMachine(new Machine(num, stockMax, type));
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				return true;
			}
			
			System.out.println("Machine créée");
		
		System.out.println("Nouvelle machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1 ? true : false;
	}
	
	/**
	 * Méthode statique appelée en premier lors de l'exécution du programme.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Créer machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");
		
		int choix = sc.nextInt();
		
		if (choix == 1)
		{
			boolean nouvelleMachine;
			
			do
			{
				nouvelleMachine = creerMachine();
			} while (nouvelleMachine);
		}
	}
}
