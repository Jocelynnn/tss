package tss.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	public Course(String courseId, String courseName, String description,
			String semester, String teacherName, Date initializationDeadline,
			int status) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.semester = semester;
		this.teacherName = teacherName;
		this.initializationDeadline = initializationDeadline;
		this.status = status;
	}

	@Id
	public String courseId;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getInitializationDeadline() {
		return initializationDeadline;
	}

	public void setInitializationDeadline(Date initializationDeadline) {
		this.initializationDeadline = initializationDeadline;
	}

	private String courseName;
	private String description;
	// open and close of the courses
	private String semester;
	private String teacherName;
	private Date initializationDeadline;
	// 0 for initial status ; 1 for 未到 ; 2 for ongoing ; 3 for 已过期
	private int status;
	
	public static int NOT_START=1;
	public static int ON_GOING=2;
	public static int END=3;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
