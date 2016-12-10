package models;

public class Produit {
	
	private int id;
	private String type;
	private double duree;
	private Gamme gamme;
	
	public Produit(int id, String type, double duree, Gamme gamme)
	{
		this.id = id;
		this.type = type;
		this.duree = duree;
		this.gamme = gamme;
	}
}
