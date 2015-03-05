package tss.action;

import tss.service.TeacherService;

public class TeacherUnpassSubmission extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8632459714569778103L;
	/**
	 * 
	 */
	private TeacherService teacherService;
	private int submissionId;
	private String assignId;

	

	public String getAssignId() {
		return assignId;
	}

	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public int getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}

	public String execute() {
		assignId=request.getParameter("assignId");
		submissionId = Integer.valueOf(request.getParameter("submissionId"));
		if (teacherService.unpassSubmission(submissionId))
			return SUCCESS;
		else
			return ERROR;
	}
}
