package tss.service;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Submission;

public interface TaService {
	public Map<String, ArrayList<Assignment>> getCourseAssignments(String taId);

	public Assignment getAssignment(int assignId);

	public ArrayList<Submission> getSubmissionList(int assignmentId);

	public ArrayList<Submission> getUnpassedSubmission(int assignmentId);

	public ArrayList<Submission> getPassedSubmission(int assignmentId);

	public ArrayList<Submission> getUngradedSubmission(int assignmentId);

	public ArrayList<Submission> getGradedSubmission(int assignmentId);
	public boolean submitGrade(String taId,int submissionId,int grade,String evaluation);


}
