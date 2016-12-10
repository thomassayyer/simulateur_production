import models.TypeMachine;

public class Programme1 {

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
