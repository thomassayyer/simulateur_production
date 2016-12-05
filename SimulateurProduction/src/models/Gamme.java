package models;

import models.OperationRepository;
import models.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Repr�sente une gamme (suite d'op�ration memant � un produit)
 * 
 * TODO : Bug si doublons d'op�ration dans la liste  
 * 
 * @author J�r�mi CHEVALLIER
 * @version 1.0
 */

public class Gamme
{	
	/**
	 * Op�ration dans la gamme
	 */
	private List<com.sun.org.apache.xpath.internal.operations.Operation> gamme;
	
	/**
	 * Constructeur d'une liste.
	 */
	public Gamme(Operation valeur) 
	{
		this.gamme = new ArrayList<Operation>();
		gamme.add(valeur);
	}
	
	/**
	 * Affiche la gamme
	 */
	public void AfficheGamme()
	{
		for (int i=0; i < gamme.size(); i++){
			System.out.println(gamme.get(i));
		}
	}
	
	/**
	 * Ajout d'une op�ration � la fin de la liste
	 */
	public void AjoutOp(Operation newOp )
	{
		gamme.add(newOp)		
	}

	/**
	 * Ajout d'une op�ration � un index
	 */
	public void AjoutOp(Operation newOp, int index)
	{
		gamme.add(index+1, newOp);
	}

	/**
	 * Supprime l'op�ration � l'index.
	 */
	public void SuppOp(int index)
	{
		gamme.remove(index+1);
	}

	/**
	 * Retourne l'index de l'op�ration
	 */
	public int RechercheOp(Operation searchOp )
	{
		return gamme.indexOf(searchOp);
	}
	
}


