package tss.action;

import java.util.Date;

import tss.model.Course;
import tss.service.AdminService;

public class AdminAddCourses extends BaseAction {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2708091952575783614L;
	
	public String execute(){
		String[] semesters={"2015 winter","2015 fall","2015 summber","2015 spring"};
		String courseid=request.getParameter("courseid");
		System.out.println(courseid);
		String courseName=request.getParameter("coursename");
		String description=request.getParameter("description");
		
		int s=Integer.valueOf(request.getParameter("semester"));
		
		
		String semester=semesters[s];
		String instructor=request.getParameter("instructor");
		Date date=new Date();

		Course c=new Course(courseid,courseName,description,semester,instructor,date);
		if(adminService.addCourse(c))
			return SUCCESS;
		else
			return ERROR;
	}

}
