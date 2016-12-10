package models;

import models.Machine;

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
		 */
		private char type;
		
		/**
		 * Num�ro de machine sur laquel l'op�ration est r�alis�e
		 * TODO : faire un lien avec la classe Machine
		 */
		private int numMachine;
		
		public Operation(int num, char type, int numMachine)
		{
			this.num = num;
			this.type = type;
			this.numMachine = numMachine;
		}
		
		public int getNum()
		{
			return this.num;
		}
}
	
	
