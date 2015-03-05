package tss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;

public interface StudentService {
	public List<Course> getStuStudiedCourses (String studentName);
	public Map<String,ArrayList<Assignment>> getStudentAssignment (String studentName);
	public Submission getSingleSubmission (String studentName, int assignmentId);
	
	public Assignment getOneAssignment(int assignmentId);
	public boolean saveOrUpdateSubmission(Submission submission);
}
