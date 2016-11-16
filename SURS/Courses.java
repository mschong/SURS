//This is a change
package SURS;

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

	public void print(){
		if(pass == false)
			System.out.println("Name: " + name + " ||  FAILED");
		else
			System.out.println("Name: " + name + " ||  PASSED");
	}
	
	public void print2(){
			System.out.println("CRN: " + crn + " Name: " + name);
	}
}
