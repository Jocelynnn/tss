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
	private ArrayList<Submission> submissionList;

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

	public ArrayList<Submission> getSubmissionList() {
		return submissionList;
	}

	public void setSubmissionList(ArrayList<Submission> submissionList) {
		this.submissionList = submissionList;
	}

	public String execute() {
		assignId = Integer.valueOf(request.getParameter("assignId"));
		assignment = taService.getAssignment(assignId);

		courseName = assignment.getCourseName();
		assignNumber = assignment.getNumber();
		submissionList = taService.getSubmissionList(assignId);

		return SUCCESS;

	}

}
