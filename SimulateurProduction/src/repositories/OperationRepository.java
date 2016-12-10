package repositories;

import models.Machine;
import models.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationRepository {

	/**
	 * Tableau des op�rations
	 */
	private List<Operation> listOp;
	
	/**
	 * Ajoute une nouvelle op�ration dans la liste
	 * @param newOp, nouvelle op�ration.
	 */
	public void AjoutOp(Operation newOp ) throws Exception
	{
		for (Operation p : listOp)
		{
			if (p.getNum() == newOp.getNum())
			{
				throw new Exception("Une op�ration porte d�j� ce num�ro.");
			}
		}
		listOp.add(newOp);
	}
	
	/**
	 * Affiche la liste des op�ration
	 */
	public void AfficheOp()
	{	
		for (int i=0 ; i<listOp.size(); i++ )
		{
			System.out.println(listOp.get(i));
		}
	}
	
	/**
	 * Getter pour la liste des op�rations
	 * @param index
	 * @return l'op�ration � l'index choisie
	 */
	public Operation getOp(int index)
	{
		return listOp.get(index);
	}
	
}
