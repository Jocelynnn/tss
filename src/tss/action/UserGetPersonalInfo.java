package tss.action;

import tss.model.User;
import tss.service.UserService;

public class UserGetPersonalInfo extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2933457995673258060L;
	private UserService userService;
	private String username;
	private String realName;
	private String email;
//	1 (male) 2 (female)
	private Integer gender;
	private Integer role;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

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
