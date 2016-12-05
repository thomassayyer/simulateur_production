package models;

import models.OperationRepository;
import models.Operation;

public class Gamme 
{
	private Gamme premier;
	private Operation valeur;
	private Gamme suivant;
	
	/**
	 * Constructeur d'une liste.
	 */
	public Gamme(Operation valeur, Gamme suivant) 
	{
		this.premier = ;
		this.valeur = valeur;
		this.suivant = suivant;
	}
	
	/**
	*Crée un élément de liste vide
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
		int taile = getLongeur() 
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
	
	
	/**
	 * Modifie la valeur de la p
	 */
	public void setValeur(Operation valeur) 
	{
		this.valeur = valeur;
	}

	/**
	 * Retourne l'élement suivant dans la liste
	 */
	public Gamme getSuivant() 
	{
		return suivant;
	}

	/**
	 * Modifie l'élement suivant de la liste 
	 */
	public void setSuivant(Gamme suivant) 
	{
		this.suivant = suivant;
	}
	
	/**
	 * Retourne le premier element de la liste
	 */
	public Gamme getPremier() {
		return premier;
		}
	
	/**
	 * Retourne la longueur de la liste
	 */
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

}

