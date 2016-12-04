package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une machine de production.
 * 
 * @author Thomas SAYER
 */
public class Machine
{
	/**
	 * Numéro unique de la machine.
	 */
	private int num;
	
	/**
	 * Nombre de produit maximum en attente dans le stock de la machine.
	 */
	private int stockMax;
	
	/**
	 * Type de la machine (fraiseuse, ...).
	 */
	private TypeMachine type;
	
	/**
	 * Produits en stock.
	 */
	private List<Produit> stock;
	
	/**
	 * Construit une nouvelle machine avec stock vide.
	 * 
	 * @param num Numéro unique de la machine.
	 * @param stockMax Nombre de produits au maximum dans le stock.
	 */
	public Machine(int num, int stockMax)
	{
		this.num = num;
		this.stockMax = stockMax;
		this.stock = new ArrayList<Produit>();
	}
	
	/**
	 * Construit une nouvelle machine avec un stock de produit.
	 * 
	 * @param num Numéro unique de la machine.
	 * @param stockMax Nombre de produits au maximum dans le stock.
	 * @param stock Stock de produit.
	 */
	public Machine(int num, int stockMax, List<Produit> stock)
	{
		this(num, stockMax);
		
		for (Produit produit : stock)
		{
			this.stock.add(produit);
		}
	}
	
	/**
	 * Lance la simulation de production des produits dans le stock.
	 */
	public void lancer()
	{
		// TODO
	}
}
