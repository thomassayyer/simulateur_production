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
		 */
		private char type ;
		
		/**
		 * Numéro de machine sur laquel l'opération est réalisée
		 */
		// TODO 
		
		public Operation(int num, char type)
		{
			this.num = num;
			this.type = type;
			// TODO this. = ;
		}
}
	
	
