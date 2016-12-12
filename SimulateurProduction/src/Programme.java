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
	 * Entrepôt de gammes.
	 */
	private static GammeRepository gammes = new GammeRepository();
	
	/**
	 * Entrepôt de produits.
	 */
	private static ProduitRepository produits = new ProduitRepository();
	
	/**
	 * Atelier de machines.
	 */
	private static Atelier atelier = new Atelier();
	
	/**
	 * Effectue les opérations de l'IHM permettant de créer un type de machine.
	 * 
	 * @return Vrai si l'utilisateur veut recréer un type de machine supplémentaire;
	 * 		   faux sinon.
	 */
	private static boolean creerTypeMachine()
	{
		System.out.print("Numéro : ");
		int num = sc.nextInt();
			
		System.out.print("\nLibellé : ");
		String libelle = sc.next();
			
		System.out.println();
			
		TypeMachine type = new TypeMachine(num, libelle);
			
		try
		{
			typesMachine.ajouter(type);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
			
		System.out.println("Type de machine créé.");
		
		System.out.println("Nouveau type de machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les opérations de l'IHM permettant de créer une machine.
	 * 
	 * @return Vrai si l'utilisateur veut recréer une / des machine(s) supplémentaire;
	 *         faux sinon.
	 */
	private static boolean creerMachines()
	{
		System.out.print("Numéro : ");
		int num = sc.nextInt();
			
		System.out.print("\nStock max : ");
		int stockMax = sc.nextInt();
			
		System.out.println();
			
		System.out.println("Type : ");

		System.out.println(typesMachine);
			
		TypeMachine type = typesMachine.getType(sc.nextInt());
			
		System.out.println("Combien de machines voulez-vous créer ?");
		int nbMachines = sc.nextInt();
			
		for (int j = 0; j < nbMachines; j++)
		{
			try
			{
				atelier.ajouter(new Machine(num, stockMax, type));
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

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les opérations de l'IHM de création d'une opération.
	 * 
	 * @return Vrai si l'utilisateur veut créer une nouvelle opération; faux sinon.
	 */
	private static boolean creerOperation()
	{
		System.out.print("Numéro : ");
		int num = sc.nextInt();
		
		System.out.print("\nType : ");
		char type = sc.next().charAt(0);

		System.out.println("Machine : ");
		
		System.out.println(atelier);

		System.out.println("Numéro de machine : ");

		int numMachine = sc.nextInt();
		Machine machine = atelier.getMachine(numMachine);
		
		try
		{
			operations.ajouter(new Operation(num, type, machine));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Opération créée");
	
		System.out.println("Nouvelle opération ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les opération de l'IHM de création d'une gamme de produits.
	 * 
	 * @return Vrai si l'utilisateur veut créer une nouvelle gamme; faux sinon.
	 */
	private static boolean creerGamme(){
		
		System.out.print("Numéro : ");
		int num = sc.nextInt();
		
		Gamme gamme = new Gamme(num);
		
		System.out.println("Phases :");
		
		boolean nouvelleOp;
		
		do
		{
			System.out.println(operations);
			
			System.out.print("Numéro de l'opération : ");
			gamme.ajoutOp(operations.getOp(sc.nextInt()));
			
			System.out.println("Ajouter phase ?");
			System.out.println("1 - Oui");
			System.out.println("0 - Non");
			
			nouvelleOp = sc.nextInt() == 1;
		} while (nouvelleOp);
		
		try
		{
			gammes.ajouter(gamme);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Gamme créée.");
	
		System.out.println("Nouvelle Gamme ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les opérations de l'IHM de création de produits.
	 * 
	 * @return Vrai si l'utilisateur veut créer un nouveau produit; faux sinon.
	 */
	private static boolean creerProduit()
	{			
		System.out.print("ID : ");
		int id = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Type : ");
		String type = sc.next();
		
		System.out.println();
		
		System.out.println("Gamme : ");
		
		System.out.println(gammes);

		System.out.println("Numéro de Gamme : ");
		int numGamme = sc.nextInt();

		Gamme gamme = gammes.getGamme(numGamme);
		
		Produit p = new Produit(id, type, gamme);
		
		System.out.println("Durées par machines : ");
		
		for (Machine m : gamme.getMachines())
		{
			System.out.println(m);
			System.out.print("Duree : ");
			p.ajouterDuree(m, sc.nextDouble());
		}
		
		try
		{
			produits.ajouter(p);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Produit créé");
	
		System.out.println("Nouveau produit ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Méthode statique appelée en premier lors de l'exécution du programme.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Création de types de machine : ");
		
		boolean nouveauType;
		
		do
		{
			nouveauType = creerTypeMachine();
		} while (nouveauType);
		
		System.out.println("Création de machines : ");
		
		boolean nouvelleMachine;

		do
		{
			nouvelleMachine = creerMachines();
		} while (nouvelleMachine);
		
		System.out.println("Création d'opérations : ");

		boolean nouvelleOperation;
		
		do
		{
			nouvelleOperation = creerOperation();
		} while (nouvelleOperation);
		
		System.out.println("Création de gammes : ");
		
		boolean nouvelleGamme;
		
		do
		{
			nouvelleGamme = creerGamme();
		} while (nouvelleGamme);
		
		System.out.println("Création de produits : ");
		
		boolean nouveauProduit;
		
		do
		{
			nouveauProduit = creerProduit();
		} while (nouveauProduit);
		
		// TODO Lancement de la simulation.
	}
}
