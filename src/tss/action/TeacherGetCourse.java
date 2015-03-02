package tss.action;

import java.util.ArrayList;

import tss.model.Course;
import tss.service.TeacherService;

public class TeacherGetCourse extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2669411992839227189L;
	private TeacherService teacherService;
	ArrayList<Course> teacherCourses;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public ArrayList<Course> getTeacherCourses() {
		return teacherCourses;
	}

	public void setTeacherCourses(ArrayList<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	public String execute() {
		String teacherId=(String) request.getSession().getAttribute("username");
		teacherCourses = teacherService.getTeacherCourses(teacherId);
		System.out.println("teacher get course");
		System.out.println(teacherCourses.size());
		return SUCCESS;
	}
}
