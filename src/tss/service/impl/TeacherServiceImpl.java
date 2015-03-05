package tss.service.impl;

import java.util.ArrayList;
import java.util.Map;

import tss.dao.AssignmentDao;
import tss.dao.CourseDao;
import tss.dao.StudentDao;
import tss.dao.SubmissionDao;
import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;
import tss.model.User;
import tss.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private CourseDao courseDao;
	private StudentDao studentDao;
	private AssignmentDao assignmentDao;
	private SubmissionDao submissionDao;

	public SubmissionDao getSubmissionDao() {
		return submissionDao;
	}

	public void setSubmissionDao(SubmissionDao submissionDao) {
		this.submissionDao = submissionDao;
	}

	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

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

	@Override
	public Map<String,ArrayList<Assignment>> getCourseAssignments(String teacherId) {
		// TODO Auto-generated method stub
		
		return assignmentDao.getCourseAssignment(teacherId);
	}

	@Override
	public boolean addAssignment(Assignment a) {
		// TODO Auto-generated method stub
		return assignmentDao.save(a);
	}

	@Override
	public String getCourseName(String courseId) {
		// TODO Auto-generated method stub
		return courseDao.getCourseName(courseId);
	}

	@Override
	public ArrayList<Submission> getSubmissionList(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getAssignSubmissions(assignmentId);
	}

	@Override
	public Assignment getAssignment(int assignId) {
		// TODO Auto-generated method stub
		return assignmentDao.getAssignment(assignId);
	}
	
	@Override
	public ArrayList<Submission> getUnpassedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getUnpassedSubmission(assignmentId);
	}

	@Override
	public ArrayList<Submission> getPassedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getPassedSubmission(assignmentId);
	}

	@Override
	public ArrayList<Submission> getUngradedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getUngradedSubmission(assignmentId);
	}

	@Override
	public ArrayList<Submission> getGradedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getGradedSubmission(assignmentId);
	}

	@Override
	public ArrayList<Submission> getUnviewedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getUnviewedSubmission(assignmentId);
	}

	@Override
	public boolean passSubmission(int submissionId) {
		// TODO Auto-generated method stub
		return submissionDao.teacherPassSubmission(submissionId);
	}

	@Override
	public boolean unpassSubmission(int submissionId) {
		// TODO Auto-generated method stub
		return submissionDao.teacherUnpassSubmission(submissionId);
	}

}
