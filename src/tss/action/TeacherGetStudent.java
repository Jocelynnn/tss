package tss.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherGetStudent extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8643299795417540697L;
	private TeacherService teacherService;
	
	ArrayList<User> studentList;
	String courseId;
	int studentCount;
	
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	String courseName;
	public ArrayList<User> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<User> studentList) {
		this.studentList = studentList;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	public String execute() throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		courseId=request.getParameter("courseId");
		courseName=request.getParameter("courseName");
		System.out.println(courseId);
		System.out.println(courseName);

		studentList=teacherService.getStudent(request.getParameter("courseId"));
		studentCount=studentList.size();
		return SUCCESS;
	}

}
