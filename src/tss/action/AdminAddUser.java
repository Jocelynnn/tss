package tss.action;

import java.io.UnsupportedEncodingException;

import tss.model.User;
import tss.service.AdminService;


public class AdminAddUser extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6951887869817224663L;
	private AdminService adminService;
	private String role;
	private String gender;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String execute() throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String realName=request.getParameter("realName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int gender=Integer.valueOf(request.getParameter("gender"));
		int role=Integer.valueOf(request.getParameter("role"));
		
			
		System.out.println(gender);
		System.out.println(role);
		System.out.println(username);
		System.out.println(realName);
		System.out.println(password);
		System.out.println(email);

		User user=new User(username, password, realName, email, gender, role);
		user.setUsername(username);
		user.setRealName(realName);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setGender(gender);
		
		
		if(adminService.addUser(user)){
			return "success";
		}
		
		return "error";
	}

}
