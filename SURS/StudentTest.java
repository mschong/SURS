package SURS;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class StudentTest {

	@Test
	public void test() {
		Transcript t = new Transcript();
		Student s = new Student("name",1,t);

		HashMap<Integer, Course> h = new HashMap<Integer, Course>();
		CourseList cl = new CourseList();
		cl.createRoster();
		s.addCourseList(cl);
		
		assertTrue(s.addClass(45879));
		assertFalse(s.addClass(12345));
		
		assertTrue(s.dropClass(45879));
		assertFalse(s.dropClass(12345));
		
		assertEquals(0, s.checkHolds());
		
		//assertSame(h,t.getCurrent());
		
		
		
	}

}
