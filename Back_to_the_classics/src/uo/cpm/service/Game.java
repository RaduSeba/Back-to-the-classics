package uo.cpm.service;

import java.util.List;

import uo.cpm.model.Board;
import uo.cpm.model.Menu;
import uo.cpm.model.Product;
import uo.cpm.model.Ticket;
import uo.cpm.rules.Order;
import uo.cpm.rules.Rules;
import uo.cpm.rules.TicketCheck;

public class Game {
	
	
	TicketCheck check= new TicketCheck();
	private Rules rules=new Rules();
	Menu menu = new Menu();
	Order order = new Order();
	String[] filter = {"Filter by","Available Products","Accessories","Consoles","Videogames"};

	
	public boolean checkTicket(Ticket t)
	{
		return check.checkValidity(t);
	}
	
	public void saveTicket()
	{
		check.save();
	}
	
	public Ticket getTicket(String code)
	{
		return check.getTicket(code);
	}
	
	public void delete(Ticket t)
	{
		check.remove(t);
	}
	
	public Board getBoard()
	{
		return rules.getBoard();
	}

	public void initialize()
	{
		rules.initialize();
	}
	
	public Integer getWave()
	{
		return rules.getWave();
	}
	
	public void updateWave()
	{
		rules.updateWave();
	}
	
	public void updateScore(boolean c,int s)
	{
		rules.setScore(c,s);
	}

	public void shoot(int i,int j)
	{
		rules.shoot(i,j);
	}

	public boolean isGameOver()
	{
		return rules.isGameOver();
	}
	public boolean win()
	{
		return rules.win();
	}
	
	
	public Float getScore()
	{
		return rules.getScore();
	}

	public void launch()
	{
		rules.launch();
	}

	public int getInvaders()
	{
		return rules.getInvaders();
	}
	public String getImage(int i,int j)
	{
		return rules.getImage(i,j);
	}
	
	public List<Product> getMenuProducts()
	{
		return menu.getProducts();
	}

	public void initOrder()
	{
		order.initialize();
	}
	
	 public String[] getFilter() {
		
		return this.filter;
	 }
	 
	 public List<Product> getOrder()
	 {
		 return order.getOrder();
	 }
	
	
	public void addToOrder ( Product p, Integer units )
	{
		order.add(p, units);
		menu.add(p,units);
		
	}
	
	
	
	public void deleteOrder(Product p,Integer units)
	{
		order.delete(p, units);
		menu.delete(p,units);
	}
	
	public void saveOrder()
	{
		order.saveOrder(check.getStore().getCode());
	}

	public Float getOrderTotal() {
		
		return order.getPrice();
	}
	
	public Product getProduct(String name)
	{
		return menu.getProduct(name);
	}
	
	public void setId(String Id)
	{
		order.setId(Id);
	}
	
	
	

}
