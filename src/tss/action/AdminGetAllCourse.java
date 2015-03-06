package tss.action;

import java.util.ArrayList;

import tss.model.Course;
import tss.service.AdminService;

public class AdminGetAllCourse extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6994586534976348356L;
	private AdminService adminService;
	
	ArrayList<Course> courses;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String execute() {
		courses=adminService.getAllCourse();
		if(!courses.isEmpty())
			return SUCCESS;
		else
			return ERROR;

	}

}
