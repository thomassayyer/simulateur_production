import java.util.List;
import java.util.Scanner;

import auxiliary.comparators.MachinesTempsComparator;
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
	private static OperationRepository operations = OperationRepository.getInstance();
	
	/**
	 * Entrepôt de types de machine.
	 */
	private static TypeMachineRepository typesMachine = TypeMachineRepository.getInstance();
	
	/**
	 * Entrepôt de gammes.
	 */
	private static GammeRepository gammes = GammeRepository.getInstance();
	
	/**
	 * Entrepôt de produits.
	 */
	private static ProduitRepository produits = ProduitRepository.getInstance();
	
	/**
	 * Atelier de machines.
	 */
	private static Atelier atelier = Atelier.getInstance();
	
	/**
	 * Effectue les opérations de l'IHM permettant de créer un type de machine.
	 * 
	 * @return Vrai si l'utilisateur veut recréer un type de machine supplémentaire;
	 * 		   faux sinon.
	 */
	private static boolean creerTypeMachine()
	{
		System.out.print("\nNuméro : ");
		int num = sc.nextInt();
			
		System.out.print("Libellé : ");
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
		System.out.print("\nNuméro : ");
		int num = sc.nextInt();
			
		System.out.println("\nType : ");

		System.out.println(typesMachine);
			
		TypeMachine type = typesMachine.getType(sc.nextInt());
			
		System.out.println("Combien de machines voulez-vous créer ?");
		int nbMachines = sc.nextInt();
			
		for (int j = 0; j < nbMachines; j++)
		{
			try
			{
				atelier.ajouter(new Machine(num, type));
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				return true;
			}
			num++;
		}
		
		System.out.println("\nMachine(s) créée(s)");
		
		System.out.println(atelier);
		
		System.out.println("Nouvelle(s) machine(s) ?");
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
		System.out.print("\nNuméro : ");
		int num = sc.nextInt();
		
		System.out.print("Type : ");
		char type = sc.next().charAt(0);

		System.out.println("Type de machine : ");
		
		System.out.println(typesMachine);

		System.out.println("Numéro du type de machine : ");

		int numTypeMachine = sc.nextInt();
		TypeMachine typeMachine = typesMachine.getType(numTypeMachine);
		
		try
		{
			operations.ajouter(new Operation(num, type, typeMachine));
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
		
		System.out.print("\nNuméro : ");
		int num = sc.nextInt();
		
		Gamme gamme = new Gamme(num);
		
		System.out.println("Phases :");
		
		boolean nouvellePhase;
		
		do
		{
			System.out.println(operations);
			
			System.out.print("Numéro de l'opération : ");
			Operation operation = operations.getOp(sc.nextInt());
			
			System.out.print("Durée (en min.) : ");
			double duree = sc.nextDouble();
			
			System.out.print("Numéro : ");
			int numPhase = sc.nextInt();
			
			Phase phase = new Phase(numPhase, operation, duree);
			
			try
			{
				gamme.ajoutPhase(phase);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				nouvellePhase = true;
				continue;
			}
			
			System.out.println("Ajouter phase ?");
			System.out.println("1 - Oui");
			System.out.println("0 - Non");
			
			nouvellePhase = sc.nextInt() == 1;
		} while (nouvellePhase);
		
		gamme.ordonnerPhases();
		
		try
		{
			gammes.ajouter(gamme);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("\nGamme créée.");
		
		for (int i = 0; i < gamme.getNbPhases(); i++)
		{
			if (gamme.getPhase(i) != null)
			{
				System.out.println(gamme.getPhase(i));
			}
		}
	
		System.out.println("\nNouvelle Gamme ?");
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
		System.out.print("\nId : ");
		int id = sc.nextInt();
		
		System.out.print("Type : ");
		String type = sc.next();
		
		System.out.print("Gamme : ");
		
		System.out.println(gammes);

		System.out.print("Numéro de Gamme : ");
		int numGamme = sc.nextInt();

		Gamme gamme = gammes.getGamme(numGamme);
		
		System.out.println("Combien de produits voulez-vous créer ?");
		int nbProduits = sc.nextInt();
			
		for (int j = 0; j < nbProduits; j++)
		{
			try
			{
				produits.ajouter(new Produit(id, type, gamme));
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				return true;
			}
			id++;
		}
		
		System.out.println("\nProduit(s) créé(s)");
	
		System.out.println("Nouveau(x) produit(s) ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	private static void repartirProduits()
	{
		for (Gamme gamme : gammes.getGammes())
		{
			List<Produit> prods = produits.getProduitsByGamme(gamme);
			
			// Tous les produits de la gamme en sont à la même phase.
			Phase phase = prods.get(0).getPhaseCourante();

			TypeMachine type = phase.getOperation().getTypeMachine();
			
			List<Machine> machines = atelier.getMachinesByType(type);
			
			for (Produit produit : produits.getProduitsByGamme(gamme))
			{
				machines.sort(new MachinesTempsComparator());
				atelier.getMachinesByType(type).get(0).ajouterStock(produit);
			}
		}
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
		
		System.out.println("\nCréation de machines : ");
		
		boolean nouvelleMachine;

		do
		{
			nouvelleMachine = creerMachines();
		} while (nouvelleMachine);
		
		System.out.println("\nCréation d'opérations : ");

		boolean nouvelleOperation;
		
		do
		{
			nouvelleOperation = creerOperation();
		} while (nouvelleOperation);
		
		System.out.println("\nCréation de gammes : ");
		
		boolean nouvelleGamme;
		
		do
		{
			nouvelleGamme = creerGamme();
		} while (nouvelleGamme);
		
		System.out.println("\nCréation de produits : ");
		
		boolean nouveauProduit;
		
		do
		{
			nouveauProduit = creerProduit();
		} while (nouveauProduit);
		
		do
		{
			repartirProduits();
			atelier.lancerSimulation();
		} while (atelier.hasMachinesAvecStock());
	}
}
