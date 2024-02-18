package shopping;

import java.util.Scanner;
//inheritance
//extend class clothes from product class
public class Clothes extends Product {
	//private member hold gender and size of user
	private Gender gender;
	private Size size;
	
	//function to store name,price,stocked number of product
	
	public Clothes(String name, double price, int stock) {
		super(name, price, stock);
		super.setCategory(Product.CLOTHES);
	}
//choose female or male
	public enum Gender{
		MALE,FEMALE
	}
	//choose size
	public enum Size{
		XXS,XS,S,M,L,XL,XXL,XXXL,XXXXL
	}
	
	//setter and getter for gender class
	public Gender getGender() {
		return gender;
	}
	public void setGender() {
		Gender gender = null;
		System.out.println("select gender (M),(F)");
//only upper case letter accepted
		String s = (new Scanner(System.in)).nextLine();
		switch (s) {
			case "m":
			case "M":
				gender = Gender.MALE;
				break;
			case "f":
			case "F":
				gender = Gender.FEMALE;
				break;
		}
		this.gender = gender;
	}
	public void setGender(Gender g) {
		this.gender = g;
	}
	//getter and setter for size function
	public Size getSize() {
		return size;
	}
	public void setSize() {
		Size size = null;
		System.out.println("select size (XXS),(XS),(S),(M),(L),(XL),(XXL),(XXXL),(XXXXL)");

		String s = (new Scanner(System.in)).nextLine();
		switch (s.toLowerCase()) {
			case "xxs":
				size = Size.XXS;
				break;
			case "xs":
				size = Size.XS;
				break;
			case "s":
				size = Size.S;
				break;
			case "m":
				size = Size.M;
				break;
			case "l":
				size = Size.L;
				break;
			case "xl":
				size = Size.XL;
				break;
			case "xxl":
				size = Size.XXL;
				break;
			case "xxxl":
				size = Size.XXXL;
				break;
			case "xxxxl":
				size = Size.XXXXL;
				break;
		}
		this.size = size;
	}
	public void setSize(Size s) {
		this.size = s;
	}
}
