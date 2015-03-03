package tss.action;

import java.util.ArrayList;

import tss.model.Course;
import tss.service.StudentService;

public class StudentSearchCourse extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1865219901757440957L;
	
	private ArrayList<Course> courseList;
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	private StudentService studentService;
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String execute() {
		courseList = (ArrayList<Course>) studentService.getStuStudiedCourses((String) request.getSession().getAttribute("username"));

		if (courseList != null){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
