package tss.service.impl;

import java.util.ArrayList;
import java.util.Map;

import tss.dao.AssignmentDao;
import tss.dao.SubmissionDao;
import tss.model.Assignment;
import tss.model.Submission;
import tss.service.TaService;

public class TaServiceImpl implements TaService {
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

	@Override
	public Map<String, ArrayList<Assignment>> getCourseAssignments(String taId) {
		// TODO Auto-generated method stub
		return assignmentDao.getTACourseAssignment(taId);
	}

	@Override
	public Assignment getAssignment(int assignId) {
		// TODO Auto-generated method stub
		return assignmentDao.getAssignment(assignId);
	}

	@Override
	public ArrayList<Submission> getSubmissionList(int assignmentId) {
		// TODO Auto-generated method stub
		return submissionDao.getAssignSubmissions(assignmentId);
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
	public boolean submitGrade(String taId,int submissionId, int grade, String evaluation) {
		// TODO Auto-generated method stub
		return submissionDao.taSubmitGrade(taId,submissionId, grade, evaluation);
	}
}
