package tss.action;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.service.StudentService;

public class StudentGetAssignment extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5387400095494791759L;
	private Map<String,ArrayList<Assignment>> courseAssignments;
	private StudentService studentService;
	
	public Map<String,ArrayList<Assignment>> getCourseAssignments() {
		return courseAssignments;
	}

	public void setCourseAssignments(Map<String,ArrayList<Assignment>> courseAssignments) {
		this.courseAssignments = courseAssignments;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String execute(){
		courseAssignments = studentService.getStudentAssignment((String) request.getSession().getAttribute("username"));
		
		if (courseAssignments != null){
			return SUCCESS;
		}
		
		return ERROR;
	}
	
}
