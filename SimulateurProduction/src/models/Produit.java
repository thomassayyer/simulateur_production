package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Repr�sente un produit.
 * 
 * @author Mialy ANDRIAMIARANTSOANAVALONA
 * @version 1.2
 */
public class Produit
{
	/**
	 * Identifiant unique du produit.
	 */
	private int id;
	
	/**
	 * Type du produit.
	 */
	private String type;
	
	/**
	 * Gamme � laquelle appartient le programme.
	 */
	private Gamme gamme;
	
	/**
	 * Phase actuellement en cours d'ex�cution.
	 */
	private Phase phaseCourante;
	
	/**
	 * Construit un objet simple.
	 * 
	 * @param id Identifiant unique du produit.
	 * @param type Type du produit.
	 * @param gamme Gamme � laquelle appartient le produit.
	 */
	public Produit(int id, String type, Gamme gamme)
	{
		this.id = id;
		this.type = type;
		this.gamme = gamme;
		this.phaseCourante = this.gamme.getPhase(0);
	}
	
	/**
	 * Configure la valeur de la phase courante.
	 * 
	 * @param p Future phase courante.
	 */
	public void setPhaseCourante(Phase p)
	{
		this.phaseCourante = p;
	}
	
	/**
	 * Retourne la phase courante.
	 * 
	 * @return Phase courante.
	 */
	public Phase getPhaseCourante()
	{
		return this.phaseCourante;
	}
	
	/**
	 * Retourne l'identifiant unique du produit.
	 * 
	 * @return Identifiant unique du produit.
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Retourne la gamme du produit.
	 * 
	 * @return Gamme du produit.
	 */
	public Gamme getGamme()
	{
		return this.gamme;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.id == ((Produit)o).getId();
	}
	
}
