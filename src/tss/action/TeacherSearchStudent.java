package tss.action;

import java.util.ArrayList;

import tss.model.User;
import tss.service.TeacherService;

public class TeacherSearchStudent extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1903238551523527831L;
	private TeacherService teacherService;
	ArrayList<User> studentList;
	
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

	public String execute(){
		
		 studentList=teacherService.searchStudent(request.getParameter("searchkey"));
		 System.out.println(studentList.size());
		 System.out.println("!!!");
		 return SUCCESS;
		
	}

}
