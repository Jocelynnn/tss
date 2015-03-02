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

}
