package tss.action;

import java.util.Date;

import tss.service.TeacherService;

public class TeacherAddAssignment extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859912898643349352L;
	private TeacherService teacherService;
	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	private String courseName;
	
	public String execute(){
		
		 String courseId=request.getParameter("courseId");
		 String courseName=request.getParameter("courseName");
		 int number=Integer.valueOf(request.getParameter("number"));
		 String description=request.getParameter("description");;
		 String format=request.getParameter("format");
		 Date submissionDeadline;
		 Date gradeDeadline;
		 int score=Integer.valueOf(request.getParameter("score"));
		 String level=request.getParameter("level");;
		 String sample=request.getParameter("sample");;
		 String generalGrade=request.getParameter("generalGrade");;
		return null;
	}

}
