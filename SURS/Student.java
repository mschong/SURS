package SURS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	Transcript t;
	HashSet<Hold> holds = new HashSet<Hold>();
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	public Student(String name, int id, Transcript t) {
		super();
		this.name = name;
		this.id = id;
		this.t = t;
	}

	public void viewTranscript() {
		Scanner scr = new Scanner(System.in);
		
		System.out.println("\nPast Courses: ");
		for (Courses c : t.pastCourses) {
			c.printPastCourses();
		}

		System.out.println("\nSchedule Fall 2016: ");
		if (t.current.isEmpty())
			System.out.println("You are not enrolled in any classes.");
		else {
			for (Courses c : t.current.values()) {
				c.printCourses();

			}
		}

		System.out.println("\nGo to registration? (y/n)");
		String answer = scr.next();
		if (answer.equals("y"))
			addClass();
		else if (answer.equals("n"))
			Task3.NavMenu(this);

	}

	public void checkHolds() {
		System.out.println("\n  - HOLDS - ");
		if (holds.isEmpty())
			System.out.println("You have no holds.");
		for (Hold h : holds) {
			System.out.println(h.name);
		}
		Task3.NavMenu(this);
	}

	public void addClass() {
		if (!holds.isEmpty()) {
			System.out.println("You have " + holds.size() + " hold(s). You cannot register at the moment");
			Task3.NavMenu(this);
		} else {
			CourseList cl = new CourseList();
			Scanner scr = new Scanner(System.in);
			System.out.println("\n - REGISTRATION - ");
			System.out.println("How many classes are you registering for?");
			int ans = scr.nextInt();
			while (ans != 0) {
				cl.print();
				System.out.println("\nSelect class (Enter crn)");
				int crn = scr.nextInt();
				t.current.put(crn, cl.roster.get(crn));
				ans--;
			}
			System.out.println();
			viewTranscript();
		}

	}

	public void dropClass() {
		Scanner scr = new Scanner(System.in);
		System.out.println("How many classes will you be dropping?");
		int ans = scr.nextInt();
		do {
			System.out.println("Enter the crn");
			int crn = scr.nextInt();
			t.current.remove(crn);

			ans--;
		} while (ans != 0);
		System.out.println();
		viewTranscript();
	}

}
