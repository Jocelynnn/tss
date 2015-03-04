package tss.dao;

import java.util.ArrayList;

import tss.model.Course;
import tss.model.User;

public interface CourseDao {
	public boolean addCourse(Course course);
	public ArrayList<Course> getCourses(String searchKey); 
	public ArrayList<Course> getTeacherCourses(String teacherName);
	public ArrayList<User> getCourseStudent(String courseId);
	
	public boolean addCourseStudent(String courseId,String studentId);
	public boolean addCourseTA(String courseId,String taId);
	public boolean removeCourseStudent(String courseId,String studentId);
	public boolean removeCourseTA(String courseId,String taId);
	
	public String getCourseName(String courseId);


}
