package tss.action;

import tss.service.TaService;

public class TaSubmitGrade extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8758269678176806564L;
	private TaService taService;
	private int submissionId;
	private int assignId;
	private int grade;
	private String evaluation;

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	public TaService getTaService() {
		return taService;
	}

	public void setTaService(TaService taService) {
		this.taService = taService;
	}

	public int getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String execute() {
		System.out.println(submissionId+" "+assignId+" "+grade+" "+evaluation);
		if (taService.submitGrade(submissionId, grade, evaluation))
			return SUCCESS;
		else
			return ERROR;
	}

}
