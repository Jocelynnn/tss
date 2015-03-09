package tss.dao;

import java.util.ArrayList;

import tss.model.Course;

public interface SystemDao {
	public String getTeacherName(String courseId); // 获取课程教师名字
	public Course getCourseInfo (String courseId); // 获取课程信息
	public ArrayList<String> getTaNameList(String courseId); // 获取助教名字
	
	public ArrayList<String> getStudentName(String courseId); // 获取所有选课学生
	public int getStudentAverageGrade(String studentId); // 计算某个学生平均分
}
