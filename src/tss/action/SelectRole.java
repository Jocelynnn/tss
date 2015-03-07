package tss.action;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Course;
import tss.service.TaService;
import tss.service.TeacherService;

public class SelectRole extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127731732638922046L;
	private String role;
	ArrayList<Course> teacherCourses;
	private TeacherService teacherService;
	private TaService taService;
	Map<String, ArrayList<Assignment>> allAssigns;
	private String username;

	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ArrayList<Course> getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(ArrayList<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	public TaService getTaService() {
		return taService;
	}


	public void setTaService(TaService taService) {
		this.taService = taService;
	}


	public Map<String, ArrayList<Assignment>> getAllAssigns() {
		return allAssigns;
	}


	public void setAllAssigns(Map<String, ArrayList<Assignment>> allAssigns) {
		this.allAssigns = allAssigns;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String execute() {
		role = request.getParameter("role");
		username=(String) request.getSession().getAttribute("username");
		switch (role) {
		case "1":
			return "admin";
		// 授课教师
		case "2":
			teacherCourses = teacherService.getTeacherCourses(username);
//			System.out.println(teacherCourses.size());
			return "teacher";

			// 选课学生
		case "3":
			
			return "student";

			// 助教
		case "4":
			allAssigns = taService.getCourseAssignments(username);

			return "teachingAssistant";

			// 教学负责人
		case "5":
			return "teachingManager";
		default:
			return "error";

		}

	}

}
