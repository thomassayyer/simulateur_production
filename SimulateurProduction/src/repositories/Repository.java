package repositories;

import java.util.LinkedList;
import java.util.List;

import models.Operation;

/**
 * Classe de base de tous les entrep�ts de donn�es.
 * 
 * @author Thomas SAYER
 *
 * @param <T> Type de la donn�e � stocker.
 */
public abstract class Repository<T> {

	/**
	 * Liste cha�n�e contenant les objets de type T.
	 */
	protected List<T> list;
	
	/**
	 * Constructeur non param�tr� qui instancie la liste cha�n�e.
	 */
	protected Repository()
	{
		this.list = new LinkedList<T>();
	}
	
	/**
	 * Ajoute un objet dans la liste cha�n�e.
	 * 
	 * @param o Objet � ajouter.
	 * @return Vrai si l'objet a �t� ajout�; faux sinon.
	 */
	public boolean ajouter(T o) throws Exception
	{
		for (T ob : this.list)
		{
			if (ob.equals(o))
			{
				throw new Exception("Cet objet existe d�j�.");
			}
		}
		
		return this.list.add(o);
	}
	
	/**
	 * Retire un objet de la liste cha�n�e.
	 * 
	 * @param o Objet � retirer.
	 * @return Vrai si l'objet a �t� retir�; faux sinon.
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
