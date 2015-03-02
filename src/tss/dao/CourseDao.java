package tss.dao;

import java.util.ArrayList;

import tss.model.Course;

public interface CourseDao {
	public boolean addCourse(Course course);
	public ArrayList<Course> getCourses(String searchKey); 

}
