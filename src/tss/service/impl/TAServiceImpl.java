package tss.service.impl;

import java.util.ArrayList;
import java.util.Map;

import tss.dao.AssignmentDao;
import tss.model.Assignment;
import tss.service.TAService;

public class TAServiceImpl implements TAService{
	private AssignmentDao assignmentDao;

	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

	@Override
	public Map<String, ArrayList<Assignment>> getCourseAssignments(String taId) {
		// TODO Auto-generated method stub
		return null;
	}

}
