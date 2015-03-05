package tss.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tss.dao.AssignmentDao;
import tss.dao.StudentDao;
import tss.dao.SubmissionDao;
import tss.dao.UserDao;
import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;
import tss.model.User;
import tss.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	private AssignmentDao assignmentDao;
	private SubmissionDao submissionDao;
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public SubmissionDao getSubmissionDao() {
		return submissionDao;
	}
	public void setSubmissionDao(SubmissionDao submissionDao) {
		this.submissionDao = submissionDao;
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}
	
	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}
	
	@Override
	public List<Course> getStuStudiedCourses(String studentName) {
		return studentDao.getStuStudiedCourses(studentName);
	}
	
	@Override
	public Map<String,ArrayList<Assignment>> getStudentAssignment(String studentName) {
		return assignmentDao.getStudentAssignment(studentName);
	}
	
	@Override
	public Submission getSingleSubmission(String studentId, int assignmentId) {
		return studentDao.getSingleSubmission(studentId, assignmentId);
	}
	@Override
	public Assignment getOneAssignment(int assignmentId) {
		return assignmentDao.getOneAssignment(assignmentId);
	}
	@Override
	public boolean saveSubmission(Submission submission) {
		return submissionDao.saveSubmission(submission);
	}
	@Override
	public boolean updateSubmission(Submission submission) {
		return submissionDao.updateSubmission(submission);
	}
	@Override
	public String getUserRealname(String userId) {
		User user = userDao.getPersonalInfo(userId);
		if (user != null){
			return user.getRealName();
		}
		else{
			return null;
		}
	}
	
	
}
