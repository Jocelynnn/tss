package tss.model;

import java.util.Date;

public class Course {
	public Course(String courseId, String courseName, String description,
			String semester, String teacherName, Date initializationDeadline) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.semester = semester;
		this.teacherName = teacherName;
		this.initializationDeadline = initializationDeadline;
	}
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
	public String courseName;
	public String description;
	public String semester;
	public String teacherName;
	public Date initializationDeadline;

}
