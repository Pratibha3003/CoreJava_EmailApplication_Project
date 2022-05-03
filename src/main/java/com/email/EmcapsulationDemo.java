package com.email;

class Student
{
	 private int sid;
	private String sname;
	 
	 
	public Student() {
		super();
		System.out.println("Defualt Constructor");
	}
	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
		System.out.println("Paramete..constructor");
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void display()
	{
		System.out.println("Student id "+sid+"Student Name "+sname);
	}
}
public class EmcapsulationDemo 
{

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Student ob=new Student(103,"Pratu");
		ob.setSid(101);
		ob.setSname("Pratibha");
		System.out.println(ob.getSid());
		System.out.println(ob.getSname());
		//ob.Stude(103,"Pratu");

	}

}
