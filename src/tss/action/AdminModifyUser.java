package tss.action;

import tss.service.AdminService;

public class AdminModifyUser extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3194159169667188675L;
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String execute(){
		return null;
	}
	

}
