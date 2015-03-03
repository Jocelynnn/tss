package tss.service;

import java.util.List;

import tss.model.Course;

public interface StudentService {
	public List<Course> getStuStudiedCourses(String studentName);
}
