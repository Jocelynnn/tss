package tss.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tss.model.Assignment;
import tss.model.Submission;
import tss.service.StudentService;

public class StudentGetSingleAssignment extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1996746451061914097L;
	
	private Assignment assignment;
	private Submission submission;
	private StudentService studentService;
	private int type; // 1：未提交 2：已提交 3：已过期
	private String fileName;
	
	public String execute(){
		this.assignment = studentService.getOneAssignment(Integer.parseInt(request.getParameter("assignmentId")));
		this.submission = studentService.getSingleSubmission((String) request.getSession().getAttribute("username"), assignment.getId());
		
		if (submission == null){
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			// 未提交已过期
			try {
				if (sdf.parse(sdf.format(this.assignment.getSubmissionDeadline())).compareTo(sdf.parse(sdf.format(date))) == -1){
					type = 4;
					return SUCCESS;
				}
				else{
					type = 1;
					return SUCCESS;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else{
			String[] temp = submission.getSubmission().split("/");
			this.fileName = temp[temp.length-1];

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			try {
				if (sdf.parse(sdf.format(date)).compareTo(sdf.parse(sdf.format(this.assignment.getSubmissionDeadline()))) == -1){
					// 已提交未过期
					type = 2;
					return SUCCESS;
				}
				else{
					// 已提交已过期
					type = 3;
					return SUCCESS;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(type+"!!!");
		
		return ERROR;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
