package tss.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignment")
public class Assignment {
	@Id
	public int id;
	public String courseId;
	public Assignment(int id, String courseId, String courseName, int number,
			String description, String format, Date submissionDeadline,
			Date gradeDeadline, int score, String level, String sample,
			String generalGrade,int status) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.number = number;
		this.description = description;
		this.format = format;
		this.submissionDeadline = submissionDeadline;
		this.gradeDeadline = gradeDeadline;
		this.score = score;
		this.level = level;
		this.sample = sample;
		this.generalGrade = generalGrade;
		this.status=status;
	}
	public String courseName;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	private int number;
	private String description;
	private String format;
	private Date submissionDeadline;
	private Date gradeDeadline;
	private int score;
	private String level;
	private String sample;
	private String generalGrade;
	private int status;
	public static int NOT_START=1;
	public static int ON_GOING=2;
	public static int END=3;

	
	
	public Assignment(String courseId, String courseName, int number,
			String description, String format, Date submissionDeadline,
			Date gradeDeadline, int score, String level) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.number = number;
		this.description = description;
		this.format = format;
		this.submissionDeadline = submissionDeadline;
		this.gradeDeadline = gradeDeadline;
		this.score = score;
		this.level = level;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Date getSubmissionDeadline() {
		return submissionDeadline;
	}
	public void setSubmissionDeadline(Date submissionDeadline) {
		this.submissionDeadline = submissionDeadline;
	}
	public Date getGradeDeadline() {
		return gradeDeadline;
	}
	public void setGradeDeadline(Date gradeDeadline) {
		this.gradeDeadline = gradeDeadline;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSample() {
		return sample;
	}
	public void setSample(String sample) {
		this.sample = sample;
	}
	public String getGeneralGrade() {
		return generalGrade;
	}
	public void setGeneralGrade(String generalGrade) {
		this.generalGrade = generalGrade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
