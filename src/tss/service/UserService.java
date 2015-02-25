package tss.service;

import tss.model.User;


public interface UserService {
	public User getUserInfo(String username);
	public int validateLogin(String username, String password);
	public boolean register(String username, String password,String realName);
	public boolean updatePersonalInfo(User User, String password);
}
