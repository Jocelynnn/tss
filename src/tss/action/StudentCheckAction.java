package tss.action;

import java.util.ArrayList;

import tss.model.Data;
import tss.model.Submission;
import tss.service.TeachingManagerService;

public class StudentCheckAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4507385315286877029L;

	private TeachingManagerService teachingManagerService;
	
	public String execute(){
		try {
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
		catch (Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}

	public TeachingManagerService getTeachingManagerService() {
		return teachingManagerService;
	}

	public void setTeachingManagerService(TeachingManagerService teachingManagerService) {
		this.teachingManagerService = teachingManagerService;
	}
}
