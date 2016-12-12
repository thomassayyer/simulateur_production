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
	 * Entrep�t de gammes.
	 */
	private static GammeRepository gammes = new GammeRepository();
	
	/**
	 * Entrep�t de produits.
	 */
	private static ProduitRepository produits = new ProduitRepository();
	
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
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
			
		System.out.print("\nStock max : ");
		int stockMax = sc.nextInt();
			
		System.out.println();
			
		System.out.println("Type : ");

		System.out.println(typesMachine);
			
		TypeMachine type = typesMachine.getType(sc.nextInt());
			
		System.out.println("Combien de machines voulez-vous cr�er ?");
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
			
		System.out.println("Machine(s) cr��e(s)");
		
		System.out.println("Nouvelle machine ?");
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
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		System.out.print("\nType : ");
		char type = sc.next().charAt(0);

		System.out.println("Machine : ");
		
		System.out.println(atelier);

		System.out.println("Num�ro de machine : ");

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
		
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		Gamme gamme = new Gamme(num);
		
		System.out.println("Phases :");
		
		boolean nouvelleOp;
		
		do
		{
			System.out.println(operations);
			
			System.out.print("Num�ro de l'op�ration : ");
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
		
		System.out.println("Gamme cr��e.");
	
		System.out.println("Nouvelle Gamme ?");
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
		System.out.print("ID : ");
		int id = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Type : ");
		String type = sc.next();
		
		System.out.println();
		
		System.out.println("Gamme : ");
		
		System.out.println(gammes);

		System.out.println("Num�ro de Gamme : ");
		int numGamme = sc.nextInt();

		Gamme gamme = gammes.getGamme(numGamme);
		
		Produit p = new Produit(id, type, gamme);
		
		System.out.println("Dur�es par machines : ");
		
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
		
		System.out.println("Produit cr��");
	
		System.out.println("Nouveau produit ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1;
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
		
		System.out.println("Cr�ation d'op�rations : ");

		boolean nouvelleOperation;
		
		do
		{
			nouvelleOperation = creerOperation();
		} while (nouvelleOperation);
		
		System.out.println("Cr�ation de gammes : ");
		
		boolean nouvelleGamme;
		
		do
		{
			nouvelleGamme = creerGamme();
		} while (nouvelleGamme);
		
		System.out.println("Cr�ation de produits : ");
		
		boolean nouveauProduit;
		
		do
		{
			nouveauProduit = creerProduit();
		} while (nouveauProduit);
		
		// TODO Lancement de la simulation.
	}
}
