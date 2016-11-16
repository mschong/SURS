package SURS;

import java.util.HashSet;
import java.util.Scanner;

public class Transcript {
	HashSet<Courses> current = new HashSet<Courses>();
	HashSet<Courses> pastCourses = new HashSet<Courses>();
	

	public Transcript() {
	}


	public void createTranscript(){
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
	}
}
