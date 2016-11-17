package SURS;

import java.util.HashMap;

public class CourseList {
	HashMap<Integer, Courses> roster = new HashMap<Integer, Courses>();
	
	public CourseList() {
	}
	
	public void createRoster(){
		roster.put(45879, new Courses(45879, "MATH 1411"));
		roster.put(47894, new Courses(47894, "CS 1401"));
		roster.put(14597, new Courses(14597, "CS 3331"));
		roster.put(98453, new Courses(98453, "BIOL 1305"));
		roster.put(78944, new Courses(78944, "BIOL 1105"));
	}
	
	public HashMap<Integer, Courses> getRoster() {
		return roster;
	}

	public void setRoster(HashMap<Integer, Courses> roster) {
		this.roster = roster;
	}

	
	
	public void print(){
		createRoster();
		System.out.println();
		for (Courses c : roster.values()) {
			c.printCourses();
		}
	}
}