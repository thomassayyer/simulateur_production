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
	}
	
	/**
	 * Ajoute un produit au stock.
	 * 
	 * @param produit Produit à ajouter.
	 * @return Vrai si le produit a été ajouté; faux sinon.
	 */
	public boolean ajouterStock(Produit produit)
	{
		return this.stock.add(produit);
	}
	
	/**
	 * Retire un produit du stock.
	 * 
	 * @param produit Produit à retirer.
	 * @return Vrai si le produit a été retiré; faux sinon.
	 */
	public boolean retirerStock(Produit produit)
	{
		return this.stock.remove(produit);
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
	
	public Produit getProduit(int i)
	{
		return this.stock.get(i);
	}
	
	public void lancerSimulation()
	{
		for (Produit produit : this.stock)
		{
			Phase phase = produit.getPhaseCourante();
				
			this.temps += phase.getDuree();
				
			Gamme gamme = produit.getGamme();
				
			int indexPhaseCourante = gamme.getPosPhase(phase);
				
			produit.setPhaseCourante(gamme.getPhase(indexPhaseCourante + 1));
			
			this.retirerStock(produit);
			
			this.produitsFinis.add(produit);
		}
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
