package tss.service.impl;

import java.util.ArrayList;

import tss.dao.CourseDao;
import tss.dao.StudentDao;
import tss.model.Course;
import tss.model.User;
import tss.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private CourseDao courseDao;
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public ArrayList<Course> getTeacherCourses(String teacherName) {
		// TODO Auto-generated method stub
		return courseDao.getTeacherCourses(teacherName);
	}

	@Override
	public ArrayList<User> getStudent(String courseId) {
		// TODO Auto-generated method stub
		return courseDao.getCourseStudent(courseId);
	}

	@Override
	public ArrayList<User> searchStudent(String searchkey) {
		// TODO Auto-generated method stub
		return studentDao.searchStudent(searchkey);
	}

	@Override
	public ArrayList<User> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

	@Override
	public ArrayList<User> getCourseTA(String courseId) {
		// TODO Auto-generated method stub
		return studentDao.getCourseTA(courseId);
	}

	@Override
	public boolean addCourseStudent(String courseId, String studentId) {
		// TODO Auto-generated method stub
		return courseDao.addCourseStudent(courseId, studentId);
	}

	@Override
	public boolean addCourseTA(String courseId, String taId) {
		// TODO Auto-generated method stub
		return courseDao.addCourseTA(courseId, taId);
	}

	@Override
	public boolean removeCourseStudent(String courseId, String studentId) {
		// TODO Auto-generated method stub
		return courseDao.removeCourseStudent(courseId, studentId);
	}

	@Override
	public boolean removeCourseTA(String courseId, String taId) {
		// TODO Auto-generated method stub
		return courseDao.removeCourseTA(courseId, taId);
	}

}