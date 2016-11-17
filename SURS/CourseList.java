package SURS;

import java.util.HashMap;

public class CourseList {
	HashMap<Integer, Course> roster = new HashMap<Integer, Course>();
	
	public CourseList() {
	}
	
	public void createRoster(){
		roster.put(45879, new Course(45879, "MATH 1411"));
		roster.put(47894, new Course(47894, "CS 1401"));
		roster.put(14597, new Course(14597, "CS 3331"));
		roster.put(98453, new Course(98453, "BIOL 1305"));
		roster.put(78944, new Course(78944, "BIOL 1105"));
	}
	
	public HashMap<Integer, Course> getRoster() {
		return roster;
	}

	public void setRoster(HashMap<Integer, Course> roster) {
		this.roster = roster;
	}

	
	
	public void print(){
		createRoster();
		System.out.println();
		for (Course c : roster.values()) {
			c.printCourses();
		}
	}
}