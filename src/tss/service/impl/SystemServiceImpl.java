package tss.service.impl;

import java.util.ArrayList;

import tss.dao.SystemDao;
import tss.model.Course;
import tss.service.SystemService;

public class SystemServiceImpl implements SystemService {
	private SystemDao systemDao;
	
	@Override
	public String getTeacherName(String courseId) {
		return systemDao.getTeacherName(courseId);
	}

	@Override
	public ArrayList<String> getTaNameList(String courseId) {
		return systemDao.getTaNameList(courseId);
	}

	@Override
	public ArrayList<String> getStudentName(String courseId) {
		return systemDao.getStudentName(courseId);
	}

	@Override
	public int getStudentAverageGrade(String studentId) {
		return systemDao.getStudentAverageGrade(studentId);
	}

	@Override
	public Course getCourseInfo(String courseId) {
		return systemDao.getCourseInfo(courseId);
	}
	
	public SystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}
}
