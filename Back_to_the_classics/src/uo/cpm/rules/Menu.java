package uo.cpm.rules;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.model.Product;
import uo.cpm.util.FileUtilProduct;


public class Menu {
	
	private static final String PRODUCTS_FILE = "files/awards.dat";
	private List<Product> productsList = null;
	
	public Menu(){
		productsList = new ArrayList<Product>();
		loadProducts();
	}

	private void loadProducts(){
		FileUtilProduct.loadFile (PRODUCTS_FILE, productsList);
	  }

	public List<Product> getProducts(){
		return productsList;
	}
	public Product getProduct(String name)
	{
		Product itemInOrder = null;
    	

    	for (Product a : productsList) {
    	    if (a.getName().equals(name)) {
    		itemInOrder = a;
    		
    		break;
    	    }
    	}
    	return itemInOrder;
	}
	public void add(Product item, int units){
		Product itemInOrder = null;
	
		for (Product a : productsList){
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
		}
	}
	
	public void delete(Product item, int units )
    {
    	Product itemInOrder = null;
    	


    	for (Product a : productsList) {
    		
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
	
	
}