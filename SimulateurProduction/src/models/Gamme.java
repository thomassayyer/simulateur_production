package models;

import models.OperationRepository;
import models.Operation;

public class Gamme 
{
	
	private Operation valeur;
	private Gamme suivant;
	
	public Gamme(Operation valeur, Gamme suivant) 
	{
		this.valeur = valeur;
		this.suivant = suivant;
	}
	
	/**
	*Crée un élément de liste svide
	*@param valeur Opération
	*/
	public Gamme(Operation valeur) 
	{
		this.valeur = valeur;
		this.suivant = null;
	}
	
	/**
	 * Affiche la gamme
	 */
	public void AfficheGamme()
	{
		
	}
	
	// LA SUITE DES FONCTIONS SERVENT POUR LA LISTE CHAINEE
	// source : http://deptinfo.cnam.fr/Enseignement/CycleA/APA/nfa032/docs/cours-listes.pdf
	
	/**
	 * Obtenir la valeur de la phase
	 * @return
	 */
	public Operation getValeur() 
	{
		return valeur;
	}
	
	public void setValeur(Operation valeur) 
	{
		this.valeur = valeur;
	}
	
	public Gamme getSuivant() 
	{
		return suivant;
	}
	
	public void setSuivant(Gamme suivant) 
	{
		this.suivant = suivant;
		}
	
	/*
	public Gamme getPremier() {
		return premier;
		}
	
	public int getLongueur() 
	{
		int longueur= 0;
		Gamme ref= getPremier();
		while (ref != null) {
		longueur++;
		ref= ref.getSuivant();
		}
		return longueur;
		}
		*/
}
