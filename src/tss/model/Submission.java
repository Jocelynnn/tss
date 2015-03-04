package tss.model;

import java.util.Date;

public class Submission {
	public int id;
	public int assignmentId;
	public Submission(int id, int assignmentId, String studentId,
			String submission, Date submitDate, String grader, int grade,
			String evaluation, int isGraded, int isPassed) {
		super();
		this.id = id;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
		this.submission = submission;
		this.submitDate = submitDate;
		this.grader = grader;
		this.grade = grade;
		this.evaluation = evaluation;
		this.isGraded = isGraded;
		this.isPassed = isPassed;
	}


	public String studentId;
	
	public String submission;
	public Date submitDate;
	public String grader;
	public int grade;
	public String evaluation;
//	(1未批改 2已批改）
	public int isGraded;
//	1 未审阅 3已通过 3未通过 需重批
	public int isPassed;
	
	
	public Submission(int assignmentId, String submission, Date submitDate) {
		super();
		this.assignmentId = assignmentId;
		this.submission = submission;
		this.submitDate = submitDate;
	}

}
