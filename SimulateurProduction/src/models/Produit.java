package models;

import java.util.HashMap;
import java.util.Map;

public class Produit {
	
	private int id;
	private String type;
	private Gamme gamme;
	private Phase phaseCourante;
	
	public Produit(int id, String type, Gamme gamme)
	{
		this.id = id;
		this.type = type;
		this.gamme = gamme;
		this.phaseCourante = this.gamme.getPhase(0);
	}
	
	public void setPhaseCourante(Phase p)
	{
		this.phaseCourante = p;
	}
	
	public Phase getPhaseCourante()
	{
		return this.phaseCourante;
	}
	
	public int getId(){
		return this.id;
	}
	
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
