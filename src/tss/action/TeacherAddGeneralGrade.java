package tss.action;

import tss.model.Assignment;
import tss.service.TeacherService;

public class TeacherAddGeneralGrade extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3681914361689322472L;
	private TeacherService teacherService;
	private int assignId;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String execute() {
		// save to database
		assignId=Integer.valueOf(request
				.getParameter("assignmentId"));
		Assignment a = teacherService.getAssignment(assignId);
		a.setGeneralGrade(request.getParameter("generalGrade"));
		if(teacherService.updateAssignment(a)){
			return SUCCESS;
		}
		else
			return ERROR;

	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

}
