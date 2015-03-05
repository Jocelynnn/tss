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

	private String teacherId;
	private Assignment assignment;
	private String courseName;
	private String courseId;
	private ArrayList<Submission> submissionList;

	private ArrayList<Submission> unviewedSubmissionList;
	private ArrayList<Submission> passedSubmissionList;
	private ArrayList<Submission> unpassedSubmissionList;
	private ArrayList<Submission> ungradedSubmissionList;
	private ArrayList<Submission> gradedSubmissionList;

	public ArrayList<Submission> getUnviewedSubmissionList() {
		return unviewedSubmissionList;
	}

	public void setUnviewedSubmissionList(
			ArrayList<Submission> unviewedSubmissionList) {
		this.unviewedSubmissionList = unviewedSubmissionList;
	}

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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
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

	public String execute() {
		teacherId = (String) request.getSession().getAttribute("username");
		assignId = Integer.valueOf(request.getParameter("assignId"));
		assignment = teacherService.getAssignment(assignId);

		unviewedSubmissionList=teacherService.getUnviewedSubmission(assignId);
		passedSubmissionList = teacherService.getPassedSubmission(assignId);
		unpassedSubmissionList=teacherService.getUnpassedSubmission(assignId);
		gradedSubmissionList=teacherService.getGradedSubmission(assignId);
		ungradedSubmissionList=teacherService.getUngradedSubmission(assignId);
		
		courseId = assignment.getCourseId();
		courseName = assignment.getCourseName();
		assignNumber = assignment.getNumber();
		submissionList = teacherService.getSubmissionList(assignId);

		return SUCCESS;
	}
}
