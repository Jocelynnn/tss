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

	public String execute() {
		submissionId = Integer.valueOf(request.getParameter("submissionId"));
		teacherService.passSubmission(submissionId);
		return null;
	}
}
