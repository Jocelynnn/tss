package tss.service;

import java.util.ArrayList;

import tss.model.Message;
import tss.model.User;

public interface UserService {
	public User getUserInfo(String username);

	public int validateLogin(String username, String password);

	public boolean register(String username, String password, String realName);

	public boolean updatePersonalInfo(User user);

	public ArrayList<Message> getUserMessage(String userId);
	public int getUnreadMessageCount(String userId);

}
