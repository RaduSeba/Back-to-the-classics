package uo.cpm.model;

public abstract class Cell {
	
	private int score;
	private String picture;
	
	public String getPicture() {
		return picture;
	}
	
	public String getSubstring()
	{
		if(picture.length()>10)
		{
			return picture.substring(picture.length()-10);
		}
		return picture;
		
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void discover()
	{
		
	}
}