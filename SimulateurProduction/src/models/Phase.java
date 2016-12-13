package models;

public class Phase {
	
	private int num;
	
	private Operation operation;
	
	private double duree;
	
	public Phase(int num, Operation o, double d)
	{
		this.num = num;
		this.operation = o;
		this.duree = d;
	}
	
	public Operation getOperation()
	{
		return this.operation;
	}
	
	public int getNum()
	{
		return this.num;
	}
	
	public double getDuree()
	{
		return this.duree;
	}
	
	public String toString()
	{
		return this.num + " - " + this.duree + " (" + this.operation + ")";
	}
	
	public boolean equals(Object o)
	{
		return this.num == ((Phase)o).getNum();
	}
	
}
