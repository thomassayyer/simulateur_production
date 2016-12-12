package models;

import java.util.HashMap;

public class Produit {
	
	private int id;
	private String type;
	private Gamme gamme;
	private HashMap<Machine, Double> durees;
	
	public Produit(int id, String type, Gamme gamme)
	{
		this.id = id;
		this.type = type;
		this.gamme = gamme;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void ajouterDuree(Machine m, Double d)
	{
		this.durees.put(m, d);
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.id == ((Produit)o).getId();
	}
	
}
