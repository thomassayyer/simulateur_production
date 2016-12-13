import java.util.List;
import java.util.Scanner;

import auxiliary.comparators.MachinesTempsComparator;
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
	private static OperationRepository operations = OperationRepository.getInstance();
	
	/**
	 * Entrep�t de types de machine.
	 */
	private static TypeMachineRepository typesMachine = TypeMachineRepository.getInstance();
	
	/**
	 * Entrep�t de gammes.
	 */
	private static GammeRepository gammes = GammeRepository.getInstance();
	
	/**
	 * Entrep�t de produits.
	 */
	private static ProduitRepository produits = ProduitRepository.getInstance();
	
	/**
	 * Atelier de machines.
	 */
	private static Atelier atelier = Atelier.getInstance();
	
	/**
	 * Effectue les op�rations de l'IHM permettant de cr�er un type de machine.
	 * 
	 * @return Vrai si l'utilisateur veut recr�er un type de machine suppl�mentaire;
	 * 		   faux sinon.
	 */
	private static boolean creerTypeMachine()
	{
		System.out.print("\nNum�ro : ");
		int num = sc.nextInt();
			
		System.out.print("Libell� : ");
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
			
		System.out.println("Type de machine cr��.");
		
		System.out.println("Nouveau type de machine ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les op�rations de l'IHM permettant de cr�er une machine.
	 * 
	 * @return Vrai si l'utilisateur veut recr�er une / des machine(s) suppl�mentaire;
	 *         faux sinon.
	 */
	private static boolean creerMachines()
	{
		System.out.print("\nNum�ro : ");
		int num = sc.nextInt();
			
		System.out.println("\nType : ");

		System.out.println(typesMachine);
			
		TypeMachine type = typesMachine.getType(sc.nextInt());
			
		System.out.println("Combien de machines voulez-vous cr�er ?");
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
		
		System.out.println("\nMachine(s) cr��e(s)");
		
		System.out.println(atelier);
		
		System.out.println("Nouvelle(s) machine(s) ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les op�rations de l'IHM de cr�ation d'une op�ration.
	 * 
	 * @return Vrai si l'utilisateur veut cr�er une nouvelle op�ration; faux sinon.
	 */
	private static boolean creerOperation()
	{
		System.out.print("\nNum�ro : ");
		int num = sc.nextInt();
		
		System.out.print("Type : ");
		char type = sc.next().charAt(0);

		System.out.println("Type de machine : ");
		
		System.out.println(typesMachine);

		System.out.println("Num�ro du type de machine : ");

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
		
		System.out.println("Op�ration cr��e");
	
		System.out.println("Nouvelle op�ration ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
	}
	
	/**
	 * Effectue les op�ration de l'IHM de cr�ation d'une gamme de produits.
	 * 
	 * @return Vrai si l'utilisateur veut cr�er une nouvelle gamme; faux sinon.
	 */
	private static boolean creerGamme(){
		
		System.out.print("\nNum�ro : ");
		int num = sc.nextInt();
		
		Gamme gamme = new Gamme(num);
		
		System.out.println("Phases :");
		
		boolean nouvellePhase;
		
		do
		{
			System.out.println(operations);
			
			System.out.print("Num�ro de l'op�ration : ");
			Operation operation = operations.getOp(sc.nextInt());
			
			System.out.print("Dur�e (en min.) : ");
			double duree = sc.nextDouble();
			
			System.out.print("Num�ro : ");
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
		
		System.out.println("\nGamme cr��e.");
		
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
	 * Effectue les op�rations de l'IHM de cr�ation de produits.
	 * 
	 * @return Vrai si l'utilisateur veut cr�er un nouveau produit; faux sinon.
	 */
	private static boolean creerProduit()
	{			
		System.out.print("\nId : ");
		int id = sc.nextInt();
		
		System.out.print("Type : ");
		String type = sc.next();
		
		System.out.print("Gamme : ");
		
		System.out.println(gammes);

		System.out.print("Num�ro de Gamme : ");
		int numGamme = sc.nextInt();

		Gamme gamme = gammes.getGamme(numGamme);
		
		System.out.println("Combien de produits voulez-vous cr�er ?");
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
		
		System.out.println("\nProduit(s) cr��(s)");
	
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
			
			// Tous les produits de la gamme en sont � la m�me phase.
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
		
		System.out.println("\nCr�ation de machines : ");
		
		boolean nouvelleMachine;

		do
		{
			nouvelleMachine = creerMachines();
		} while (nouvelleMachine);
		
		System.out.println("\nCr�ation d'op�rations : ");

		boolean nouvelleOperation;
		
		do
		{
			nouvelleOperation = creerOperation();
		} while (nouvelleOperation);
		
		System.out.println("\nCr�ation de gammes : ");
		
		boolean nouvelleGamme;
		
		do
		{
			nouvelleGamme = creerGamme();
		} while (nouvelleGamme);
		
		System.out.println("\nCr�ation de produits : ");
		
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
