package tss.dao;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;

public interface AssignmentDao {
	public Map<String,ArrayList<Assignment>> getCourseAssignment(String teacherId);

}
