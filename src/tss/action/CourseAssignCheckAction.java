package tss.action;

import java.util.ArrayList;

import tss.model.Data;
import tss.model.Submission;
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
		
		// 统计不同分数段百分比
		Data[] gradeData = new Data[2];
		
		Data fLevel = new Data();
		fLevel.setData(0);
		Data aLevel = new Data();
		aLevel.setData(0);
		
		ArrayList<Submission> submissionList = teachingManagerService.getSubmissionList();
		for (Submission submission : submissionList){
			if (submission.getGrade() < 60){
				fLevel.setData(fLevel.getData() + 1);
			}
			else{
				aLevel.setData(aLevel.getData() + 1);
			}
		}
		
		double amount = fLevel.getData() + aLevel.getData();
		fLevel.setData(fLevel.getData() / amount);
		aLevel.setData(aLevel.getData() / amount);
		fLevel.setName("不及格百分比");
		aLevel.setName("及格百分比");
		
		gradeData[0] = fLevel;
		gradeData[1] = aLevel;
		
		request.setAttribute("gradeData", gradeData);
		
		return SUCCESS;
	}
}
