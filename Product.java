package shopping;
//creat class for products

public class Product implements ProductInformation{   
	 //counter to save the ids of the product and count them
	private static int counter=0;            
	
	
	//private member to save(id,name,price,number of item in stock,category)for the product
	private String id;
	private String name;
	private double price;
	private int stock;
	private int category;
	//public function to save(id,name,price,number of item in stock)for the product
	
	public Product(String name, double price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.id=String.valueOf(counter);
		//counter to save and count the ids
		counter++;
	}
	//set and get functions for all members in this class
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	//function to view product information
	public static void showinfo(Product product)
	{
		
		System.out.println("Name -> " + product.getName());
		System.out.println("ID -> " + product.getId());
		//to allow user choose the category weather electronics or clothes
		//function for the electronic section&get group and model
		if(product.getCategory() == ELECTRONICS)
		{
			System.out.println("Group-> " + ((ElectronicsDevices)product).getGroup());
			System.out.println("Model-> " +((ElectronicsDevices)product).getModel());
		}
		else if(product.getCategory() == CLOTHES)
		{
			//asking user for gender and size of clothes he want to shop
			System.out.println("Gender-> " + ((Clothes)product).getGender());
			System.out.println("Size-> " + ((Clothes)product).getSize());
		}
		//to show price and stocked items
		System.out.println("Price-> " + product.getPrice());
		System.out.println("Stock-> " + product.getStock());
		System.out.println();
	}
	
	@Override
	//showing product information
	public void viewProducts() {
		showinfo(this);
	}
}
