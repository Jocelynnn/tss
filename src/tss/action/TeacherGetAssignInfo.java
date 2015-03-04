package tss.action;

import tss.service.TeacherService;

public class TeacherGetAssignInfo extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5875780621512792364L;
	private TeacherService teacherService;
	private int assignId;
	
	
	
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
		
		return SUCCESS;
	}
}
