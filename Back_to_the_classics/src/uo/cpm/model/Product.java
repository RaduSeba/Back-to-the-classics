package uo.cpm.model;


public class Product {

	private String code;
	private String type;
	private String name;
	private String description;
	private float price;
	private int units;
	private String imagePath;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Product(String code,String name,String description ,String type,float price, int units) {
		this.code = code;
		this.type = type;
		this.name = name;
		this.price = price;
		this.units = units;
		this.description=description;
		this.imagePath = new StringBuffer("/img/").append(this.code).append(".png").toString();
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Product(Product anotherItem) {
		this(anotherItem.code, anotherItem.name, anotherItem.type,anotherItem.description,anotherItem.price, anotherItem.units);
	}

	public String getName() {
		return name;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name);
		buffer.append(" - ");
		buffer.append(this.price);
		buffer.append(" points");
	
			buffer.append(" (");
			buffer.append(this.units);
			buffer.append(" uds)");
		
		return buffer.toString();
	}
}
