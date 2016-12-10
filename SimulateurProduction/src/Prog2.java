import java.util.List;
import java.util.Scanner;

import models.*;
import repositories.*;

public class Prog2 {

	private static Scanner sc = new Scanner(System.in);
	private static Atelier atelier = new Atelier();
	private static OperationRepository operations = new OperationRepository();
	private static GammeRepository gammes = new GammeRepository();
	
	/**
	 * IHM pour cr�er une op�ration
	 * @return 
	 */
	private static boolean creerOperation()
	{
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Type : ");
		char type = sc.next().charAt(0);
		
		System.out.println();

		for ( Machine m : atelier.getMachines() )
		{
			System.out.println(m);
		}
		System.out.println("Num�ro de machine : ");
		int numMachine = sc.nextInt();
		Machine machine = atelier.getMachine(numMachine);
		
		try
		{
			operations.AjoutOp(new Operation(num, type, machine));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Op�ration cr��e");
	
	System.out.println("Nouvelle Op�ration ?");
	System.out.println("1 - Oui");
	System.out.println("0 - Non");

	return sc.nextInt() == 1 ? true : false;
}
	
	private static boolean creerGamme(){
		
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		try
		{
			gammes.AjoutGamme(new Gamme(num));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Gamme cr��e");
	
	System.out.println("Nouvelle Gamme ?");
	System.out.println("1 - Oui");
	System.out.println("0 - Non");

	return sc.nextInt() == 1 ? true : false;
	}
	
	private static boolean ajoutOp(Gamme gamme)
	{
		gamme.afficherPhases();
		System.out.println("Index de la nouvelle op�ration : ");
		int index = sc.nextInt();
		
		operations.AfficheOp();
		System.out.println("Num�ro de l'op�ration : ");
		int numOperation = sc.nextInt();
		
		gamme.ajoutOp(operations.getOp(numOperation), index);
		

		System.out.println("Op�ration ajout� dans la gamme");
	
		System.out.println("Ajout d'une autre op�ration ?");
		System.out.println("1 - Oui");
		System.out.println("0 - Non");

		return sc.nextInt() == 1 ? true : false;
	}
		
	private static boolean creerProduit()
	{			
		System.out.print("ID : ");
		int id = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Type : ");
		String type = sc.next();
		
		System.out.println();
		
		int i = 1;
		gammes.AfficheGamme();
		System.out.println("Num�ro de Gamme : ");
		int numGamme = sc.nextInt();
		Gamme gamme = listGamme.getGamme(numGamme);
		
		try
		{
			operations.ajouterProduit(new Produit(id, type, duree, gamme));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return true;
		}
		
		System.out.println("Op�ration cr��e");
	
	System.out.println("Nouvelle Op�ration ?");
	System.out.println("1 - Oui");
	System.out.println("0 - Non");

	return sc.nextInt() == 1 ? true : false;
}

}
