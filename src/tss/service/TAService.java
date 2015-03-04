package tss.service;

import java.util.ArrayList;
import java.util.Map;

import tss.model.Assignment;

public interface TAService {
	public 	Map<String,ArrayList<Assignment>> getCourseAssignments(String taId);


}
