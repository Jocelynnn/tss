package tss.action;

import tss.service.TeachingManagerService;

public class CourseAssignCheckAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4019797266111841616L;
	private TeachingManagerService teachingManagerService;

	public TeachingManagerService getTeachingManagerService() {
		return teachingManagerService;
	}

	public void setTeachingManagerService(TeachingManagerService teachingManagerService) {
		this.teachingManagerService = teachingManagerService;
	}
	
	public String execute(){
		// 课程数量
		int courseCount = teachingManagerService.getCourseList().size();
		request.setAttribute("courseCount", courseCount);
		// 作业数量
		int assignCount = teachingManagerService.getAssignmentList().size();
		request.setAttribute("assignCount", assignCount);
		
		// 不及格分数数量
		
		// 及格分数数量
		
		return SUCCESS;
	}
}
