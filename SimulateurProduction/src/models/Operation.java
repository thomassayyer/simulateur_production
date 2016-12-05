package models;

/**
 * Représente une opération.
 * 
 * @author Jérémi CHEVALLIER
 */
	
public class Operation {
		/**
		 * Numéro de l'opération
		 */
		private int num;
		
		/**
		 * Type de l'opération (lettre, exemple : t pour tournage, f pour fraisage ...)
		 * TODO : faire une lien avec la classe TypeMachine
		 */
		private char type ;
		
		/**
		 * Numéro de machine sur laquel l'opération est réalisée
		 * TODO : faire un lien avec la classe Machine
		 */
		private Machine machine;
		
		public Operation(int num, char type, Machine machine)
		{
			this.num = num;
			this.type = type;
			this.machine = machine;
		}
}
	
	
