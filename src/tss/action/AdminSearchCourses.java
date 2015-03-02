package tss.action;

import java.util.ArrayList;

import tss.model.Course;
import tss.service.AdminService;

public class AdminSearchCourses extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5249484460697773433L;
	private AdminService adminService;
	ArrayList<Course> courses;

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
		String searchkey=request.getParameter("searchkey");
		System.out.println(searchkey);
		courses=adminService.searchCourse(searchkey);
		System.out.println(courses.size());
		
		return SUCCESS;
		
	}

}
