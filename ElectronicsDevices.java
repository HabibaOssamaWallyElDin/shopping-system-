package shopping;
//inheritance
//extend new class from the super class for electronic devices section

public class ElectronicsDevices extends Product {
	//two private member for the group and the model of the device
	
	private GroupsOfElectronics group;
	private String  model;
	
	//function that take name,price and number of item in stock
	public ElectronicsDevices(String name, double price, int stock) {
		super(name, price, stock);
	}
	//get function for class group

	public GroupsOfElectronics getGroup() {
		return group;
	}
//set function for class group
	public void setGroup(GroupsOfElectronics group) {
		this.group = group;
	}
	//get function for model of device
	public String getModel() {
		return model;
	}
	//set function for model of device
	public void setModel(String model) {
		this.model = model;
	}


}
