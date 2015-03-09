package tss.model;

import java.util.Date;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentSubmission")
public class Submission {
	@Id
	public int id;
	public int assignmentId;
	
	
	public String studentId;
	public String studentName;
	public String submission;
	public Date submitDate;
	public String grader;
	public int grade;
	public String evaluation;
//	(1未批改 2已批改）
	public int isGraded;
//	1 未审阅 2已通过 3未通过 需重批
	public int isPassed;
	
	public static int UN_GRADED=1;
	public static int GRADED=2;
	public static int UN_VIEWED=1;
	public static int PASSED=2;
	public static int UN_PASSED=3;
	
	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
public Submission(int id, int assignmentId, String studentId,
			String studentName, String submission, Date submitDate,
			String grader, int grade, String evaluation, int isGraded,
			int isPassed) {
		super();
		this.id = id;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.submission = submission;
		this.submitDate = submitDate;
		this.grader = grader;
		this.grade = grade;
		this.evaluation = evaluation;
		this.isGraded = isGraded;
		this.isPassed = isPassed;
	}



	
	
	
	public Submission(int assignmentId, String studentId,String studentName,String submission, Date submitDate) {
		super();
		this.studentId=studentId;
		this.studentName=studentName;
		this.assignmentId = assignmentId;
		this.submission = submission;
		this.submitDate = submitDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAssignmentId() {
		return assignmentId;
	}


	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getSubmission() {
		return submission;
	}


	public void setSubmission(String submission) {
		this.submission = submission;
	}


	public Date getSubmitDate() {
		return submitDate;
	}


	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}


	public String getGrader() {
		return grader;
	}


	public void setGrader(String grader) {
		this.grader = grader;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	public int getIsGraded() {
		return isGraded;
	}


	public void setIsGraded(int isGraded) {
		this.isGraded = isGraded;
	}


	public int getIsPassed() {
		return isPassed;
	}


	public void setIsPassed(int isPassed) {
		this.isPassed = isPassed;
	}
	
	
	

}
