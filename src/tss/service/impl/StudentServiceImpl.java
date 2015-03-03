package tss.service.impl;

import java.util.List;

import tss.dao.StudentDao;
import tss.model.Course;
import tss.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public List<Course> getStuStudiedCourses(String studentName) {
		return studentDao.getStuStudiedCourses(studentName);
	}

}
