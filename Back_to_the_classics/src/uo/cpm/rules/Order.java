package uo.cpm.rules;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.model.Product;
import uo.cpm.util.FileUtilProduct;



public class Order {
	
	private List<Product> orderList = null;
	private String id="";
	
	public Order(){
		orderList = new ArrayList<Product>();
		//We generate the new code for the order:
		
	}


	
	public void add(Product item, int units) {
	    Product itemInOrder = null;

	    for (Product a : orderList) {
	        if (a.getCode().equals(item.getCode())) {
	            itemInOrder = a;
	            break;
	        }
	    }

	    if (itemInOrder != null) {
	        itemInOrder.setUnits(itemInOrder.getUnits() + units);
	    } else {
	        Product itemToOrder = new Product(item);
	        itemToOrder.setUnits(units);
	        orderList.add(itemToOrder);
	    }
	}

	
	

	
	public void delete(Product item, int units) {
	    for (Product a : orderList) {
	        if (a.getCode().equals(item.getCode())) {
	            if (a.getUnits() - units < 0) {
	                a.setUnits(0);
	            } else {
	                a.setUnits(a.getUnits() - units);
	            }

	            if (a.getUnits() == 0) {
	                orderList.remove(a);
	            }

	            break;
	        }
	    }
	}

	
	
	
	public String getCode() {
		return id;
	}

	public float getPrice(){
		float total = 0.0f;
		for (Product a : orderList){
			total += a.getPrice()* a.getUnits();
		}
		return total;
	}
	
	public void saveOrder(String code){
		FileUtilProduct.saveToFile("deliveries",id,code, orderList);
	  }

	public void initialize(){
		orderList.clear();
	}
	
	public List<Product> getOrder()
	{
		return orderList;
	}
	public void setId(String Id)
	{
		this.id=Id;
	}
	
	
}
