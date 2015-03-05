package tss.action;

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
	
	public String execute(){
		this.assignment = studentService.getOneAssignment(Integer.parseInt(request.getParameter("assignmentId")));
		this.submission = studentService.getSingleSubmission((String) request.getSession().getAttribute("username"), assignment.getId());
		
		if (submission != null){
			return SUCCESS;
		}
		
		return ERROR;
	}
}
