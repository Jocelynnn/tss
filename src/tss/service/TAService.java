package tss.service;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.model.Submission;

public interface TaService {
	public 	Map<String,ArrayList<Assignment>> getCourseAssignments(String taId);
	public Assignment getAssignment(int assignId);
	public ArrayList<Submission> getSubmissionList(int assignmentId);



}
