package tss.dao;

import java.util.ArrayList;

import tss.model.Submission;

public interface SubmissionDao {
	public ArrayList<Submission> getAssignSubmissions(int assignmentId);
	
	public ArrayList<Submission> getUnpassedSubmission(int assignmentId);
	public ArrayList<Submission> getPassedSubmission(int assignmentId);
	public ArrayList<Submission> getUngradedSubmission(int assignmentId);
	public ArrayList<Submission> getGradedSubmission(int assignmentId);
	public ArrayList<Submission> getUnviewedSubmission(int assignmentId);

	public boolean saveSubmission(Submission submission);
	public boolean updateSubmission(Submission submission);
	
	public boolean teacherPassSubmission(int submissionId);
	public boolean teacherUnpassSubmission(int submissionId);

}
