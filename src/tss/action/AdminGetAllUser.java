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


	public ArrayList<User> getUserList() {
		return users;
	}


	public void setUserList(ArrayList<User> userList) {
		this.users = userList;
	}


	public String execute(){
		users=adminService.getAllUser();
		if(!users.isEmpty())
			return SUCCESS;
		else
			return ERROR;
		
	}

}
