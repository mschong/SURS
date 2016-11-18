package SURS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class Transcript handles the initiation of new objects of type Transcript.
 * This class also contains setters and getters of Transcript.
 * 
 * @author Marina Chong, Jessica Dozal
 * @version 2.0
 */
public class Transcript {
	HashMap<Integer, Course> current = new HashMap<Integer, Course>();
	HashSet<Course> pastCourses = new HashSet<Course>();

	/**
	 * Transcript getter.
	 * 
	 * @return current courses of current transcript.
	 */
	public HashMap<Integer, Course> getCurrent() {
		return current;
	}

	/**
	 * Transcript setter, transcript must be an object of type HashMap to be
	 * set.
	 * 
	 * @param current
	 *            current courses of current transcript to be set.
	 */
	public void setCurrent(HashMap<Integer, Course> current) {
		this.current = current;
	}

	/**
	 * Transcript getter.
	 * 
	 * @return past courses of current transcript.
	 */
	public HashSet<Course> getPastCourses() {
		return pastCourses;
	}

	/**
	 * Transcript setter, transcript must be an object of type HashSet to be
	 * set.
	 * 
	 * @param pastCourses
	 *            past courses of current transcript to be set.
	 */
	public void setPastCourses(HashSet<Course> pastCourses) {
		this.pastCourses = pastCourses;
	}

	public Transcript() {
	}

	/**
	 * Method createTranscript adds current and past courses to be added to
	 * current transcript.
	 * 
	 * @see #pastCourses
	 */
	public void createTranscript() {
		Scanner scr = new Scanner(System.in);
		boolean pass = false;
		System.out.println("\n - TRANSCRIPT -");
		if (pastCourses.isEmpty()) {
			System.out.println("Have you taken any courses before? (y/n)");
			String ans = scr.next();
			if (ans.equals("y")) {
				System.out.println("How many classes?");
				int ans2 = scr.nextInt();
				while (ans2 != 0) {
					System.out.println("\nClass " + ans2);
					scr = new Scanner(System.in);
					System.out.println("Enter name");
					String name = scr.nextLine();
					System.out.println("Passed? (y/n)");
					String grade = scr.next();
					if (grade.equals("y"))
						pass = true;
					if (grade.equals("n"))
						pass = false;
					Course newCourse = new Course(name, pass);
					pastCourses.add(newCourse);
					ans2--;
				}
			}

		}

	}

}
