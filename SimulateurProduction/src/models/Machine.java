package models;

import java.util.LinkedList;
import java.util.List;

/**
 * Repr�sente une machine de production.
 * 
 * @author Thomas SAYER
 * @version 1.0
 */
public class Machine
{
	/**
	 * Num�ro unique de la machine.
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
	 * @param num Num�ro unique de la machine.
	 * @param stockMax Nombre de produits au maximum dans le stock.
	 */
	public Machine(int num, int stockMax)
	{
		this.num = num;
		this.stockMax = stockMax;
		this.stock = new LinkedList<Produit>();
	}
	
	/**
	 * Construit une nouvelle machine avec un stock de produit.
	 * 
	 * @param num Num�ro unique de la machine.
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
	
	/**
	 * Ajoute un produit au stock.
	 * 
	 * @param produit Produit � ajouter.
	 * @return Vrai si le produit a �t� ajout�; faux sinon.
	 */
	public boolean ajouterStock(Produit produit)
	{
		return this.stock.add(produit);
	}
	
	/**
	 * Retire un produit du stock.
	 * 
	 * @param produit Produit � retirer.
	 * @return Vrai si le produit a �t� retir�; faux sinon.
	 */
	public boolean retirerStock(Produit produit)
	{
		return this.stock.remove(produit);
	}
	
	/**
	 * Retourne le num�ro de la machine
	 * @return le num�ro de la machine
	 */
	public int getNum(){
		return this.num;
	}
}
