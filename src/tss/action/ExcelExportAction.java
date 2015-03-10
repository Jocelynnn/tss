package tss.action;

import java.util.ArrayList;

import tss.model.Course;
import tss.service.ExcelService;

public class ExcelExportAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9071896276033683301L;
	
	private ExcelService excelService;
	private ArrayList<Course> courseList;
	private int isNull;
	
	public String execute(){
		courseList = excelService.getCourseList();
		
		if (courseList == null){
			setIsNull(1);
		}
		else{
			setIsNull(0);
		}
		
		return SUCCESS;
	}

	public ExcelService getExcelService() {
		return excelService;
	}

	public void setExcelService(ExcelService excelService) {
		this.excelService = excelService;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public int getIsNull() {
		return isNull;
	}

	public void setIsNull(int isNull) {
		this.isNull = isNull;
	}
	
	
}
