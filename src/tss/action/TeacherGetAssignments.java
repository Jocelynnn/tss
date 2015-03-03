package tss.action;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;
import tss.service.TeacherService;

public class TeacherGetAssignments extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8448079434315731210L;
	private TeacherService teacherService;
	Map<String,ArrayList<Assignment>> allAssigns;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Map<String, ArrayList<Assignment>> getAllAssigns() {
		return allAssigns;
	}

	public void setAllAssigns(Map<String, ArrayList<Assignment>> allAssigns) {
		this.allAssigns = allAssigns;
	}

	
	public String execute(){
		
		String teacherId=(String) request.getSession().getAttribute("username");
		allAssigns=teacherService.getCourseAssignments(teacherId);
		
		System.out.println(allAssigns.size());

		for (String key : allAssigns.keySet()) {
			System.out.println(key);
		    ArrayList<Assignment> value= allAssigns.get(key);
			System.out.println(value.size());
		    for(Assignment a:value){
		    	System.out.println("assignments!!"+key+"   " + a.getDescription());
		    }

		}
		
		if(allAssigns!=null)
			return SUCCESS;
		else
			return ERROR;
		
	}

}
