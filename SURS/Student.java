package SURS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	Transcript t;
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	public Student(String name, int id, Transcript t) {
		super();
		this.name = name;
		this.id = id;
		this.t = t;
	}

	public void viewTrancript() {
		Scanner scr = new Scanner(System.in);
		t.createTranscript();

		System.out.println("\nGo to registration? (y/n)");
		String answer = scr.next();
		if (answer.equals("y"))
			addClass();
		else if (answer.equals("n"))
			Task3.NavMenu(this);

	}

	public void addClass() {
		CourseList cl = new CourseList();
		Scanner scr = new Scanner(System.in);
		System.out.println("\n - REGISTRATION - ");
		System.out.println("How many classes are you registering for?");
		int ans = scr.nextInt();
			while(ans != 0) {
				cl.print();
				System.out.println("\nSelect class (Enter crn)");
				int crn = scr.nextInt();
				t.current.put(crn, cl.roster.get(crn));
				ans--;
			} 
			System.out.println();
			viewTrancript();
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
		viewTrancript();
	}

}
