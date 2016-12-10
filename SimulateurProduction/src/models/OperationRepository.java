package models;

import models.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationRepository {

	/**
	 * Tableau des opérations
	 */
	private List<Operation> listOp;
	
	/**
	 * Ajoute une nouvelle opération dans la liste
	 * @param newOp, nouvelle opération.
	 */
	public void AjoutOp(Operation newOp )
	{
		listOp.add(newOp);		
	}
	
	
	
	
	/**
	 * Affiche la liste des opération
	 */
	public void AfficheOp()
	{	
		for (int i=0 ; i<listOp.size(); i++ )
		{
			System.out.println(listOp.get(i));
		}
	}
	
	/**
	 * Getter pour la liste des opérations
	 * @param index
	 * @return l'opération à l'index choisie
	 */
	public Operation getOp(int index)
	{
		return listOp.get(index);
	}

	
}
