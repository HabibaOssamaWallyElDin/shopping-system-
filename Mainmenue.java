
package shopping;

import java.util.ArrayList;

import java.util.Scanner;

//creating class for the main menu to allow user using the application

public class Mainmenue {
	//main class
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		start();
		
		
//first menu to choose weather the user admin in the application,customer or guest
	while (true) {
		System.out.println("Welcome to Habiba's shopping application!!");
		System.out.println("log in as:\n"
				+ "1) admin\n"
				+ "2) customer \n"
				+ "3) guest");
		 String login=scan.nextLine();
		 //to choose new admin or exist admin in the application
		 if (login.equals("1")){
			 System.out.println("choose option: \n"
			 		+ "1) new admin \n"
			 		+ "2) exist admin"
				 	);
			 //if the user is new admin must have new user name and password
				String adminoptions=scan.nextLine();
				 if  (adminoptions.equals("1")) {
					 System.out.println("Enter your name");
					 String name=scan.nextLine();
					 System.out.println("Enter your user name");
					 String username=scan.nextLine();
					 String password = "";
					 while(true)
					 {
						 //check validty of password
					      System.out.print(
					              "1. A password must have at least ten characters.\n" +
					              "2. A password must have only letters and digits.\n" +
					              "3. A password must have at least two digits \n" +
					              "Input a password (You agreed the previous Terms and policies.): ");
						 System.out.println("Enter your password");
						 password=scan.nextLine();
						 if(Account.passwordValidation.check(password)) {
							 break;
						 }
					 }
					 //creating new admin 
					 Admin a = new Admin();
					 a.setUserName(username);
					 a.setPassWord(password);
					 a.setName(name);
					 Account.addAccount(a);
				 }
				 //if the user is exist admin so he have password and user name in the application
				 else if  (adminoptions.equals("2")) {
					 System.out.println("Enter user name");
					 String username = scan.nextLine();
					 System.out.println("Enter password");
					 String password = scan.nextLine();
					 Account account = Account.checkaccount(username, password);
					 if(account == null)
					 {
						 //check weather the user name and password are exist or not
						 System.out.println("the user name and the password are not exist");
					 }
					 else
					 {
						 while(true)
						 {
							 //menu of function for the admin
							 System.out.println("choose option: \n"
								 		+ "1) show accounts\n"
								 		+ "2) show products \n"
								 		+ "3) Add products \n"
								 		+ "4) Remove products \n"
								 		+ "5) Modify products \n"
								 		+ "6) sign out");
							 String adminapp=scan.nextLine();
							 //allow admin see all accounts in the application
							 if  (adminapp.equals("1")) {
								 Admin.showAccounts();
							 }
							 //allow admin to choose one of the two section in the application
							 else if  (adminapp.equals("2")) {
								 System.out.println("choose category:\n"
								 		+ "(1) Electronic devices \n"
								 		+ "(2) clothes");
								 String selectcategory=scan.nextLine();
								 if(selectcategory.equals("1"))
								 {
//if the admin choose electronic devices section so menu of the groups in the section appear 
									 System.out.println("Enter group:\n"
										 		+ "\t (1) tv\n"
										 		+ "\t (2) PC_COMPUTERS \n"
										 		+ "\t (3) laptop\n"
										 		+ "\t (4) AIR_CONDITIONAR\n"
										 		+ "\t (5) MOBILE_PHONES \n"
										 		+ "\t (6) DISH_WASHER\n"
										 		+ "\t (7) REFRIGERATORS\n"
										 		+ "");
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
									Admin.viewProducts(Product.ELECTRONICS, groupsOfElectronics);
								 }
								 else if(selectcategory.equals("2"))
								 {
	//at this time clothes class will equal null as admin choose electronic devices section
									 Admin.viewProducts(Product.CLOTHES,null);
								 }
							 }
						 //allow admin to add product in the application
							 else if  (adminapp.equals("3")) {
								 
								 System.out.println("Enter product name");
								 String name = scan.nextLine();
								 System.out.println("Enter product price");
								 String price = scan.nextLine();
								 System.out.println("Enter product stock");
								 String stock = scan.nextLine();
								 
								 Product product = null;
				//to allow admin to choose which section to add product on it
								 System.out.println("Enter letter c for clothes or enter e for electronic devices");
								 String category = scan.nextLine();
								 if("e".equals(category.toLowerCase()))
								 {
									 //if admin want to add product in electronic devices section
									 product = new ElectronicsDevices(name, Double.parseDouble(price), Integer.parseInt(stock));
									 product.setCategory(Product.ELECTRONICS);
									 System.out.println("Enter group:\n"
									 		+ "\t (1) tv\n"
									 		+ "\t (2) PC_COMPUTERS \n"
									 		+ "\t (3) laptop\n"
									 		+ "\t (4) AIR_CONDITIONAR\n"
									 		+ "\t (5) MOBILE_PHONES \n"
									 		+ "\t (6) DISH_WASHER\n"
									 		+ "\t (7) REFRIGERATORS\n"
									 		+ "");
									 String group = scan.nextLine();
									 switch (group) {
									 //to allow admin choose which group in this section to add product on it
									case "1": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.TV);
										break;
									case "2": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.PC_COMPUTERS);
										break;
									case "3": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.LAPTOPS);
										break;
									case "4":
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.AIR_CONDITIONAR);
										break;
									case "5": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.MOBILE_PHONES);
										break;
									case "6": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.DISH_WASHER);
										break;
									case "7": 
										((ElectronicsDevices)product).setGroup(GroupsOfElectronics.REFRIGERATORS);
										break;
									}
									 System.out.println("Enter the model for electronic device");
									 String model = scan.nextLine();
									 ((ElectronicsDevices)product).setModel(model);
									 
								 }
								 else if("c".equals(category.toLowerCase()))
								 {
									 //allow admin add product in section clothes
									 product = new Clothes(name, Double.parseDouble(price), Integer.parseInt(stock));
									 ((Clothes)product).setSize();
									 ((Clothes)product).setGender();;
									 product.setCategory(Product.CLOTHES);
								 }
								 
