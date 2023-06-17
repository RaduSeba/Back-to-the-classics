package uo.cpm.rules;

import uo.cpm.model.Board;
import uo.cpm.model.Caracter;

public class Rules {
	

	public static final Integer CARACTERS = 8;
	private Board board; 
	int score;
	Integer wave;
	int invaders;
	
	public Rules() {
		initialize();
	}
	
	public Board getBoard() {
		return board;
	}

	
		
	
	public void initialize(){
		board = new Board();
		score = 0;
		wave=1;
		invaders=8;
	}

	public void shoot(int i,int j){
		
		
		if (board.getCells()[i][j] instanceof Caracter) {
			((Caracter)board.getCells()[i][j]).setErased(true);
			
		}
		//score = score + board.getCells()[i][j].discover();
	}
	
	
	
	public boolean isGameOver() {
		if(board.isFull()==true)
		{
			return true;
		}
		if(this.wave==11)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean win()
	{
		if(board.isFull()== false)
		{
			if(this.wave==11)
			{
				return true;
			}
		}
		return false;
	}

	
	
	public void launch() {
		setInvaders(8);	
	}
	
	public int getInvaders() {
		return invaders;
	}
	
	public Integer getWave()
	{
		return this.wave;
	}
	
	public void updateWave()
	{
		this.wave=this.wave+1;
	}

	private void setInvaders(int number) {
		this.invaders = number;
	}
	
	public float getScore()
	{
		return this.score;
	}
	
	public void setScore(boolean c,int s)
	{
		if(c==true)
		{
			this.score=this.score+20000;
		}
		if(s==3)
		{
			this.score=this.score+50;
		}
		else if(s==4)
		{
			this.score=this.score+200;
		}
		else if(s==5)
		{
			this.score=this.score+1000;
		}
		else if(s==6)
		{
			this.score=this.score+5000;
		}
		else if(s>=7)
		{
			this.score=this.score+10000;
		}
		
	}
	
	
	public String getImage(int i,int j)
	{
		return getBoard().getPicture(i, j);
	}
	

	

}
