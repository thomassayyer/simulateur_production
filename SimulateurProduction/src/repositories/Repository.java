package repositories;

import java.util.LinkedList;
import java.util.List;

import models.Operation;

/**
 * Classe de base de tous les entrepôts de données.
 * 
 * @author Thomas SAYER
 *
 * @param <T> Type de la donnée à stocker.
 */
public abstract class Repository<T> {

	/**
	 * Liste chaînée contenant les objets de type T.
	 */
	protected List<T> list;
	
	/**
	 * Constructeur non paramétré qui instancie la liste chaînée.
	 */
	protected Repository()
	{
		this.list = new LinkedList<T>();
	}
	
	/**
	 * Ajoute un objet dans la liste chaînée.
	 * 
	 * @param o Objet à ajouter.
	 * @return Vrai si l'objet a été ajouté; faux sinon.
	 */
	public boolean ajouter(T o) throws Exception
	{
		for (T ob : this.list)
		{
			if (ob.equals(o))
			{
				throw new Exception("Cet objet existe déjà.");
			}
		}
		
		return this.list.add(o);
	}
	
	/**
	 * Retire un objet de la liste chaînée.
	 * 
	 * @param o Objet à retirer.
	 * @return Vrai si l'objet a été retiré; faux sinon.
	 */
	public boolean retirer(T o)
	{
		for (T ob : this.list)
		{
			if (ob.equals(o))
			{
				return this.list.remove(ob);
			}
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		
		for (T o : this.list)
		{
			str += o + "\n";
		}
		
		return str;
	}
	
}
