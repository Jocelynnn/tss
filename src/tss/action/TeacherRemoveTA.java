package tss.action;

import java.util.ArrayList;
import java.util.Iterator;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherRemoveTA extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3056795286081660391L;
	private TeacherService teacherService;
	String courseId;
	String taId;
	String courseName;
	int taCount;

	ArrayList<User> studentList;
	ArrayList<User> taList;
	
	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTaId() {
		return taId;
	}

	public void setTaId(String taId) {
		this.taId = taId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTaCount() {
		return taCount;
	}

	public void setTaCount(int taCount) {
		this.taCount = taCount;
	}

	public ArrayList<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<User> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<User> getTaList() {
		return taList;
	}

	public void setTaList(ArrayList<User> taList) {
		this.taList = taList;
	}

	public String execute(){
		taId = request.getParameter("taId");

		courseId = (String) request.getSession().getAttribute("courseId");
		courseName = (String) request.getSession().getAttribute("courseName");

		System.out.println(courseId);
		System.out.println(courseName);
		taList = teacherService.getCourseTA(courseId);

		for(User user:taList){
			if(user.getUsername().equals(taId)){
				if(teacherService.removeCourseTA(courseId, taId)){
					studentList = teacherService.getAllStudent();
					taList = teacherService.getCourseTA(courseId);

					taCount = taList.size();

					// remove the overlapping part in two lists
					Iterator<User> iter1 = studentList.iterator();
					while (iter1.hasNext()) {
						User current = iter1.next();
						String studentId1 = current.getUsername();
						Iterator<User> iter2 = taList.iterator();
						while (iter2.hasNext()) {
							String studentId2 = iter2.next().getUsername();
							if (studentId1.equals(studentId2)) {
								studentList.remove(current);
								iter1 = studentList.iterator();

							}
						}
					}
					return SUCCESS;

					
				}
				else
					return ERROR;
				
			}
		}

//		重复提交
			return SUCCESS;
		
	}

}
