package tss.action;

import java.util.Date;

import tss.model.Course;
import tss.service.AdminService;

public class AdminModifyCourse extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3178298872510007539L;
	private AdminService adminService;
	public String courseId;
	public String courseName;
	public String description;
	public String semester;
	public String teacherName;
	public Date initializationDeadline;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getInitializationDeadline() {
		return initializationDeadline;
	}

	public void setInitializationDeadline(Date initializationDeadline) {
		this.initializationDeadline = initializationDeadline;
	}

	public String execute() {
		Course c = new Course(courseId, courseName, description, semester, teacherName,
				initializationDeadline, new Integer(0));
		if (adminService.updateCourse(c)) {
			return SUCCESS;
		} 
		else{
			return ERROR;

		}

	}

}
