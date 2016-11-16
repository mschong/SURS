package SURS;

import java.util.Scanner;

public class Task3 {
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
			Student.Login();
			break;
		case 4:
			System.out.println("\nGoodbye :)");
			System.exit(0);
		}
	}

}
