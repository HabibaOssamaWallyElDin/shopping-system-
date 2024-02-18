package shopping;

import java.util.Scanner;
//creat class for product info

public class Guest implements ProductInformation{
	@Override
	//method to show product saved in the system & choose one of the two category to start shopping
	public void viewProducts() {
		System.out.println(" Choose category: \n"
				+ "1) Electronic devices\n"
				+ "2) clothes ");
		String category = (new Scanner(System.in)).nextLine();
		//the menu that will be shown to the guest if he want to start shopping for electronic devices section 
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
			 //creating new object from group to each item in the menu
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
				 //call function view product in the section of electronic devices at the same time section clothes will =null as user doesnot choose it  
			Admin.viewProducts(Product.ELECTRONICS, groupsOfElectronics);
		}
		else
			Admin.viewProducts(Product.CLOTHES,null);
	}

}
