package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tss.dao.DaoHelper;
import tss.dao.SubmissionDao;
import tss.model.Submission;

public class SubmissionDaoImpl implements SubmissionDao {

	private DaoHelper daoHelper;

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@Override
	public ArrayList<Submission> getAssignSubmissions(int assignmentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ?");
			stmt.setInt(1, assignmentId);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result.getString("studentName"),result
								.getString("submission"), result
								.getDate("submitDate"), result
								.getString("grader"), result.getInt("grade"),
								result.getString("evaluation"), result
										.getInt("isGraded"), result
										.getInt("isPassed")));
			}

			return submissionList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	
	@Override
	public ArrayList<Submission> getUnpassedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
				Connection con = daoHelper.getConnection();
				PreparedStatement stmt = null;
				ResultSet result = null;
				ArrayList<Submission> submissionList = new ArrayList<Submission>();

				try {
					stmt = con
							.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isPassed = ? AND isGraded= ?");
					stmt.setInt(1, assignmentId);
//					3 for unpassed 
					stmt.setInt(2, 3);
//					2 for graded
					stmt.setInt(3, 2);

					result = stmt.executeQuery();

					while (result.next()) {
						submissionList
								.add(new Submission(result.getInt("id"), result
										.getInt("assignmentId"), result
										.getString("studentId"), result.getString("studentName"),result
										.getString("submission"), result
										.getDate("submitDate"), result
										.getString("grader"), result.getInt("grade"),
										result.getString("evaluation"), result
												.getInt("isGraded"), result
												.getInt("isPassed")));
					}

					return submissionList;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					daoHelper.closeConnection(con);
					daoHelper.closePreparedStatement(stmt);
					daoHelper.closeResult(result);
				}

				return null;
	}

	@Override
	public ArrayList<Submission> getPassedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isPassed = ?");
			stmt.setInt(1, assignmentId);
//			2 for unpassed 
			stmt.setInt(2, 2);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result.getString("studentName"),result
								.getString("submission"), result
								.getDate("submitDate"), result
								.getString("grader"), result.getInt("grade"),
								result.getString("evaluation"), result
										.getInt("isGraded"), result
										.getInt("isPassed")));
			}

			return submissionList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	@Override
	public ArrayList<Submission> getUngradedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isGraded = ?");
			stmt.setInt(1, assignmentId);
//			1 for ungraded 
			stmt.setInt(2, 1);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result.getString("studentName"),result
								.getString("submission"), result
								.getDate("submitDate"), result
								.getString("grader"), result.getInt("grade"),
								result.getString("evaluation"), result
										.getInt("isGraded"), result
										.getInt("isPassed")));
			}

			return submissionList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	@Override
	public ArrayList<Submission> getGradedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
				Connection con = daoHelper.getConnection();
				PreparedStatement stmt = null;
				ResultSet result = null;
				ArrayList<Submission> submissionList = new ArrayList<Submission>();

				try {
					stmt = con
							.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isGraded = ?");
					stmt.setInt(1, assignmentId);
//					2 for graded 
					stmt.setInt(2, 2);
					result = stmt.executeQuery();

					while (result.next()) {
						submissionList
								.add(new Submission(result.getInt("id"), result
										.getInt("assignmentId"), result
										.getString("studentId"), result.getString("studentName"),result
										.getString("submission"), result
										.getDate("submitDate"), result
										.getString("grader"), result.getInt("grade"),
										result.getString("evaluation"), result
												.getInt("isGraded"), result
												.getInt("isPassed")));
					}

					return submissionList;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					daoHelper.closeConnection(con);
					daoHelper.closePreparedStatement(stmt);
					daoHelper.closeResult(result);
				}

				return null;
	}

}
