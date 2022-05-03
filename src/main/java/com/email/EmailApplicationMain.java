package com.email;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmailApplicationMain {

	private static final String String = null;

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		EmailAppDataBaseOperations ob = new EmailAppDataBaseOperations();
		System.out.println("Enter first name");
		String firstName=br.readLine();
		System.out.println("Enter last name");
		String lastName=br.readLine();
		
		
		// Email em1=new  Email(firstName, lastName);
		while(true) {
			System.out.println("*****MENU***********");
			System.out.println("WELCOME TO EMAIL CREATION");
			System.out.println("1.Insert ");
			System.out.println("2.update  Data");
			System.out.println("3.Delete  Data");
			System.out.println("4.Display  Data");
			System.out.println("5.Particular customer Data");
			System.out.println("Enter the option");
			int ch=Integer.parseInt(br.readLine());
			int id;
			switch(ch) {
			
			case 1:ob.insetRecord();
//					System.out.println("Enter the customer name");
//					String firstNAme=br.readLine();
			//Email em1=new  Email(firstName, lastName);
						break;
			case 2:
				//Email em2=new  Email(firstName, lastName);
				System.out.println("Enter customer id which u  want to  update");
				 id=Integer.parseInt(br.readLine());
		
				ob.updateRecord(id);
				
			        break;
			case 3: 
				//Email em3=new  Email(firstName, lastName);
				System.out.println("Enter customer id which u  want to  update");
				 id=Integer.parseInt(br.readLine());
				ob.deleteRecord(id);
			         break;
			case 4:
				//Email em4=new  Email(firstName, lastName);
				ob.displayAllRecord();
			        break;
			case 5:
				//Email em5=new  Email(firstName, lastName);
				ob.displayParticlarRecord();
			       break;
			   
			        
			}
			System.out.println("Do you want to continue Y/N");
			char choice=br.readLine().charAt(0);
			if(choice=='N' || choice=='n') {
				break;
			}
		}
		
	}

}
