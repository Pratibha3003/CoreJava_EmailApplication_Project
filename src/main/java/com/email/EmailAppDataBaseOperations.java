package com.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmailAppDataBaseOperations {
	static Connection conn;
	static PreparedStatement pst;
	static ResultSet rs;
	 String  sn;
	 int  cd;
		private int defaultPasswordLength=10;
		private String comapnySufix="edubridge.com";
		private int mailboxCapacity=600;
		
	
	 void insetRecord() throws  IOException, SQLException {
		 try {
		conn=EmailAppDataBaseUtilityClass.getConnection();
		
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	   String s = "create table EmailRecord(id int4() primary key,CustomerName varchar(20) not null, DepartmentCode int(4) not null,
//	   DepartmentName varchar(20) not null,
//	   RandomPassword varchar(40),emailaddress varchar(40),MailBoxCapacity int(4));
//	
	   System.out.println("Enter customer first name");
	   String fn=br.readLine();
	   System.out.println("Enter customer last name");
	   String ln=br.readLine();
	  // System.out.println("Enter customer name");
	  sn=fn+ln;
	   System.out.println("Customer id");
	cd=Integer.parseInt(br.readLine());
	   System.out.println("Enter department id");
	   System.out.println(" . Department Codes: \n1 for Sales\n2 For Development\n3 For Accounting\n0 for none\nEnter the deparatment code ");
	 int depid=Integer.parseInt(br.readLine());
	 String deptname=getDepartment(depid);
	 String pass=randomPassword(defaultPasswordLength);
	String  email=fn.toLowerCase()+"."+ln.toLowerCase()+"@"+deptname + comapnySufix;
		System.out.println("Your Email is -> "+email);
		
	   
	   
		String sel="select * from emailrecord where id=?";
		
		pst=conn.prepareStatement(sel);
		pst.setInt(1, cd);
		rs=pst.executeQuery();
		
		
		//check record exists
		if(!rs.next()) {
			String ins="insert into emailrecord values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(ins);
			pst.setInt(1, cd);
			pst.setString(2, sn);
			pst.setInt(3,depid);
			pst.setString(4,deptname);
			pst.setString(5,pass);
			pst.setString(6,email);
			pst.setInt(7,mailboxCapacity);
			
			int i=pst.executeUpdate();
			if(i>0) {
				System.out.println("Record added successfully");
			}else
			{
				System.out.println("Record not added ");
			}
			
		}else {
			System.out.println("customer id "+cd +" exists");
		}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		finally {
			pst.close();
			rs.close();
			conn.close();
		}
		
	}
	 
	 //update record
	 void updateRecord(int id) throws IOException, SQLException {
		 try {
		 conn = EmailAppDataBaseUtilityClass.getConnection();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		  System.out.println("Enter the new name");
		  String name=br.readLine();
			String sel="select * from  emailrecord where id=?";
			pst=conn.prepareStatement(sel);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			//for update record record should exists
			if(rs.next()) {
				String upr="update emailrecord set CustomerName=? where id=?";
				pst=conn.prepareStatement(upr);
				pst.setString(1, name);
				pst.setInt(2, id);
				int i=pst.executeUpdate();
				if(i>0) {
					System.out.println("Record updated");
				}else {
					System.out.println("Not updated");
				}
				
				
			}else {
				System.out.println("Record not exists");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
				pst.close();
				rs.close();
				conn.close();
			}
			
		 
	 }
	 
	 void deleteRecord(int id) throws NumberFormatException, IOException, SQLException {
		 try {
		 conn = EmailAppDataBaseUtilityClass.getConnection();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
			
		  
		   
			String sel="select * from emailrecord where id=?";
			
			pst=conn.prepareStatement(sel);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			//for update record record should exists
			if(rs.next()) {
				String delr="delete from emailrecord where id=?";
				pst=conn.prepareStatement(delr);
				
				pst.setInt(1, id);
				int i=pst.executeUpdate();
				if(i>0) {
					System.out.println("Record deleted");
				}else {
					System.out.println("Not deleted");
				}
				
				
			}else {
				System.out.println("Record not exists");
			}
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		finally {
			pst.close();
			rs.close();
			conn.close();
		}
		 
	 }
	 
	 void displayAllRecord() throws SQLException {
		 try {
			 conn = EmailAppDataBaseUtilityClass.getConnection();
			 String sel="select * from emailrecord";
			 pst=conn.prepareStatement(sel);
			 
			 ResultSet rs=pst.executeQuery();
			 System.out.println("ID\tCUSTOMERNAME\tDEPARTMENTCODE\tDEPARTMENTNAME\tEMAILADDRESS\tMAILBOXCAPACITY");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+ "\t" +rs.getString(2)+ "\t" +rs.getInt(3)+ "\t" +rs.getString(4)+ "\t" +rs.getString(6)+"\t"+rs.getInt(7));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
				pst.close();
				if(rs!=null) {
				rs.close();
				}
				conn.close();
			}
			 
		}
	 
	 void displayParticlarRecord() throws SQLException {
		 try {
			 conn = EmailAppDataBaseUtilityClass.getConnection();
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			   System.out.println("Customer id");
			   cd=Integer.parseInt(br.readLine());
			 String sel="select * from emailrecord where id=?";
			 pst=conn.prepareStatement(sel);
			 pst.setInt(1, cd);
			 ResultSet rs=pst.executeQuery();
			 System.out.println("ID\tcustomerNAME");
			 if(rs.next()) {
				 System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
				pst.close();
				if(rs!=null) {
				rs.close();
				}
				conn.close();
			}
			 
		}
	 private static String getDepartment(int i) {
			
			
			if(i==1) {return "Sales";}
			else if(i==2) {return "Develoepment";}
			else if(i==3) {return "Account";}
			else { return " ";}
			}//setdepartment
	//Generate the random password
	 private static String randomPassword(int length) {
	 	String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&*";
	 	char[] password=new char[length];
	 	for(int i=0;i<length;i++) {
	 	int randValue	=(int) (Math.random() * passwordSet.length());
	 	password[i]=passwordSet.charAt(randValue);
	 	}
	 	return new String (password);
	 }//randomPAssowrdSet


}