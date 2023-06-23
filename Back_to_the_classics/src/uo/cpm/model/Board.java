package uo.cpm.model;


public class Board {
	
	private  int dim = 7;
	Cell[][] cells;
	
	
	public Board() {
		
		cells = new Cell[dim][dim];
		for (int i=0;i<dim;i++)
		{
			for(int j=0;j<dim;j++)
			{
				cells[i][j]=new Blank();
			}
		}
		
		for(int i=0;i<5;i++)
		{
			int invaderPosition1 = (int) (Math.random() * dim);
			
			int invaderPosition2 = (int) (Math.random() * dim);
			if(invaderPosition1==0&&invaderPosition2==0)
			{
				invaderPosition1++;
				invaderPosition2++;
			}
			if(invaderPosition1==6&&invaderPosition2==0)
			{
				invaderPosition2++;
			}
			if(invaderPosition1==0&&invaderPosition2==6)
			{
				invaderPosition1++;
				invaderPosition2--;
			}
			if(invaderPosition1==3&&invaderPosition2==3)
			{
				invaderPosition1++;
				invaderPosition2++;
			}
			cells[invaderPosition1][invaderPosition2]= new Caracter();
		}
			
		
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public String getPicture(Integer position1,Integer position2)
	{
		return this.cells[position1][position2].getPicture();
	}
	
	
	public String getEliminate(Integer position1,Integer position2)
	{
		if(this.cells[position1][position2].getPicture().length()>10)
		{
			return this.cells[position1][position2].getPicture().substring(0,9);
		}
		return this.cells[position1][position2].getPicture();
	}
	
	public void setPicture(Integer position1,Integer position2,String p)
	{
		this.cells[position1][position2].setPicture(p);
	}
	
	
	
	
	
	public boolean comboLeader(String leader)
	{
		int combov=0;
		for (int i=0;i<dim;i++)
		{
			for(int j=0;j<dim;j++)
			{
				
				if(getEliminate(i, j).equals("eliminate"))
				{
					
					if(getPicture(i,j).substring(14,15).equals(leader))
					{
						combov++;
					}
				}
				
			}
			
			
		}
		
			if(combov>=5)
			{
				return true;
			}
		
		return false;
	}
	
	
	
	
	
	public void checkInvader(int i,int j)
	{
		String find=cells[i][j].getPicture();
		
		if(i==0)
		{
			if(cells[i+2][j].getSubstring().equals(find)&&cells[i+1][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i+2][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
				
			}
			if(cells[i][j-1].getSubstring().equals(find)&&cells[i][j+1].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
			if(j>1&&cells[i][j-1].getSubstring().equals(find)&&cells[i][j-2].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-2]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
			}
		 if(j<5&&cells[i][j+1].getSubstring().equals(find)&&cells[i][j+2].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j+2]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
			
			
		}
		else if(i==6)
		{
			if(cells[i-1][j].getSubstring().equals(find)&&cells[i-2][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i-2][j]=new Eliminate(find);
				
			}
			else if(cells[i][j-1].getSubstring().equals(find)&&cells[i][j+1].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
			if(j>1&&cells[i][j-1].getSubstring().equals(find)&&cells[i][j-2].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-2]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
			}
		 if(j<5&&cells[i][j+1].getSubstring().equals(find)&&cells[i][j+2].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j+2]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
		}
		else if(j==0)
		{
			if(cells[i-1][j].getSubstring().equals(find)&&cells[i+1][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
				
			}
			else if(cells[i][j+2].getSubstring().equals(find)&&cells[i][j+1].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j+2]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
		
		 if(i>1&&cells[i-1][j].getSubstring().equals(find)&&cells[i-2][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i-2][j]=new Eliminate(find);
			}
		 if(i<5&&cells[i+1][j].getSubstring().equals(find)&&cells[i+2][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i+2][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
			}
			
			
		}
		else if(j==6)
		{
			if(cells[i-1][j].getSubstring().equals(find)&&cells[i+1][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
				
			}
			else if(cells[i][j-1].getSubstring().equals(find)&&cells[i][j-2].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-2]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
			}
		
		 if(i>1&&cells[i-1][j].getSubstring().equals(find)&&cells[i-2][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i-2][j]=new Eliminate(find);
			}
		 if(i<5&&cells[i+1][j].getSubstring().equals(find)&&cells[i+2][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i+2][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
			}
		}
		else{
		
			if(cells[i-1][j].getSubstring().equals(find)&&cells[i+1][j].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i-1][j]=new Eliminate(find);
				cells[i+1][j]=new Eliminate(find);
			}
			 if(cells[i][j-1].getSubstring().equals(find)&&cells[i][j+1].getSubstring().equals(find))
			{
				cells[i][j]=new Eliminate(find);
				cells[i][j-1]=new Eliminate(find);
				cells[i][j+1]=new Eliminate(find);
			}
			 if(j>1&&cells[i][j-1].getSubstring().equals(find)&&cells[i][j-2].getSubstring().equals(find))
				{
					cells[i][j]=new Eliminate(find);
					cells[i][j-2]=new Eliminate(find);
					cells[i][j-1]=new Eliminate(find);
				}
			 if(j<5&&cells[i][j+1].getSubstring().equals(find)&&cells[i][j+2].getSubstring().equals(find))
				{
					cells[i][j]=new Eliminate(find);
					cells[i][j+2]=new Eliminate(find);
					cells[i][j+1]=new Eliminate(find);
				}
			 if(i>1&&cells[i-1][j].getSubstring().equals(find)&&cells[i-2][j].getSubstring().equals(find))
				{
					cells[i][j]=new Eliminate(find);
					cells[i-1][j]=new Eliminate(find);
					cells[i-2][j]=new Eliminate(find);
				}
			 if(i<5&&cells[i+1][j].getSubstring().equals(find)&&cells[i+2][j].getSubstring().equals(find))
				{
					cells[i][j]=new Eliminate(find);
					cells[i+2][j]=new Eliminate(find);
					cells[i+1][j]=new Eliminate(find);
				}
			 if(cells[i-1][j].getSubstring().equals(find)&&cells[i+1][j].getSubstring().equals(find)&&cells[i][j-1].getSubstring().equals(find)&&cells[i][j+1].getSubstring().equals(find))
				{
					cells[i][j]=new Eliminate(find);
					cells[i-1][j]=new Eliminate(find);
					cells[i+1][j]=new Eliminate(find);
				}
			 
			
		}
						
					
		
	}
	
	
//	public void checkInvader(int i, int j) {
//	    String find = cells[i][j].getPicture();
//
//	    // Check for horizontal patterns
//	    if (j >= 2 && cells[i][j - 2].getSubstring().equals(find) && cells[i][j - 1].getSubstring().equals(find)) {
//	        cells[i][j] = new Eliminate(find);
//	        cells[i][j - 1] = new Eliminate(find);
//	        cells[i][j - 2] = new Eliminate(find);
//	    } else if (j <= 4 && cells[i][j + 1].getSubstring().equals(find) && cells[i][j + 2].getSubstring().equals(find)) {
//	        cells[i][j] = new Eliminate(find);
//	        cells[i][j + 1] = new Eliminate(find);
//	        cells[i][j + 2] = new Eliminate(find);
//	    }
//
//	    // Check for vertical patterns
//	    if (i >= 2 && cells[i - 2][j].getSubstring().equals(find) && cells[i - 1][j].getSubstring().equals(find)) {
//	        cells[i][j] = new Eliminate(find);
//	        cells[i - 1][j] = new Eliminate(find);
//	        cells[i - 2][j] = new Eliminate(find);
//	    } else if (i <= 4 && cells[i + 1][j].getSubstring().equals(find) && cells[i + 2][j].getSubstring().equals(find)) {
//	        cells[i][j] = new Eliminate(find);
//	        cells[i + 1][j] = new Eliminate(find);
//	        cells[i + 2][j] = new Eliminate(find);
//	    }
//
//	    // Check for cross patterns
//	    if (i >= 1 && i <= 5 && j >= 1 && j <= 5) {
//	        if (cells[i - 1][j].getSubstring().equals(find) && cells[i + 1][j].getSubstring().equals(find) &&
//	            cells[i][j - 1].getSubstring().equals(find) && cells[i][j + 1].getSubstring().equals(find)) {
//	            cells[i][j] = new Eliminate(find);
//	            cells[i - 1][j] = new Eliminate(find);
//	            cells[i + 1][j] = new Eliminate(find);
//	            cells[i][j - 1] = new Eliminate(find);
//	            cells[i][j + 1] = new Eliminate(find);
//	        }
//	    }
//	}

	
	
	public boolean isFull()
	{
		for (int i=0;i<dim;i++)
		{
			for(int j=0;j<dim;j++)
			{
				if(i==0&&j==0)
				{
					
					
				}
				else if(i==6&&j==0)
				{
					
					
					continue;
				}
				else if(i==0&&j==6)
				{
					
					
				}
				else if(i==3&&j==3)
				{
					
					
				}
				else if(i==6&&j==6)
				{
					
					
				}
				else if(cells[i][j].getPicture().equals(""))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public int getDim()
	{
		return this.dim;
	}
}
