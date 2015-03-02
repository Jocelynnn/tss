package tss.service;

import java.util.ArrayList;

import tss.model.Course;
import tss.model.User;

public interface TeacherService {
	public ArrayList<Course> getTeacherCourses(String teacherName);
	public ArrayList<User> getStudent(String courseId);
	public ArrayList<User> searchStudent(String searchkey);

}
