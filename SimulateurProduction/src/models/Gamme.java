package models;

import models.Operation;
import java.util.LinkedList;
import java.util.List;

/**
 * Repr�sente une gamme (suite d'op�ration memant � un produit).
 * 
 * @author J�r�mi CHEVALLIER
 * @version 1.0
 */
public class Gamme
{	
	/**
	 * Op�ration dans la gamme
	 */
	private List<Operation> phases;
	
	/**
	 * Num�ro de la gamme.
	 */
	private int num;
	
	/**
	 * Constructeur d'une liste.
	 */
	public Gamme(int num) 
	{
		this.phases = new LinkedList<Operation>();
		this.num = num;
	}
	
	/**
	 * Affiche les phases.
	 */
	public void afficherPhases()
	{
		for (int i=0; i < phases.size(); i++) {
			System.out.println(i + " - " + phases.get(i));
		}
	}
	
	/**
	 * Ajout d'une op�ration � la fin de la liste.
	 */
	public boolean ajoutOp(Operation newOp)
	{
		return phases.add(newOp);
	}

	/**
	 * Ajout d'une op�ration � un index
	 */
	public void ajoutOp(Operation newOp, int index)
	{
		phases.add(index, newOp);
	}

	/**
	 * Supprime l'op�ration � l'index.
	 */
	public Operation suppOp(int index)
	{
		return phases.remove(index);
	}

	/**
	 * Retourne l'index de l'op�ration.
	 * 
	 * @author J�r�mi Chevallier
	 */
	public int rechercheOp(Operation searchOp)
	{
		return phases.indexOf(searchOp);
	}
	
	/**
	 * Retourne le num�ro de la gamme.
	 * 
	 * @return Num�ro de la gamme.
	 * 
	 * @author J�r�mi Chevallier
	 */
	public int getNum(){
		return this.num;
	}
	
	public List<Machine> getMachines()
	{
		List<Machine> machines = new LinkedList<Machine>();
		
		for (Operation o : this.phases)
		{
			machines.add(o.getMachine());
		}
		
		return machines;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.num == ((Gamme)o).getNum();
	}
	
}
