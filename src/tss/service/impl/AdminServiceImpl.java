package tss.service.impl;

import java.util.ArrayList;

import tss.dao.AdminDao;
import tss.dao.CourseDao;
import tss.model.Course;
import tss.model.User;
import tss.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return adminDao.addUser(user);
	}
	

	@Override
	public ArrayList<User> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllTeachingAssistant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllTeachingManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeacher(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleStudent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeacherAssistant(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeachingManager(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTeacher(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeachingAssistan(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeachingManager(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> searchUser(String searchKey) {
		// TODO Auto-generated method stub
		return adminDao.searchUser(searchKey);
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		
		return courseDao.addCourse(course);
	}
	@Override
	public ArrayList<Course> searchCourse(String searchKey) {
		// TODO Auto-generated method stub
		return courseDao.getCourses(searchKey);
	}


	

}
