package tss.dao;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;

public interface AssignmentDao {
	public boolean save(Assignment a);
	public Map<String,ArrayList<Assignment>> getCourseAssignment(String teacherId);
	public Assignment getAssignment(int assignId);
	
	public Map<String,ArrayList<Assignment>> getTACourseAssignment(String taId);
	public Assignment getOneAssignment(int assignmentId);
	public Map<String,ArrayList<Assignment>> getStudentAssignment(String studentId);
	
	public ArrayList<Assignment> getCourseAssign(int courseId);
	public ArrayList<Assignment> getAssignmentList();
}
