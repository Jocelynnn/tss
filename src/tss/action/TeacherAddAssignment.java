package tss.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tss.model.Assignment;
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

	public String execute() throws ParseException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String courseId = request.getParameter("courseId");
		String courseName = teacherService.getCourseName(courseId);

		int number = Integer.valueOf(request.getParameter("number"));
		String description = request.getParameter("description");
		System.out.println(description+"课程名！！！！！！");

//		String description = request.getParameter("description");
		String[] f=request.getParameterValues("format");
		String format="";
		for(int i=0;i<f.length;i++){
			format+=f[i]+";";
		}
			
		System.out.println(format);
		String sd = request.getParameter("submissionDeadline");
		String gd = request.getParameter("gradeDeadline");

		System.out.println(sd);
		System.out.println(gd);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date submissionDeadline = sdf.parse(sd);
		Date gradeDeadline = sdf.parse(gd);
		int score = Integer.valueOf(request.getParameter("score"));
		String level = request.getParameter("level");
		// String sample=request.getParameter("sample");;
		// String generalGrade=request.getParameter("generalGrade");

		if (teacherService.addAssignment(new Assignment(courseId, courseName,
				number, description, format, submissionDeadline, gradeDeadline,
				score, level)))
			return SUCCESS;
		else
			return ERROR;
	}

}
