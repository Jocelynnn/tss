package tss.action;

import java.util.ArrayList;

import tss.model.User;
import tss.service.AdminService;

public class AdminGetAllUser extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 95026042555979121L;
	private AdminService adminService;
	private ArrayList<User> users;
	
	
	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public String execute(){
		users=adminService.getAllUser();
		System.out.println("all users");
		if(!users.isEmpty())
			return SUCCESS;
		else
			return ERROR;
		
	}

}
