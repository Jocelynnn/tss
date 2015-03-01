package tss.action;

import java.util.ArrayList;

import tss.model.User;
import tss.service.AdminService;

public class AdminSearchUser extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4275125167211276105L;
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	ArrayList<User> users;
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String execute(){
		String searchkey=request.getParameter("searchkey");
		System.out.println(searchkey);
		users=adminService.searchUser(searchkey);
		System.out.println(users.size());
		
		return SUCCESS;
		
	}

}
