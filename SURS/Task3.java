package SURS;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Task 3 contains methods to initiate project interface.
 * 
 * @author Marina Chong, Jessica Dozal
 * @version 2.0
 */
public class Task3 {
	static HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	/**
	 * Method login starts project logic, asks student for id number and checks
	 * if the user already exists in the registration system. If student is a
	 * new user asks for name and creates new transcript.
	 * 
	 * @see SURS.Student#Student(String, int, Transcript)
	 */
	public static void login() {
		System.out.println("Welcome to SURS!\n");
		try {
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter ID number: ");
			int id = scr.nextInt();
			int length = (int) (Math.log10(id) + 1);
			if (length != 8) {
				System.out.println("Invalid ID.");
				login();
			}
			boolean exists = students.containsKey(id);
			if (!exists) {
				System.out.println("\nNew student");
				System.out.println("Enter your name:");
				String name = scr.next();
				Transcript t = new Transcript();
				Student newStudent = new Student(name, id, t);
				newStudent.t.createTranscript();
				newStudent.holds.add(new Hold("Advising Required"));
				newStudent.holds.add(new Hold("Balance Due"));
				students.put(id, newStudent);
			} else {
				students.get(id).holds.clear();
			}
			System.out.println("\nWelcome " + students.get(id).name + "!");
			Task3.navMenu(students.get(id));

		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid ID.");
			login();
		}

	}

	/**
	 * Method navMeno handles logic of navigation menu.
	 * 
	 * @param student
	 *            current student that is using the registration system.
	 */
	public static void navMenu(Student student) {
		System.out.println("\nSelect an option: ");
		System.out.println("1) Transcript");
		System.out.println("2) Check Holds");
		System.out.println("3) Add Classes");
		System.out.println("4) Drop Classes");
		System.out.println("5) Logout");
		System.out.println("6) Exit Program");
		Scanner scr = new Scanner(System.in);
		int answer = scr.nextInt();
		switch (answer) {
		case 1:
			student.viewTranscript();
			break;
		case 2:
			student.checkHolds();
			break;
		case 3:
			student.register();
			break;
		case 4:
			student.drop();
			break;
		case 5:
			login();
			break;
		case 6:
			System.out.println("\nGoodbye :)");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		login();
	}

}
