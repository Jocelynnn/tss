package tss.dao;

import java.util.ArrayList;

import tss.model.Submission;

public interface SubmissionDao {
	public ArrayList<Submission> getAssignSubmissions(int assignmentId);

}
