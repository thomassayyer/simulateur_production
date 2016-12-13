package models;

import models.Machine;

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
		private char type;
		
		/**
		 * Numéro de machine sur laquel l'opération est réalisée
		 * TODO : faire un lien avec la classe Machine
		 */
		private TypeMachine typeMachine;
		
		public Operation(int num, char type, TypeMachine typeMachine)
		{
			this.num = num;
			this.type = type;
			this.typeMachine = typeMachine;
		}
		
		public int getNum()
		{
			return this.num;
		}
		
		public TypeMachine getTypeMachine()
		{
			return this.typeMachine;
		}
		
		@Override
		public String toString()
		{
			return this.num + " - " + this.type;
		}
		
		@Override
		public boolean equals(Object o)
		{
			return this.num == ((Operation)o).getNum();
		}
}
	
	
