package models;

import java.util.HashMap;

public class Produit {
	
	private int id;
	private String type;
	private Gamme gamme;
	//private HashMap<Machine, double> durees;
	
	public Produit(int id, String type, Gamme gamme)
	{
		this.id = id;
		this.type = type;
		this.gamme = gamme;
	}
	
	public int getId(){
		return this.id;
	}
	
}
