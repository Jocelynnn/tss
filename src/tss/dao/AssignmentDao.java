package tss.dao;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;

public interface AssignmentDao {
	public boolean save(Assignment a);
	public Map<String,ArrayList<Assignment>> getCourseAssignment(String teacherId);
	public Assignment getAssignment(int assignId);

}
