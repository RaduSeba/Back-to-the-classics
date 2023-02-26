package uo.cpm.model;

public class Caracter extends Cell{
	boolean erased;
	private String caracters[]= {"/img/1.jpg","/img/2.png","/img/3.png","/img/4.jpg","/img/5.jpg","/img/6.png","/img/7.png","/img/8.png"};
	
	
	
	public void setErased(boolean erased) {
		this.erased = erased;
	}
	
	public Caracter() {
	 
	 //setErased (false);
	 int invaderPicture = (int) (Math.random() * 7);
	 setPicture(caracters[invaderPicture]);
	}
	@Override
	public void discover()
	{
		setErased(true);
		
	}
}