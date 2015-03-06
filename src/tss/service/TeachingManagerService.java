package tss.service;

import java.util.ArrayList;
import java.util.List;

import tss.model.Assignment;
import tss.model.Course;
import tss.model.Submission;

public interface TeachingManagerService {
	public ArrayList<Course> getCourseList(); // 获取所有课程
	public ArrayList<Assignment> getCourseAssign(int courseId); // 获取某个课程的所有作业
	
	public ArrayList<Submission> getSubmissionList(); // 获取所有作业提交
	public ArrayList<Assignment> getAssignmentList(); // 获取所有布置作业
}
