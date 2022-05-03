package com.email;


class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity=600;
	private String email;

	private String alternateEmail;
	private String comapnySufix="edubridge.com";
	
	
//	static Connection conn;
//	static PreparedStatement pst;
//	static ResultSet rs;
//	
	


//constructor to receive the first name and last name
public Email(String firstName,String lastName){
	this.firstName=firstName;
	this.lastName=lastName;
	System.out.println("EMAIL CREATED: "+this.firstName +" "+this.lastName);
	
	
	
	//Call the methods that return Random Password
	
	
	
	
	//Combine element to generate email 
	email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department + comapnySufix;
	System.out.println("Your Email is -> "+email);
	}//email constructor

//Ask for the department 


	
	
	





// set the mailbox capacity
public void setMailboxCapacity(int capacity) {
	this.mailboxCapacity=capacity;
	
	
}

//set the alternative email
public void setAlternateEmail(String altEmail) {
	this.alternateEmail=altEmail;}


//change the passowrd
public void changePassword(String password) {
	this.password=password;
	
}
public int getMailboxCapacity(){
	String s="select * from emailrecord where customername=?";
//PreparedStatement	pst=
	
	return mailboxCapacity ;
	}
public String getAlternateEmail() {return alternateEmail;}
public String getPassword() {return password;}

public String showInfo() {
	return ("\nDISPLAY NAME: "+ firstName + " "+ lastName +
			" \nCOMPANY EMAIL : "+email +
			"\nMAILBOX CAPACITY : "+ mailboxCapacity + "mb");
}

}//Email Class

