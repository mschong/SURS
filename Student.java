package SURS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	HashSet<Courses> current = new HashSet<Courses>();
	HashSet<Courses> pastCourses = new HashSet<Courses>();
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public static void Login() {
		System.out.println("Welcome to SURS!\n");
		try {
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter ID number: ");
			int id = scr.nextInt();
			int length = (int) (Math.log10(id) + 1);
			if (length != 8) {
				System.out.println("Invalid ID.");
				Login();
			}
			boolean exists = students.containsKey(id);
			if (!exists) {
				System.out.println("New student");
				System.out.println("Enter your name:");
				String name = scr.next();
				Student newStudent = new Student(name, id);
				students.put(id, newStudent);
			}
			System.out.println("\nWelcome " + students.get(id).name + "!");
			Task3.NavMenu(students.get(id));

		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid ID.");
			Login();
		}

	}

	public void Trancript() {
		Scanner scr = new Scanner(System.in);
		boolean pass = false;
		System.out.println(" - TRANSCRIPT -");
		if (pastCourses.isEmpty()) {
			System.out.println("Have you taken any courses before? (y/n)");
			String ans = scr.next();
			if (ans.equals("y")) {
				System.out.println("How many classes?");
				int ans2 = scr.nextInt();
				do {
					System.out.println("\nClass " + ans2);
					System.out.println("Enter name");
					String name = scr.next();
					System.out.println("Passed? (y/n)");
					String grade = scr.next();
					if (grade.equals("y"))
						pass = true;
					if (grade.equals("n"))
						pass = false;
					Courses newCourse = new Courses(name, pass);
					pastCourses.add(newCourse);
					ans2--;
				} while (ans2 != 0);

			}

		}
		System.out.println("\nPast Courses: ");
		for (Courses c : pastCourses) {
			c.print();
		}

		System.out.println("\nSchedule Fall 2016: ");
		if (current.isEmpty())
			System.out.println("You are not enrolled in any classes.");
		else {
			for (Courses c : current) {
				c.print2();
			}

		}
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
				current.add(newC);
			}
			if (crn == 47894) {
				Courses newC = new Courses(crn, "CS 1401");
				current.add(newC);
			}
			if (crn == 14597) {
				Courses newC = new Courses(crn, "CS 3331");
				current.add(newC);
			}
			if (crn == 98453) {
				Courses newC = new Courses(crn, "BIOL 1305");
				current.add(newC);
			}
			if (crn == 78944) {
				Courses newC = new Courses(crn, "BIOL 1105");
				current.add(newC);
			}

			ans--;
		} while (ans != 0);
		System.out.println();
		Trancript();
	}
	

	public static void main(String[] args) {
		Login();
	}

}
