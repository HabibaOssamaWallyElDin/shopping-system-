package shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account{                      //creating class for the admins of the app
	private static int counter=0;

	private String id;                     //id number for the admin only bcan see
	private String name;                  //private variable for the admin name
	public static ArrayList<Product> products = new ArrayList<Product>();      //list having products name

	public Admin() {
		id = String.valueOf(counter);
		counter++;
		whoseaccount = 'A';
	}
	

	//function to show the products list to user and to choose one from the two category
	public static void viewProducts(int category, GroupsOfElectronics groupsOfElectronics) {                     
		
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getCategory() == Product.ELECTRONICS && category == Product.ELECTRONICS)
			{
				if(((ElectronicsDevices)products.get(i)).getGroup() == groupsOfElectronics)
				{
					Product.showinfo(products.get(i));
				}
			}
			else
			{
				if(products.get(i).getCategory() == Product.CLOTHES && category == Product.CLOTHES)
				{
					Product.showinfo(products.get(i));
				}
			}
		}
		
	}
	//function to add product to the list of products
	public void addProduct(Product product) {
		products.add(product);
	}
	//function to remove product to the list of products
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
	//function allow the admin to modify price or number of item in stock of the products
	public void modifyProduct(Product product, double price, int stock) {
		int i = 0;
		for (i = 0; i < products.size(); i++) {
			if(product.getId().equals(products.get(i).getId()))
			{
				
				products.get(i).setPrice(price);
				products.get(i).setStock(stock);
				break;
			}
		}
	}
	
	public static void showAccounts()
	{
		 System.out.println("customer account or admin account: \n"
			 		+ "1) customer\n"
			 		+ "2)  admin");
		 String ca=(new Scanner(System.in)).nextLine();
		 
		for (int i = 0; i < accounts.size(); i++) {
			if(ca.equals("1") && accounts.get(i).whoseaccount == 'C')
			{
				System.out.println("Name -> " + ((Customer)accounts.get(i)).getName());
				System.out.println("ID -> " + ((Customer)accounts.get(i)).getId());
				System.out.println("address -> " + ((Customer)accounts.get(i)).getAdress());
				System.out.println("phone number -> " + ((Customer)accounts.get(i)).getPhoneNumber());
			}
			else if(ca.equals("2") && accounts.get(i).whoseaccount == 'A')
				{
					System.out.println("Name -> " + ((Admin)accounts.get(i)).name);
					System.out.println("ID -> " + ((Admin)accounts.get(i)).id);
				}

		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
