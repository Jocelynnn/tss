package tss.action;

import java.util.ArrayList;

import tss.model.Assignment;
import tss.model.Submission;
import tss.service.TeacherService;

public class TeacherGetAssignInfo extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5875780621512792364L;
	private TeacherService teacherService;
	private int assignId;
	private int assignNumber;

	private Assignment assignment;
	private String courseName;
	private ArrayList<Submission> submissionList;
	
	
	


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



	public TeacherService getTeacherService() {
		return teacherService;
	}



	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}



	public int getAssignId() {
		return assignId;
	}



	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}



	public String execute(){
		assignId=Integer.valueOf(request.getParameter("assignId"));
		assignment=teacherService.getAssignment(assignId);
		
		courseName=assignment.getCourseName();
		assignNumber=assignment.getNumber();
		submissionList=teacherService.getSubmissionList(assignId);
		
		
		return SUCCESS;
	}
}
