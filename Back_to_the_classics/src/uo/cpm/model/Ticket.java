package uo.cpm.model;

public class Ticket {
	
	private String number;
	private float price;

	public Ticket(String n, float p) {
		this.number=n;
		this.price=p;
	}

	
	public String getNumber()
	{
		return this.number;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}
