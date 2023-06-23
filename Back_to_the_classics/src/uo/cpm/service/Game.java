package uo.cpm.service;

import java.util.List;

import uo.cpm.model.Board;
import uo.cpm.model.Product;
import uo.cpm.model.Ticket;
import uo.cpm.rules.Menu;
import uo.cpm.rules.Order;
import uo.cpm.rules.Rules;
import uo.cpm.rules.TicketCheck;

public class Game {
	
	
	TicketCheck check= new TicketCheck();
	private Rules rules=new Rules();
	private int same=(int) (Math.random() * 7);
	Menu menu = new Menu();
	Order order = new Order();
	String[] filter = {"Filter by","Available Products","Accessories","Consoles","Videogames"};
	private Float money;
	private String caracters[]= {"/img/1.jpg","/img/2.png","/img/3.png","/img/4.jpg","/img/5.jpg","/img/6.png","/img/8.png","/img/7.png"};
	private String leader="/img/7.png";
	
	
	
	
	
	public String getLeader() {
		return this.leader;
	}

	public String getCharacterRandom() {
		
		return this.caracters[same];
	}
	
	public String getCharacterPicture(int i) {
		return this.caracters[i];
	}
	
	public boolean checkTicketPrice(Ticket t)
	{
		return check.checkValidityPrice(t);
	}
	
	public boolean checkTicketStore(Ticket t)
	{
		return check.checkValidityStore(t);
	}
	
	public void saveTicket()
	{
		check.save();
	}
	
	public void setMoney(Float m) {
		this.money=m;
	}
	
	public Float getMoney() {
		return this.money;
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
		updateMoneyAdd(p,units);
		
	}
	
	private void updateMoneyAdd(Product p, Integer units) {
		
		this.money=this.money-p.getPrice()*units;
	}
	
	private void updateMoneyDelete(Product p, Integer units) {
		
		this.money=this.money+p.getPrice()*units;
	}
	
	
	
	public void deleteOrder(Product p,Integer units)
	{
		order.delete(p, units);
		menu.delete(p,units);
		updateMoneyDelete(p,units);
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
