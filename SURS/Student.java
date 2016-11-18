package SURS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Student class implements methods viewTrascript, addClass, and dropClass.
 * These methods are related to the actions that the student can execute in the
 * system. Student class also contains the constructor to initiate a new Student
 * object.
 * 
 * @author Marina Chong, Jessica Dozal
 * @version 2.0
 *
 */

public class Student {
	String name;
	int id;
	Transcript t;
	HashSet<Hold> holds = new HashSet<Hold>();
	CourseList cl = new CourseList();
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	/**
	 * Student constructor, handles initiation of a new object of type Student
	 * when Name, ID and transcript of student is provided.
	 * 
	 * @param name
	 *            Name of student.
	 * @param id
	 *            ID of student.
	 * @param t
	 *            Transcript of student.
	 */
	public Student(String name, int id, Transcript t) {
		super();
		this.name = name;
		this.id = id;
		this.t = t;
	}

	public Student() {

	}

	/**
	 * Method to include course roster in student profile.
	 * 
	 * @param cl
	 *            course roster.
	 * @see SURS.CourseList#createRoster()
	 */
	public void addCourseList(CourseList cl) {
		this.cl = cl;
	}

	/**
	 * Method viewTrascript prints transcript of student. Prints past courses
	 * and schedule of current semester.
	 */
	public void viewTranscript() {
		Scanner scr = new Scanner(System.in);

		System.out.println("\nPast Courses: ");
		for (Course c : t.pastCourses) {
			c.printPastCourses();
		}

		System.out.println("\nSchedule Fall 2016: ");
		if (t.current.isEmpty())
			System.out.println("You are not enrolled in any classes.");
		else {
			for (Course c : t.current.values()) {
				c.printCourses();

			}
		}

		System.out.println("\nGo to registration? (y/n)");
		String answer = scr.next();
		if (answer.equals("y"))
			register();
		else if (answer.equals("n"))
			Task3.navMenu(this);

	}

	/**
	 * Method checkHolds checks if the student has any holds.
	 * 
	 * @return number of holds.
	 */
	public int checkHolds() {
		System.out.println("\n  - HOLDS - ");
		if (holds.isEmpty())
			System.out.println("You have no holds.");
		for (Hold h : holds) {
			System.out.println(h.name);
		}
		// Task3.navMenu(this);
		return holds.size();
	}

	/**
	 * Method register asks student how many classes are going to be added and
	 * adds courses to transcript when CRN is provided.
	 * 
	 * @see #addClass(int)
	 */
	public void register() {
		if (!holds.isEmpty()) {
			System.out.println("You have " + holds.size() + " hold(s). You cannot register at the moment");
			Task3.navMenu(this);
		} else {

			Scanner scr = new Scanner(System.in);
			System.out.println("\n - REGISTRATION - ");
			System.out.println("How many classes are you registering for?");
			int ans = scr.nextInt();
			cl.print();
			while (ans != 0) {
				System.out.println("\nSelect class (Enter crn)");
				int crn = scr.nextInt();
				if (addClass(crn))
					ans--;
			}
			System.out.println();
			viewTranscript();
		}
	}

	/**
	 * Method drop lets the student drop courses. This method handles the
	 * deletion of courses from transcript.
	 */
	public void drop() {
		Scanner scr = new Scanner(System.in);
		System.out.println("How many classes will you be dropping?");
		int ans = scr.nextInt();
		while (ans != 0) {
			System.out.println("Enter crn");
			int crn = scr.nextInt();
			if (dropClass(crn))
				ans--;
		}
		System.out.println();
		viewTranscript();
	}

	/**
	 * Method addClass handles the addition of new classes to transcript. Checks
	 * if course exists.
	 * 
	 * @param crn
	 *            CRN of course to be added.
	 * @return true if course was successfully added, false otherwise.
	 */
	public boolean addClass(int crn) {
		if (!cl.roster.containsKey(crn)) {
			System.out.println("Class does not exist");
			return false;
		}
		t.current.put(crn, cl.roster.get(crn));
		return true;
	}

	/**
	 * Method dropClass handles the deletion of courses from transcript.
	 * 
	 * @param crn
	 *            CRN of course to be dropped.
	 * @return true if course was successfully dropped, false otherwise.
	 */
	public boolean dropClass(int crn) {
		if (!t.current.containsKey(crn)) {
			System.out.println("You are not registered for this class");
			return false;
		}
		t.current.remove(crn);
		return true;

	}

}
