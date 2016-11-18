package SURS;

import java.util.HashSet;

/**
 * Class Course contains methods related to course usage in the project. This
 * class also contains setters to initiate objects of type Course.
 * 
 * @author Marina Chong, Jessica Dozal
 * @version 2.0
 * 
 */
public class Course {
	int crn;
	String name;
	boolean pass;
	HashSet<Course> prereq = new HashSet<Course>();

	/**
	 * Course constructor, handles initiation of a new object of type Course
	 * when CRN and name is provided.
	 * 
	 * @param crn
	 *            CRN of course.
	 * @param name
	 *            Name of course.
	 */
	public Course(int crn, String name) {
		super();
		this.crn = crn;
		this.name = name;
	}

	/**
	 * Course constructor, handles initiation of a new object of type Course
	 * when Name and pass/fail status is provided.
	 * 
	 * @param name
	 *            Name of course.
	 * @param pass
	 *            Variable to determine if course was passed or failed.
	 */
	public Course(String name, boolean pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	/**
	 * Method to print courses from past semesters.
	 */
	public void printPastCourses() {
		if (pass == false)
			System.out.println("Name: " + name + " ||  FAILED");
		else
			System.out.println("Name: " + name + " ||  PASSED");
	}

	/**
	 * Method to print a course.
	 */
	public void printCourses() {
		System.out.println("CRN: " + crn + " Name: " + name);
	}
}
