package shopping;

import java.util.ArrayList;
import java.util.Scanner;

//creating class to save accounts customers,guest and admins

public class Account {
	//array list to save accounts
	public static ArrayList<Account> accounts = new ArrayList<Account>();
	//private member to save name,password and category of the account
	private String userName;
	private String passWord;
	protected char whoseaccount;
	
	//getter and setter function for the members nin the class
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	//function to check weather the account is new or exist
	public static Account checkaccount(String username, String password)
	{
		for (int i = 0; i < accounts.size(); i++) {
			if(username.equals(accounts.get(i).getUserName()) && password.equals(accounts.get(i).getPassWord()))
				return accounts.get(i);
		}
		return null;
	}
	//public class to add new account
	
    public static void addAccount(Account account) {
    	accounts.add(account);
    }
//function to check the validation of the password
	public static class passwordValidation {
	 //function to set the maximum lenght of the password   
	public static final int PASSWORD_LENGTH = 10;
//public function to check number of char in the passwords
	public static boolean check(String s) {
		//valid password
	        if (is_Valid_Password(s)) {
	        	return true;
	        } else {
	        	//in valid password
	            System.out.println("Not a valid password: " + s);
	        }
	        return false;

	    }
//function to count number of chars and digits in the password
	    private static boolean is_Valid_Password(String password) {

	        if (password.length() < PASSWORD_LENGTH) return false;

	        int charCount = 0;
	        int numCount = 0;
	        for (int i = 0; i < password.length(); i++) {

	            char ch = password.charAt(i);

	            if (is_Numeric(ch)) numCount++;
	            else if (is_Letter(ch)) charCount++;
	            else return false;
	        }
	        //to check is 2 char at least exist in the password

	        return (charCount >= 2 && numCount >= 2);
	    }
	    //to check is the letters is upper case or not 

	    public static boolean is_Letter(char ch) {
	        ch = Character.toUpperCase(ch);
	        return (ch >= 'A' && ch <= 'Z');
	    }
//to check the validity of digits
	    public static boolean is_Numeric(char ch) {

	        return (ch >= '0' && ch <= '9');
	    }
	    
		    
	}
}
