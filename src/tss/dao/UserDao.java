package tss.dao;

import java.util.ArrayList;

import tss.model.Message;
import tss.model.User;


public interface UserDao {
	
//	查询个人信息
	public User getPersonalInfo(String username);
//	验证登录
	public int validate(String username, String password);
//	注册用户
	public boolean register(String username, String password, String realName);
//	更新个人信息
	public boolean updatePersonalInfo(User user);

	public ArrayList<User> getAllUser();
	
	public ArrayList<Message> getUserMessage(String userId); 



}
