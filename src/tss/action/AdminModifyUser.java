package tss.action;

import tss.model.User;
import tss.service.AdminService;

public class AdminModifyUser extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3194159169667188675L;
	private AdminService adminService;
	private String username;
	private String password;
	private String realName;
	private String email;
	private int gender;
	private int role;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String execute() {
		User user = new User(username, password, realName, email, gender, role);
		if (adminService.updateUser(user))
			return SUCCESS;
		else
			return ERROR;
	}

}
