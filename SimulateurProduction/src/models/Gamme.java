package models;

import models.Operation;
import java.util.LinkedList;
import java.util.List;

import auxiliary.comparators.PhasesComparator;

/**
 * Représente une gamme (suite d'opération memant à un produit).
 * 
 * @author Jérémi CHEVALLIER
 * @version 1.0
 */
public class Gamme
{	
	/**
	 * Opération dans la gamme
	 */
	private List<Phase> phases;
	
	/**
	 * Numéro de la gamme.
	 */
	private int num;
	
	/**
	 * Constructeur d'une liste.
	 */
	public Gamme(int num) 
	{
		this.phases = new LinkedList<Phase>();
		this.num = num;
	}
	
	public void ordonnerPhases()
	{
		this.phases.sort(new PhasesComparator());
	}
	
	/**
	 * Ajout d'une opération à la fin de la liste.
	 */
	public boolean ajoutPhase(Phase p) throws Exception
	{
		for (Phase ph : this.phases)
		{
			if (ph.equals(p))
			{
				throw new Exception("Cette phase a déjà été ajoutée.");
			}
		}
		
		return phases.add(p);
	}

	/**
	 * Ajout d'une opération à un index
	 */
	public void ajoutPhase(Phase p, int index) throws Exception
	{
		for (Phase ph : this.phases)
		{
			if (ph.equals(p))
			{
				throw new Exception("Cette phase a déjà été ajoutée.");
			}
		}
		
		phases.add(index, p);
	}

	/**
	 * Supprime l'opération à l'index.
	 */
	public Phase suppPhase(int index)
	{
		return phases.remove(index);
	}

	/**
	 * Retourne l'index de l'opération.
	 * 
	 * @author Jérémi Chevallier
	 */
	public int recherchePhase(Phase p)
	{
		return phases.indexOf(p);
	}
	
	/**
	 * Retourne le numéro de la gamme.
	 * 
	 * @return Numéro de la gamme.
	 * 
	 * @author Jérémi Chevallier
	 */
	public int getNum(){
		return this.num;
	}
	
	public int getNbPhases()
	{
		return this.phases.size();
	}
	
	public Phase getPhase(int index)
	{
		return this.phases.get(index);
	}
	
	public int getPosPhase(Phase phase)
	{
		for (int i = 0; i < this.phases.size(); i++)
		{
			if (this.phases.get(i).equals(phase))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public List<Operation> getOperations()
	{
		LinkedList<Operation> operations = new LinkedList<Operation>();
		
		for (Phase p : this.phases)
		{
			operations.add(p.getOperation());
		}
		
		return operations;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.num);
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.num == ((Gamme)o).getNum();
	}
	
}
