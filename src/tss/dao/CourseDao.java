package tss.dao;

import java.util.ArrayList;

import tss.model.Course;
import tss.model.User;

public interface CourseDao {
	public boolean addCourse(Course course);
	public ArrayList<Course> getCourses(String searchKey); 
	public ArrayList<Course> getTeacherCourses(String teacherName);
	public ArrayList<User> getCourseStudent(String courseId);

}
