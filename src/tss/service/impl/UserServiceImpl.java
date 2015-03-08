package tss.service.impl;

import java.util.ArrayList;

import tss.dao.UserDao;
import tss.model.Message;
import tss.model.User;
import tss.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;


	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserInfo(String username) {
		// TODO Auto-generated method stub
		return userDao.getPersonalInfo(username);
	}

	@Override
	public int validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.validate(username, password);
	}

	@Override
	public boolean register(String username, String password,String realName) {
		// TODO Auto-generated method stub
		return userDao.register(username, password, realName);
	}

	@Override
	public boolean updatePersonalInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.updatePersonalInfo(user);
	}

	@Override
	public ArrayList<Message> getUserMessage(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserMessage(userId);
	}

	@Override
	public int getUnreadMessageCount(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUnreadMessageCount(userId);
	}

}
