package Admin_Task_Management_System;


public class User{
	
	/*                    
	 Customer Class:

Attributes[ data members or variables that define the state of an object] :
 CustomerID, customerName, customerAddress, customerEmailID,
            customerPassword, customerPhoneNumber.
Methods: Constructors, getters, setters, and toString.
Functionality: Represents a customer with unique ID and stores personal information.
	 */

	private int UserID;
	private static int idgen=001;
    private String UserName;
    private String UserAddress;
    private String UserEmailID;
    private String UserPassword;
    private long UserPhoneNumber;


	public User() { // default constructor
		UserID =idgen++;

	}


	public int getUserID() {
		return UserID;
	}


	public void setUserID(int UserID) {
		UserID = UserID;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String UserName) {
		this.UserName = UserName;
	}


	public String getUserAddress() {
		return UserAddress;
	}


	public void setUserAddress(String UserAddress) {
		this.UserAddress = UserAddress;
	}


	public String getUserEmailID() {
		return UserEmailID;
	}


	public void setUserEmailID(String UserEmailID) {
		this.UserEmailID = UserEmailID;
	}


	public String getUserPassword() {
		return UserPassword;
	}


	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}


	public long getUserPhoneNumber() {
		return UserPhoneNumber;
	}


	public void setUserPhoneNumber(long UserPhoneNumber) {
		this.UserPhoneNumber = UserPhoneNumber;
	}
	
	public User(String UserName, String UserAddress, String UserEmailID, String UserPassword,
			long UserPhoneNumber, String teamName, String organizationName)   //parameterized constructor
	{
		this();
		this.UserName = UserName;
		this.UserAddress = UserAddress;
		this.UserEmailID = UserEmailID;
		this.UserPassword = UserPassword;
		this.UserPhoneNumber = UserPhoneNumber;
	}


	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", UserName=" + UserName + ", UserAddress="
				+ UserAddress + ", UserEmailID=" + UserEmailID + ", UserPassword=" + UserPassword
				+ ", UserPhoneNumber=" + UserPhoneNumber + "]";
	}



	
	

	


}	




