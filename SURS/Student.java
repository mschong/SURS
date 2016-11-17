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
			Register();
		else if (answer.equals("n"))
			Task3.NavMenu(this);

	}

	public void Register() {
		Scanner scr = new Scanner(System.in);
		System.out.println("\n - REGISTRATION - ");
		System.out.println("How many classes are you registering for?");
		int ans = scr.nextInt();
		System.out.println("\nCRN: 45879  Name: MATH 1411");
		System.out.println("CRN: 47894  Name: CS 1401");
		System.out.println("CRN: 14597  Name: CS 3331");
		System.out.println("CRN: 98453  Name: BIOL 1305");
		System.out.println("CRN: 78944  Name: BIOL 1105");
		do {

			System.out.println("Select class (Enter crn)");
			int crn = scr.nextInt();
			if (crn == 45879) {
				Courses newC = new Courses(crn, "MATH 1411");
				t.current.add(newC);
			}
			if (crn == 47894) {
				Courses newC = new Courses(crn, "CS 1401");
				t.current.add(newC);
			}
			if (crn == 14597) {
				Courses newC = new Courses(crn, "CS 3331");
				t.current.add(newC);
			}
			if (crn == 98453) {
				Courses newC = new Courses(crn, "BIOL 1305");
				t.current.add(newC);
			}
			if (crn == 78944) {
				Courses newC = new Courses(crn, "BIOL 1105");
				t.current.add(newC);
			}

			ans--;
		} while (ans != 0);
		System.out.println();
		viewTrancript();
	}
	

	

}
