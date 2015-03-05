package tss.action;

import tss.service.TeacherService;

public class TeacherPassSubmission extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3836472989787905533L;
	private TeacherService teacherService;
	private int submissionId;
	
	public String execute(){
		submissionId=Integer.valueOf(request.getParameter("submissionId"));
		teacherService.passSubmission(submissionId);
		return null;
	}

}
