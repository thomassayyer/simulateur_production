import java.util.Scanner;

import models.*;

public class Prog2 {

	private static Scanner sc = new Scanner(System.in);
	private static Atelier atelier = new Atelier();
	private static OperationRepository operations = new OperationRepository(); 
	
	private static boolean creerOperation()
	{
		System.out.print("Num�ro : ");
		int num = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Type : ");
		char type = sc.n;
		
		System.out.println();
		
		int i = 1;
		for ( Machine m : atelier.getMachines() )
		{
			System.out.println(i + " - " + t);
			i++;
		}
		System.out.println("Num�ro de machine : ");
		int numMachine = sc.nextInt();
		
		try
		{
			operations.AjoutOp(new Operation(num, type, numMachine));
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
