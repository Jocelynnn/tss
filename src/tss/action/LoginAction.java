package tss.action;

import tss.service.UserService;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5183139033860751029L;

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		System.out.println(userService == null);
		switch (userService.validateLogin(request.getParameter("userusername"),
				request.getParameter("password"))) {
		// 无该用户
		case 0:
			return "error";

			// 管理员
		case 1:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "admin";

			// 授课教师
		case 2:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "teacher";

			// 选课学生
		case 3:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "student";

			// 助教
		case 4:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
			return "teachingAssistant";

			// 教学负责人
		case 5:
			request.setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("username",
					request.getParameter("username"));
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
