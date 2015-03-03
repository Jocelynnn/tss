package tss.service;

import java.util.ArrayList;

import tss.model.Course;
import tss.model.User;

public interface TeacherService {
	public ArrayList<Course> getTeacherCourses(String teacherName);
	public ArrayList<User> getStudent(String courseId);
	public ArrayList<User> searchStudent(String searchkey);
	public ArrayList<User> getAllStudent();
	public ArrayList<User> getCourseTA(String courseId);
	
	public boolean addCourseStudent(String courseId,String studentId);
	public boolean addCourseTA(String courseId,String taId);
	public boolean removeCourseStudent(String courseId,String studentId);
	public boolean removeCourseTA(String courseId,String taId);
}
