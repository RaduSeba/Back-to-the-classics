package uo.cpm.model;

public class Blank extends Cell{
	boolean erased;
	
	
	
	public void setErased(boolean erased) {
		this.erased = erased;
	}
	
	public Blank() {
	 
	 //setErased (false);
	
	 setPicture("");
	}
	@Override
	public void discover()
	{
		setErased(true);
		
	}
}
