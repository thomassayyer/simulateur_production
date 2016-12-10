import java.util.Scanner;

import models.*;
import repositories.*;

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
	 * Entrepôt d'opérations.
	 */
	private static OperationRepository operations = new OperationRepository();
	
	/**
	 * Entrepôt de types de machine.
	 */
	private static TypeMachineRepository typesMachine = new TypeMachineRepository();
	
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
		for (TypeMachine t : typesMachine.getTypes())
		{
			System.out.println(i + " - " + t);
			i++;
		}
			
		TypeMachine type = typesMachine.recuperer(sc.nextInt() - 1);
			
		System.out.println("Combien de machines voulez-vous créer ?");
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
			
		System.out.println("Machine(s) créée(s)");
		
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
		// TODO Création des types de machines
		
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
		
		// TODO Création des opérations.
		
		// TODO Création des gammes.
		
		// TODO Création des produits.
		
		// TODO Lancement de la simulation.
	}
}
