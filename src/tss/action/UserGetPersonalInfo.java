package tss.action;

import java.util.ArrayList;

import tss.model.Message;
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
	// 1 (male) 2 (female)
	private Integer gender;
	private Integer role;
	private ArrayList<Message> messageList;
	private int messageCount;

	public ArrayList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<Message> messageList) {
		this.messageList = messageList;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

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

	public String execute() {
		username = (String) request.getSession().getAttribute("username");
		role = (Integer) request.getSession().getAttribute("role");

		messageList = userService.getUserMessage(username);
		messageCount = 0;
		System.out.println(messageList.size());
		for (Message m : messageList) {
			// if 未读消息
			if (m.getFlag() == 1) {
				messageCount++;
			}
		}
		System.out.println("未读消息数量" + messageCount);
		request.getSession().setAttribute("messageCount", messageCount);
		
		User user = userService.getUserInfo(username);
		realName = user.getRealName();
		email = user.getEmail();
		gender = user.getGender();
		return SUCCESS;

	}

}
