package models;

/**
 * Repr�sente une op�ration.
 * 
 * @author J�r�mi CHEVALLIER
 */
	
public class Operation {
		/**
		 * Num�ro de l'op�ration
		 */
		private int num;
		
		/**
		 * Type de l'op�ration (lettre, exemple : t pour tournage, f pour fraisage ...)
		 * TODO : faire une lien avec la classe TypeMachine
		 */
		private char type ;
		
		/**
		 * Num�ro de machine sur laquel l'op�ration est r�alis�e
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
	
	
