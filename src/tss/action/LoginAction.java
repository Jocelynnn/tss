package tss.action;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Course;
import tss.model.Message;
import tss.service.TaService;
import tss.service.TeacherService;
import tss.service.UserService;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 5183139033860751029L;

	private UserService userService;
	private TeacherService teacherService;
	private TaService taService;
	ArrayList<Course> teacherCourses;
	Map<String, ArrayList<Assignment>> allAssigns;
	private String userName;
	private ArrayList<Message> messageList;
	private int messageCount;
	

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public ArrayList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<Message> messageList) {
		this.messageList = messageList;
	}

	

	public Map<String, ArrayList<Assignment>> getAllAssigns() {
		return allAssigns;
	}

	public void setAllAssigns(Map<String, ArrayList<Assignment>> allAssigns) {
		this.allAssigns = allAssigns;
	}

	public TaService getTaService() {
		return taService;
	}

	public void setTaService(TaService taService) {
		this.taService = taService;
	}

	public ArrayList<Course> getTeacherCourses() {
		return teacherCourses;
	}

	public void setTeacherCourses(ArrayList<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	private ArrayList<Course> courseList;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String execute() {

//		System.out.println(userService == null);
		this.userName = request.getParameter("username");
		messageList=userService.getUserMessage(userName);
		messageCount=0;
		System.out.println(messageList.size());
		for(Message m:messageList){
//			if 未读消息
			if(m.getFlag()==1){
				messageCount++;
			}
		}
		System.out.println("未读消息数量"+messageCount);
		request.getSession().setAttribute("messageCount", messageCount);
		switch (userService.validateLogin(request.getParameter("username"),
				request.getParameter("password"))) {
		// 无该用户
		case 0:
			System.out.println("error!");
			return "error";

			// 管理员
		case 1:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			request.getSession().setAttribute("role",new Integer(1));
			return "admin";

			// 授课教师
		case 2:
			teacherCourses = teacherService.getTeacherCourses(request
					.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			request.getSession().setAttribute("role", new Integer(2));

			return "teacher";

			// 选课学生
		case 3:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			request.getSession().setAttribute("role", new Integer(3));

			return "student";

			// 助教
		case 4:
			allAssigns = taService.getCourseAssignments(request
					.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			request.getSession().setAttribute("role",new Integer(4));

			return "teachingAssistant";

			// 教学负责人
		case 5:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			request.getSession().setAttribute("role",new Integer(5));
			return "teachingManager";

			// 3&4
		case 6:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "student_ta";
			// 2&5
		case 7:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "teacher_manager";

			// 其他
		default:
			return "error";
		}

	}

}
