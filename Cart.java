package shopping;

import java.util.ArrayList;
//creat class for cart
public class Cart {
	//counter to add item in cart
	private static int counter=0;
//private member hold id and number of item in cart
	private String id;
	private int numberOfProduct;
	private ArrayList<Product>products=new ArrayList<Product>();
	//to calculate total price of items in cart
	private double totalPrice=0;
	public Cart() {
		//counter increase after adding new item
		this.id=String.valueOf(counter);
		counter++;
		
	}
	//functio to add product to cart
	public void addProduct(Product product) {
		products.add(product);
	}
	//function to delete product from cart
	public boolean deleteProduct(Product product) {
		int i = 0;
		for (i = 0; i < products.size(); i++) {
			if(product.getId().equals(products.get(i).getId()))
			{
				products.remove(i);
				System.gc();
				return true;
			}
		}
		return false;
	}
	//show product in cart
	public void viewProducts() {
		for (int i = 0; i < products.size(); i++) {
			Product.showinfo(products.get(i));
		}
	}
	//get total price for items in the cart
	public double getTotalPrice() {
		calculateTotal();
		return totalPrice;
	}
	private void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	private void calculateTotal()
	{
		double sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getPrice();
		}
		setTotalPrice(sum);
	}
	//to allow user submit the total order in the cart
	public void submit()
	{
		for (int i = 0; i < products.size(); i++) {
			for (int j = 0; j < Admin.products.size(); j++) {
				if(products.get(i).getId().equals(Admin.products.get(j).getId()))
				{
					int stock = Admin.products.get(j).getStock();
					Admin.products.get(j).setStock(stock - 1);
				}
			}
		}
	}

}
