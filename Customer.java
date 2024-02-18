package shopping;

import java.util.Scanner;
//inheritance
//extend class from class account to p;roduct information

public class Customer extends Account implements ProductInformation{
	//private members to save(id,name,address,phone number,product in cart)
	private static int counter=0;
	
	 private String id;
	 private String name;
	 private String adress;
	 private String phoneNumber;
	 private Cart cart;
	
	 public Customer(String name, String adress, String phoneNumber, String userName, String passWord) {
		super();
		this.name = name;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.id=String.valueOf(counter);
		//counter to add customer
		counter++;
		//setter and getter function gor customer user name and password
		setUserName(userName);
		setPassWord(passWord);
		cart = new Cart();
		//if the account is for customer
		whoseaccount = 'C';
	 }
//setter and getter function for the private members in the class
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}
	@Override
	//function to choose the category
	public void viewProducts() {
		System.out.println("Choose category: \n"
				+ "1) Electronic devices\nn"
				+ "2) clothes ");
		String category = (new Scanner(System.in)).nextLine();
		//if the user choose electronic device section
		if(category.equals("1"))
		{
			 System.out.println("Enter group:\n"
				 		+ "\t (1) tv\n"
				 		+ "\t (2) PC_COMPUTERS \n"
				 		+ "\t (3) laptop\n"
				 		+ "\t (4) AIR_CONDITIONAR\n"
				 		+ "\t (5) MOBILE_PHONES \n"
				 		+ "\t (6) DISH_WASHER\n"
				 		+ "\t (7) REFRIGERATORS\n"
				 		+ "");
			 //to choose group from the previous menu
				 String group = (new Scanner(System.in)).nextLine();
				 GroupsOfElectronics groupsOfElectronics = null;
				 switch (group) {
				case "1": 
					groupsOfElectronics = GroupsOfElectronics.TV;
					break;
				case "2": 
					groupsOfElectronics = GroupsOfElectronics.PC_COMPUTERS;
					break;
				case "3": 
					groupsOfElectronics = GroupsOfElectronics.LAPTOPS;
					break;
				case "4":
					groupsOfElectronics = GroupsOfElectronics.AIR_CONDITIONAR;
					break;
				case "5": 
					groupsOfElectronics = GroupsOfElectronics.MOBILE_PHONES;
					break;
				case "6": 
					groupsOfElectronics = GroupsOfElectronics.DISH_WASHER;
					break;
				case "7": 
					groupsOfElectronics = GroupsOfElectronics.REFRIGERATORS;
					break;
				}
				 //show product belong to the group the user choose
			Admin.viewProducts(Product.ELECTRONICS, groupsOfElectronics);
		}
		//if the user choose clothes section
		else
			Admin.viewProducts(Product.CLOTHES,null);
	}
//function view item added to the cart
	public Cart getCart() {
		return cart;
	}
	
	

}
