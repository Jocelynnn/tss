package tss.dao;

import java.util.ArrayList;

import tss.model.User;

public interface AdminDao {
	public boolean addUser(User user);
	public ArrayList<User> searchUser(String searchkey);
	
	
	public ArrayList<User> getAllTeacher();
	public ArrayList<User> getAllStudent();
	public ArrayList<User> getAllTeachingAssistant();
	public ArrayList<User> getAllTeachingManager();
	
	public User getSingleTeacher(String username);
	public User getSingleStudent(String username);
	public User getSingleTeacherAssistant(String username);
	public User getSingleTeachingManager(String username);
	
	public boolean updateTeacher(User user, String password);
	public boolean updateStudent(User user, String password);
	public boolean updateTeachingAssistan(User user, String password);
	public boolean updateTeachingManager(User user, String password);

}
