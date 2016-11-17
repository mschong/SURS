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
 * @version %I%
 *
 */

public class Student {
	String name;
	int id;
	Transcript t;
	HashSet<Hold> holds = new HashSet<Hold>();
	CourseList cl = new CourseList();
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	public Student(String name, int id, Transcript t) {
		super();
		this.name = name;
		this.id = id;
		this.t = t;
	}
	public Student(){
		
	}

	public void addCourseList(CourseList cl){
		this.cl = cl;
	}
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

	public int checkHolds() {
		System.out.println("\n  - HOLDS - ");
		if (holds.isEmpty())
			System.out.println("You have no holds.");
		for (Hold h : holds) {
			System.out.println(h.name);
		}
//		Task3.navMenu(this);
		return holds.size();
	}

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

	public boolean addClass(int crn) {
		if (!cl.roster.containsKey(crn)) {
			System.out.println("Class does not exist");
			return false;
		}
		t.current.put(crn, cl.roster.get(crn));
		return true;
	}

	public boolean dropClass(int crn) {
		if (!t.current.containsKey(crn)) {
			System.out.println("You are not registered for this class");
			return false;
		}
		t.current.remove(crn);
		return true;

	}

}
