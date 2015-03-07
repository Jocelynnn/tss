package tss.action;

import tss.model.User;
import tss.service.UserService;

public class UserGetPersonalInfo extends BaseAction {
	
	private UserService userService;
	private String username;
	private String realName;
	private String email;
//	1 (male) 2 (female)
	private Integer gender;
	private Integer role;
	
	public String execute(){
		username=(String) request.getSession().getAttribute("username");
		role=(Integer) request.getSession().getAttribute("role");
		
		User user=userService.getUserInfo(username);
		realName=user.getRealName();
		email=user.getEmail();
		gender=user.getGender();
		return SUCCESS;
				
		
		
	}

}
