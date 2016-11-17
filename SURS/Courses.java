package SURS;

import java.util.HashSet;

public class
Courses {
	int crn;
	String name;
	boolean pass;
	

	public Courses(int crn, String name) {
		super();
		this.crn = crn;
		this.name = name;
	}

	public Courses(String name, boolean pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public void printPastCourses(){
		if(pass == false)
			System.out.println("Name: " + name + " ||  FAILED");
		else
			System.out.println("Name: " + name + " ||  PASSED");
	}
	
	public void printCourses(){
			System.out.println("CRN: " + crn + " Name: " + name);
	}
}
