package tss.service.impl;

import java.util.ArrayList;

import tss.dao.AssignmentDao;
import tss.dao.CourseDao;
import tss.dao.SubmissionDao;
import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;
import tss.service.TeachingManagerService;

public class TeachingManagerServiceImpl implements TeachingManagerService{
	private CourseDao courseDao;
	private AssignmentDao assignmentDao;
	private SubmissionDao submissionDao;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}
	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}
	public SubmissionDao getSubmissionDao() {
		return submissionDao;
	}
	public void setSubmissionDao(SubmissionDao submissionDao) {
		this.submissionDao = submissionDao;
	}
	
	@Override
	public ArrayList<Course> getCourseList() {
		return courseDao.getCourseList();
	}

	@Override
	public ArrayList<Assignment> getCourseAssign(int courseId) {
		return assignmentDao.getCourseAssign(courseId);
	}

	@Override
	public ArrayList<Submission> getSubmissionList() {
		return submissionDao.getSubmissionList();
	}

	@Override
	public ArrayList<Assignment> getAssignmentList() {
		return assignmentDao.getAssignmentList();
	}

}
