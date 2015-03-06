package tss.action;

import tss.service.TeachingManagerService;

public class TeacherAssignCheckAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4705287999615677235L;

	private TeachingManagerService teachingManagerService;

	public String execute() {
		try{
			// 课程数量
			int courseCount = teachingManagerService.getCourseList().size();
			request.setAttribute("courseCount", courseCount);
			// 作业数量
			int assignCount = teachingManagerService.getAssignmentList().size();
			request.setAttribute("assignCount", assignCount);
			
			return SUCCESS;
		}
		catch (Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}

	public TeachingManagerService getTeachingManagerService() {
		return teachingManagerService;
	}

	public void setTeachingManagerService(
			TeachingManagerService teachingManagerService) {
		this.teachingManagerService = teachingManagerService;
	}
}
