package models;

import models.OperationRepository;
import models.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une gamme (suite d'opération memant à un produit)
 * 
 * TODO : Bug si doublons d'opération dans la liste  
 * 
 * @author Jérémi CHEVALLIER
 * @version 1.0
 */

public class Gamme
{	
	/**
	 * Opération dans la gamme
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
	 * Ajout d'une opération à la fin de la liste
	 */
	public void AjoutOp(Operation newOp )
	{
		gamme.add(newOp)		
	}

	/**
	 * Ajout d'une opération à un index
	 */
	public void AjoutOp(Operation newOp, int index)
	{
		gamme.add(index, newOp);
	}

	/**
	 * Supprime l'opération à l'index.
	 */
	public void SuppOp(int index)
	{
		gamme.remove(index);
	}

	/**
	 * Retourne l'index de l'opération
	 */
	public int RechercheOp(Operation searchOp )
	{
		return gamme.indexOf(searchOp);
	}
	
}


