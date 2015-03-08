package tss.dao;

import java.util.ArrayList;
import java.util.List;

import tss.model.Course;
import tss.model.Submission;
import tss.model.User;

public interface StudentDao {
	public ArrayList<User> searchStudent(String searchkey);
	
	public ArrayList<User> getAllStudent();
	public ArrayList<User> getAllTas();
	public ArrayList<User> getCourseTA(String courseId);
	public User getStudent(String studentId);
	
	public List<Course> getStuStudiedCourses(String studentName);
	public Submission getSingleSubmission(String studentId, int assignmentId);
	
}
