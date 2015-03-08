package tss.action;

import java.util.ArrayList;
import java.util.Iterator;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherGetTA extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4759590243583783792L;

	private TeacherService teacherService;
	ArrayList<User> studentList;
	

	ArrayList<User> taList;
	String courseId;
	String courseName;
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	int taCount;

	public ArrayList<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<User> studentList) {
		this.studentList = studentList;
	}
	public int getTaCount() {
		return taCount;
	}

	public void setTaCount(int taCount) {
		this.taCount = taCount;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public ArrayList<User> getTaList() {
		return taList;
	}

	public void setTaList(ArrayList<User> taList) {
		this.taList = taList;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String execute(){
		
		courseId=request.getParameter("courseId");
		courseName=request.getParameter("courseName");

		studentList=teacherService.getAllTas();
		taList=teacherService.getCourseTA(courseId);
		taCount=taList.size();
		
		request.getSession().setAttribute("courseId", courseId);
		request.getSession().setAttribute("courseName", courseName);
		
//		remove the overlapping part in two lists
		Iterator<User> iter1 = studentList.iterator();
		while (iter1.hasNext()) {
			User current = iter1.next();
			String studentId1 = current.getUsername();
			Iterator<User> iter2 = taList.iterator();
			while (iter2.hasNext()) {
				String studentId2 = iter2.next().getUsername();
				if (studentId1.equals(studentId2)){
					studentList.remove(current);
					iter1=studentList.iterator();

				}
			}
		}
		return SUCCESS;

	}
}
