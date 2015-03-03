package tss.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherSearchStudent extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1903238551523527831L;
	private TeacherService teacherService;
	ArrayList<User> studentList;
	ArrayList<User> selectedStudentList;
	String courseName;
	String courseId;
	int studentCount;


	public ArrayList<User> getSelectedStudentList() {
		return selectedStudentList;
	}

	public void setSelectedStudentList(ArrayList<User> selectedStudentList) {
		this.selectedStudentList = selectedStudentList;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	

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

	public String execute() throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		

		courseId = (String) request.getSession().getAttribute("courseId");
		courseName = (String) request.getSession().getAttribute("courseName");
		System.out.println(courseId);
		System.out.println(courseName);
		selectedStudentList = teacherService.getStudent(courseId);
		studentList = teacherService.searchStudent(request
				.getParameter("searchkey"));

		studentCount = selectedStudentList.size();


//		remove the overlapping part in two lists
		Iterator<User> iter1 = studentList.iterator();
		while (iter1.hasNext()) {
			User current = iter1.next();
			String studentId1 = current.getUsername();
			Iterator<User> iter2 = selectedStudentList.iterator();
			while (iter2.hasNext()) {
				String studentId2 = iter2.next().getUsername();
				if (studentId1.equals(studentId2)){
					studentList.remove(current);
					iter1=studentList.iterator();

				}
			}
		}
		System.out.println(studentList.size());
		System.out.println("!!!");
		return SUCCESS;

	}
}
