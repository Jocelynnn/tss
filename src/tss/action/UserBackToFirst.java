package tss.action;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Course;
import tss.service.TaService;
import tss.service.TeacherService;
import tss.service.UserService;

public class UserBackToFirst extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127731732638922046L;
	private int role;
	private UserService userService;
	ArrayList<Course> teacherCourses;
	private TeacherService teacherService;
	private TaService taService;
	Map<String, ArrayList<Assignment>> allAssigns;
	private String username;
	private int messageCount;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
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
		role = (int) request.getSession().getAttribute("role");
		username = (String) request.getSession().getAttribute("username");
		System.out.println(role + "!!!");

		messageCount = userService.getUnreadMessageCount(username);
		System.out.println("未读消息数量" + messageCount);
		request.getSession().setAttribute("messageCount", messageCount);
		switch (role) {
		case 1:
			return "admin";
			// 授课教师
		case 2:
			teacherCourses = teacherService.getTeacherCourses(username);
			// System.out.println(teacherCourses.size());
			return "teacher";

			// 选课学生
		case 3:

			return "student";

			// 助教
		case 4:
			allAssigns = taService.getCourseAssignments(username);

			return "teachingAssistant";

			// 教学负责人
		case 5:
			return "teachingManager";
		default:
			return "error";

		}

	}

}
