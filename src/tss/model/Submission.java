package tss.model;

import java.util.Date;

public class Submission {
	public int id;
	public int assignmentId;
	
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