								 ((Admin)account).addProduct(product);
							 }
							 //allow admin remove product from application
							 else if  (adminapp.equals("4")) {
								 System.out.println("Enter product name");
								 String name = scan.nextLine();
								 ArrayList<Product> products= Admin.products;
								 Product p = null;
								 for (int i = 0; i < products.size(); i++) {
									if(products.get(i).getName().equals(name))
										p=products.get(i);
								}
								 //check weather product is  already exist in the list or not
								 if(p == null)
									 System.out.println("the product is not exist in the list");
								 else
									 ((Admin)account).deleteProduct(p);
							 }
							 else if  (adminapp.equals("5")) {
								 //allow admin to modify any product in application by its name
								 System.out.println("Enter product name");
								 String name = scan.nextLine();
								 ArrayList<Product> products= Admin.products;
								 Product p = null;
								 for (int i = 0; i < products.size(); i++) {
									if(products.get(i).getName().equals(name))
										p=products.get(i);
								}
								 if(p == null) {
									 //check weather the product exist in the application or not
									 System.out.println("the product is not exist in the list");
								 }
								 else
								 {
						//if the product exist then admin should write its modification 
									 System.out.println("Enter product price");
									 String price = scan.nextLine();
									 System.out.println("Enter product stock");
									 String stock = scan.nextLine();
									 ((Admin)account).modifyProduct(p, Double.parseDouble(price), Integer.parseInt(stock));
								 }
							 }
							 //to sign out of the application
							 else if  (adminapp.equals("6")) {
								 break;
							 }
							 
						 }
					 }
				 }
		 }
		 //if the user login in the application as customer
		 //user must write the user name and password
		 else if  (login.equals("2")) {
			 System.out.println("Enter user name");
			 String username = scan.nextLine();
			 System.out.println("Enter password");
			 String password = scan.nextLine();
			 Account account = Account.checkaccount(username, password);
			 if(account == null)
			 {
				 //check if the user name and password of customer already exist or not
				 System.out.println("the user name and the password are not exist");
			 }
			 else
			 {
				 while(true)
				 {
					 //menu that allow customer to use the application
					 System.out.println("choose option: \n"
						 		+ "1) start shopping \n"
						 		+ "2) Add product to cart \n"
						 		+ "3) Remove product from cart \n"
						 		+ "4) view products in cart \n"
						 		+ "5) buy product in cart \n"
						 		+ "6) sign out");
					 String customerOption=scan.nextLine();
					 if  (customerOption.equals("1")) {
						 //function allow customer to view products in the application to start shopping
						 ((Customer)account).viewProducts();
					 }
					 //function allow customer to add item in cart 
					 else if  (customerOption.equals("2")) {
						 System.out.println("Enter product name");
						 String name = scan.nextLine();
						 ArrayList<Product> products= Admin.products;
						 Product p = null;
						 for (int i = 0; i < products.size(); i++) {
							if(products.get(i).getName().equals(name))
								p=products.get(i);
						}
						 if(p == null)
							 //check weather the product exist in the list or not
							 System.out.println("the product is not exist in the list");
						 else
							 ((Customer)account).getCart().addProduct(p);
					 }
					 //allow customer remove item frm cart
					 else if  (customerOption.equals("3")) {
						 System.out.println("Enter product name");
						 String name = scan.nextLine();
						 ArrayList<Product> products= Admin.products;
						 Product p = null;
						 for (int i = 0; i < products.size(); i++) {
							if(products.get(i).getName().equals(name))
								p=products.get(i);
						}
						 if(p == null)
							 System.out.println("the product is not exist in the list");
						 else
							 ((Customer)account).getCart().deleteProduct(p);
					 }
					 //allow customer to preview item on his cart
					 else if  (customerOption.equals("4")) {
						 ((Customer)account).getCart().viewProducts();
					 }
					 //function allow customer to know total price of total items in the cart
					 
					 else if  (customerOption.equals("5")) {
						 ((Customer)account).getCart().viewProducts();
						 System.out.println("\n total price:" + ((Customer)account).getCart().getTotalPrice());
						 Customer customer = (Customer) account;
						 //to submit the address and phone number of customer
						 System.out.println("name -> " + customer.getName() + "\n"
						 		+ "adress -> " + customer.getAdress() + "\n"
						 		+ "phone -> " + customer.getPhoneNumber() + "\n"
						 		);
						 //to submit the order before buy it
						 System.out.println("Are you sure you want to submit order or edit your data?\n"
							 		+ "(1) yes, i am sure i want to submit order \n"
							 		+ "(2) no, i want to edit informations");
						 
							 String submit=scan.nextLine();
							 if(submit.equals("1"))
							 {
								 customer.getCart().submit();
								 System.out.println(" Thank you for using my application! ;D");
							 }
							 else if(submit.equals("2"))
							 {
								 System.out.println("Enter your name");
								 String name=scan.nextLine();
								 System.out.println("Enter your phone number");
								 String phonenumber=scan.nextLine();
								 System.out.println("Enter your address");
								 String address=scan.nextLine();
								 customer.setName(name);
								 customer.setAdress(address);
								 customer.setPhoneNumber(phonenumber);
								 
							 }
						 //to allow customer log out the application
					 }
					 else if  (customerOption.equals("6")) {
						 break;
					 }
				 }
			 }
		 }
		 //user choose log in as a guest
		 else if (login.equals("3")) {
			 Guest g=new Guest();
			 //ask user to continue as guest and view product directly or signup to be customer
			 System.out.println("choose option: \n"
			 		+ "1) sign up \n"
			 		+ "2) view product");
			 String guestoptions=scan.nextLine();
			 //if the guest want to sign up so he must write user name,phone number,address and name
			 if (guestoptions.equals("1")){
				  
				 System.out.println("Enter your name");
				 String name=scan.nextLine();
				 System.out.println("Enter your phone number");
				 String phonenumber=scan.nextLine();
				 System.out.println("Enter your address");
				 String address=scan.nextLine();
				 System.out.println("Enter your user name");
				 String username=scan.nextLine();
				 String password = "";
				 while(true)
				 {
					 //check the validity of password
				      System.out.print(
				              "1. A password must have at least ten characters.\n" +
				              "2. A password must have only letters and digits.\n" +
				              "3. A password must have at least two digits \n" +
				              "Input a password (You agreed the previous Terms and policies.): ");
					 System.out.println("Enter your password");
					 password=scan.nextLine();
					 if(Account.passwordValidation.check(password)) {
						 break;
					 }
				 }
				 //add new account
				 Customer c = new Customer(name, address, phonenumber, username, password);
				 //Polymorphism
				Account.addAccount(c);
			 }
			 //if guest wants to continue as guest
			 else if  (guestoptions.equals("2")) {
				 g.viewProducts();
				 
			 }
			 
			 
		 }
		 
	}
		 
		
	}
	private static void start()
	{
		//data already exist in application
		Admin mainadmin = new Admin();
		mainadmin.setName("habiba");
		mainadmin.setUserName("habiba ossama");
		mainadmin.setPassWord("habiba12345");
		Account.accounts.add(mainadmin);
		//loop to add new product in the system in electronic devices section
		String[] namess = new String[]
				{
				"LG AI thinq","Samsung new generation",
				"Apple ii series","IBM-8800 series",
				" Apple MacBookPro","Huawei matebook",
				"LG 6 horse","unionaire 2horse",
				"Apple iphone 11","samsung note 20",
				"LG digital D1450LF1","Samsung new PI584bj",
				"LG 508","samsung twinz"
				};
		//prices of the products in the previous loop by order
		double[] pricess = new double[]
				{
				 15000.999,12000.999,
				 5500.999,6540.999,
				 63000.999,2000.999,
				 5000.999,35000.999,
				 14000.999,2000.999,
				 17000.999,18500.999,
				 11500.999,9800.999
				};
		GroupsOfElectronics[] groupss = new GroupsOfElectronics[]
				{
					GroupsOfElectronics.TV,
					GroupsOfElectronics.PC_COMPUTERS,
					GroupsOfElectronics.LAPTOPS,
					GroupsOfElectronics.AIR_CONDITIONAR,
					GroupsOfElectronics.MOBILE_PHONES,
					GroupsOfElectronics.DISH_WASHER,
					GroupsOfElectronics.REFRIGERATORS
				};
		//loop for the models 
		String[] modelss = new String[]
				{
				"LG","Samsung",
				"Apple","IBM",
				"Apple","Huawei",
				"LG","unionaire",
				"Apple","Samsung",
				"LG","Samsung",
				"LG","Samsung"
				};
		for (int i = 0; i < 14; i++) {
			Product pr = new ElectronicsDevices(namess[i], pricess[i], (int)((Math.random()*100)+1));
			pr.setCategory(Product.ELECTRONICS);
			((ElectronicsDevices)pr).setGroup(groupss[i/2]);
			((ElectronicsDevices)pr).setModel(modelss[i]);
			Admin.products.add(pr);
		}
		
		//loop to add new product in the system in clothes section
		String[] nameses = new String[]
				{
				"t-shirts","pants","chemises","skirts","blouses"
				,"jackets"
				};
		//loop to choose the gender
		Clothes.Gender[] genderses = new Clothes.Gender[]
				{
					Clothes.Gender.MALE,Clothes.Gender.FEMALE
				};
		//loop for all size avaliable
		Clothes.Size[] sizeses = new Clothes.Size[]
				{
						Clothes.Size.XXS,
						Clothes.Size.XS,
						Clothes.Size.S,
						Clothes.Size.M,
						Clothes.Size.L,
						Clothes.Size.XL,
						Clothes.Size.XXL,
						Clothes.Size.XXXL,
						Clothes.Size.XXXXL
				};
		// loop to view price rondomly 
		for (int i = 0; i < 6; i++) {
			Product pr = new Clothes(nameses[i], (Math.random()*1000*3)+200, (int)((Math.random()*100)+1));
			pr.setCategory(Product.CLOTHES);
			int x = (int)(Math.random()*2);
			((Clothes)pr).setGender(genderses[x]);
			x = (int)(Math.random()*9);
			((Clothes)pr).setSize(sizeses[x]);
			Admin.products.add(pr);
		}
	}
}
