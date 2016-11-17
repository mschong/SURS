package SURS;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
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
				Transcript t = new Transcript();
				Student newStudent = new Student(name, id, t);
				students.put(id, newStudent);
			}
			System.out.println("\nWelcome " + students.get(id).name + "!");
			Task3.NavMenu(students.get(id));

		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid ID.");
			Login();
		}

	}
	public static void NavMenu(Student student) {
		System.out.println("\nSelect an option: ");
		System.out.println("1) Transcript");
		System.out.println("2) Register");
		System.out.println("3) Logout");
		System.out.println("4) Exit Program");
		Scanner scr = new Scanner(System.in);
		int answer = scr.nextInt();
		switch (answer) {
		case 1:
			student.viewTrancript();
			break;
		case 2:
			student.Register();
			break;
		case 3:
			Login();
			break;
		case 4:
			System.out.println("\nGoodbye :)");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Login();
	}

}
