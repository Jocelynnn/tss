package tss.service;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;
import tss.model.User;

public interface TeacherService {
	public ArrayList<Course> getTeacherCourses(String teacherName);

	public ArrayList<User> getStudent(String courseId);

	public ArrayList<User> searchStudent(String searchkey);

	public ArrayList<User> getAllStudent();
	public ArrayList<User> getAllTas();


	public ArrayList<User> getCourseTA(String courseId);

	public ArrayList<Submission> getSubmissionList(int assignmentId);

	public ArrayList<Submission> getUnpassedSubmission(int assignmentId);

	public ArrayList<Submission> getPassedSubmission(int assignmentId);

	public ArrayList<Submission> getUngradedSubmission(int assignmentId);

	public ArrayList<Submission> getGradedSubmission(int assignmentId);
	public ArrayList<Submission> getUnviewedSubmission(int assignmentId);


	public Map<String, ArrayList<Assignment>> getCourseAssignments(
			String teacherId);

	public boolean addCourseStudent(String courseId, String studentId);

	public boolean addCourseTA(String courseId, String taId);

	public boolean addAssignment(Assignment assignment);

	public boolean removeCourseStudent(String courseId, String studentId);

	public boolean removeCourseTA(String courseId, String taId);

	public String getCourseName(String courseId);

	public Assignment getAssignment(int assignId);
	
	
	public boolean passSubmission(int submissionId);
	public boolean unpassSubmission(int submissionId);
	
	
	public boolean updateAssignment(Assignment a);
}
