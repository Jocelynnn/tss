package tss.action;

import java.util.ArrayList;
import java.util.Iterator;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherAddStudent extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1496151298902665243L;
	private TeacherService teacherService;
	ArrayList<User> studentList;
	ArrayList<User> selectedStudentList;
	



	String courseId;
	String courseName;
	String studentId;
	int studentCount;
	
	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public ArrayList<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<User> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<User> getSelectedStudentList() {
		return selectedStudentList;
	}

	public void setSelectedStudentList(ArrayList<User> selectedStudentList) {
		this.selectedStudentList = selectedStudentList;
	}
	
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	
	
	public String execute(){
		studentId=request.getParameter("studentId");
		
		courseId = (String) request.getSession().getAttribute("courseId");
		courseName = (String) request.getSession().getAttribute("courseName");
		selectedStudentList = teacherService.getStudent(courseId);

		System.out.println("add student"+courseId);
		System.out.println("add student"+courseName);
		
//		重复提交表单？？
		for(User user:selectedStudentList){
			if(user.getUsername().equals(studentId))
				return SUCCESS;
		}
		
		if(teacherService.addCourseStudent(courseId, studentId)){
			selectedStudentList = teacherService.getStudent(courseId);
			studentList = teacherService.getAllStudent();

			studentCount = selectedStudentList.size();


//			remove the overlapping part in two lists
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
			System.out.println("now not selected student "+studentList.size());
			System.out.println("!!!");
			
			
			return SUCCESS;
		}
		else
			return ERROR;
		
	}

}
