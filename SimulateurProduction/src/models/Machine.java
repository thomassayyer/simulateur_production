package models;

import java.util.LinkedList;
import java.util.List;

/**
 * Représente une machine de production.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Machine
{
	/**
	 * Numéro unique de la machine.
	 */
	private int num;
	
	/**
	 * Type de la machine (fraiseuse, ...).
	 */
	private TypeMachine type;
	
	/**
	 * Produits en stock.
	 */
	private List<Produit> stock;
	
	private int stockMax;
	
	private List<Produit> produitsFinis;
	
	private double temps;
	
	/**
	 * Construit une nouvelle machine avec stock vide.
	 * 
	 * @param num Numéro unique de la machine.
	 * @param type Type de la machine.
	 */
	public Machine(int num, TypeMachine type)
	{
		this.num = num;
		this.type = type;
		this.temps = 0;
		this.stock = new LinkedList<Produit>();
		this.produitsFinis = new LinkedList<Produit>();
		this.stockMax = 0;
	}
	
	/**
	 * Ajoute un produit au stock.
	 * 
	 * @param produit Produit à ajouter.
	 * @return Vrai si le produit a été ajouté; faux sinon.
	 */
	public boolean ajouterStock(Produit produit)
	{
		boolean add = this.stock.add(produit);
		
		if (this.stock.size() > this.stockMax)
		{
			this.stockMax = this.stock.size();
		}
		
		return add;
	}
	
	/**
	 * Retire un produit du stock.
	 * 
	 * @param produit Produit à retirer.
	 * @return Vrai si le produit a été retiré; faux sinon.
	 */
	public boolean retirerStock(Produit produit)
	{
		for (Produit p : this.stock)
		{
			if (p.equals(produit))
			{
				return this.stock.remove(p);
			}
		}

		return false;
	}
	
	/**
	 * Retourne le numéro de la machine.
	 * 
	 * @return Numéro de la machine.
	 */
	public int getNum()
	{
		return this.num;
	}
	
	public TypeMachine getType()
	{
		return this.type;
	}
	
	public double getTemps()
	{
		return this.temps;
	}
	
	public int getStockMax()
	{
		return this.stockMax;
	}
	
	public Produit getProduit(int i)
	{
		return this.stock.get(i);
	}
	
	public List<Produit> getProduitsFinis()
	{
		return this.produitsFinis;
	}
	
	public void lancerSimulation()
	{
		for (Produit produit : this.stock)
		{
			Phase phase = produit.getPhaseCourante();
				
			this.temps += phase.getDuree();
				
			Gamme gamme = produit.getGamme();
				
			int indexPhaseCourante = gamme.getPosPhase(phase);
			
			if ((indexPhaseCourante + 1) < gamme.getNbPhases())
			{
				produit.setPhaseCourante(gamme.getPhase(indexPhaseCourante + 1));
			}
			
			this.produitsFinis.add(produit);
		}
		
		this.stock.clear();
	}
	
	public int getStockSize()
	{
		return this.stock.size();
	}
	
	@Override
	public String toString()
	{
		return this.num + " - " + this.type.getLibelle();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.num == ((Machine)o).getNum();
	}
}
