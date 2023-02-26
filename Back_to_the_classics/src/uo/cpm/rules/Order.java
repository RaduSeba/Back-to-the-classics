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

	public void add(Product item, int units){
		Product itemInOrder = null;
	
		for (Product a : orderList){
			if (a.getCode().equals(item.getCode()))
			{
				itemInOrder = a;
				itemInOrder.setUnits(itemInOrder.getUnits()+units);
				break;
			}
		}
		
		if (itemInOrder == null){
			Product itemToOrder = new Product(item);
			itemToOrder.setUnits(units);
			orderList.add(itemToOrder);
		}
	}
	
	public void delete(Product item, int units )
    {
    	Product itemInOrder = null;
    	


    	for (Product a : orderList) {
    		
    	    if (a.getCode().equals(item.getCode()) ) {
    		itemInOrder = a;
    		
    		if(itemInOrder.getUnits()-units<0)
    		{
    			itemInOrder.setUnits(0);
    			break;
    		}
    		itemInOrder.setUnits(itemInOrder.getUnits() - units);


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
