package SURS;

import java.util.HashMap;

/**
 * Class CourseList contains course roster information and methods to handle
 * course roster from current semester.
 * 
 * @author Marina Chong, Jessica Dozal
 * @version 2.0
 *
 */
public class CourseList {
	HashMap<Integer, Course> roster = new HashMap<Integer, Course>();

	public CourseList() {
	}

	/**
	 * Method createRoster contains information of current course roster.
	 */
	public void createRoster() {
		roster.put(45879, new Course(45879, "MATH 1411"));
		roster.put(47894, new Course(47894, "CS 1401"));
		roster.put(14597, new Course(14597, "CS 3331"));
		roster.put(98453, new Course(98453, "BIOL 1305"));
		roster.put(78944, new Course(78944, "BIOL 1105"));
	}

	/**
	 * Roster getter.
	 * 
	 * @return roster of current semester.
	 */
	public HashMap<Integer, Course> getRoster() {
		return roster;
	}

	/**
	 * Roster setter. Roster must be an object of type HashMap to be set.
	 * 
	 * @param roster
	 *            new HashMap containing course roster.
	 */
	public void setRoster(HashMap<Integer, Course> roster) {
		this.roster = roster;
	}

	/**
	 * Method to print current course roster.
	 */
	public void print() {
		createRoster();
		System.out.println();
		for (Course c : roster.values()) {
			c.printCourses();
		}
	}
}