package tss.action;

import java.util.ArrayList;

import tss.model.Assignment;
import tss.model.Submission;
import tss.service.TaService;

public class TAGetAssignSubmission extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4097031246377392923L;
	private TaService taService;
	private int assignId;
	private int assignNumber;
	private Assignment assignment;
	private String courseName;
	private ArrayList<Submission> passedSubmissionList;
	private ArrayList<Submission> unpassedSubmissionList;
	private ArrayList<Submission> ungradedSubmissionList;
	private ArrayList<Submission> gradedSubmissionList;
	private ArrayList<Submission> unviewedSubmissionList;

	public ArrayList<Submission> getPassedSubmissionList() {
		return passedSubmissionList;
	}

	public void setPassedSubmissionList(ArrayList<Submission> passedSubmissionList) {
		this.passedSubmissionList = passedSubmissionList;
	}

	public ArrayList<Submission> getUnpassedSubmissionList() {
		return unpassedSubmissionList;
	}

	public void setUnpassedSubmissionList(
			ArrayList<Submission> unpassedSubmissionList) {
		this.unpassedSubmissionList = unpassedSubmissionList;
	}

	public ArrayList<Submission> getUngradedSubmissionList() {
		return ungradedSubmissionList;
	}

	public void setUngradedSubmissionList(
			ArrayList<Submission> ungradedSubmissionList) {
		this.ungradedSubmissionList = ungradedSubmissionList;
	}

	public ArrayList<Submission> getGradedSubmissionList() {
		return gradedSubmissionList;
	}

	public void setGradedSubmissionList(ArrayList<Submission> gradedSubmissionList) {
		this.gradedSubmissionList = gradedSubmissionList;
	}

	public TaService getTaService() {
		return taService;
	}

	public void setTaService(TaService taService) {
		this.taService = taService;
	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	public int getAssignNumber() {
		return assignNumber;
	}

	public void setAssignNumber(int assignNumber) {
		this.assignNumber = assignNumber;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	

	public String execute() {
		assignId = Integer.valueOf(request.getParameter("assignId"));
		assignment = taService.getAssignment(assignId);

		courseName = assignment.getCourseName();
		assignNumber = assignment.getNumber();
		
		passedSubmissionList = taService.getPassedSubmission(assignId);
		unpassedSubmissionList=taService.getUnpassedSubmission(assignId);
		gradedSubmissionList=taService.getGradedSubmission(assignId);
		ungradedSubmissionList=taService.getUngradedSubmission(assignId);
		unviewedSubmissionList=taService.getUnviewedSubmission(assignId);

		return SUCCESS;

	}

	public ArrayList<Submission> getUnviewedSubmissionList() {
		return unviewedSubmissionList;
	}

	public void setUnviewedSubmissionList(ArrayList<Submission> unviewedSubmissionList) {
		this.unviewedSubmissionList = unviewedSubmissionList;
	}

}
