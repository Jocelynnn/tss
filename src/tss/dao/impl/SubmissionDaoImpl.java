package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tss.dao.DaoHelper;
import tss.dao.SubmissionDao;
import tss.model.Submission;

public class SubmissionDaoImpl implements SubmissionDao {
	private Configuration config;
	private SessionFactory sessionFactory;
	private Session session;

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
								.getString("studentId"), result
								.getString("studentName"), result
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
			// 3 for unpassed
			stmt.setInt(2, 3);
			// 2 for graded
			stmt.setInt(3, 2);

			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
					.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isPassed = ? AND isGraded = ?");
			stmt.setInt(1, assignmentId);
			// 2 for passed
			stmt.setInt(2, 2);
			// 2 for graded
			stmt.setInt(3, 2);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
			// 1 for ungraded
			stmt.setInt(2, 1);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
			// 2 for graded
			stmt.setInt(2, 2);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
	public boolean saveSubmission(Submission submission) {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(submission); // 保存Entity到数据库中
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateSubmission(Submission submission) {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(submission); // 保存Entity到数据库中
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Submission> getUnviewedSubmission(int assignmentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE assignmentId = ? AND isPassed = ? AND isGraded = ?");
			stmt.setInt(1, assignmentId);
			// 1 for unviewed
			stmt.setInt(2, 1);
			// 2 for graded
			stmt.setInt(3, 2);
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
	public boolean teacherPassSubmission(int submissionId) {
		// TODO Auto-generated method stub
		Submission s = this.getSubmission(submissionId);
		// 2 for passed
		s.setIsPassed(2);
		this.updateSubmission(s);
		return true;
	}

	@Override
	public boolean teacherUnpassSubmission(int submissionId) {
		// TODO Auto-generated method stub
		Submission s = this.getSubmission(submissionId);
		// 3 for unpassed
		s.setIsPassed(3);
		this.updateSubmission(s);
		return true;
	}

	@Override
	public Submission getSubmission(int submissionId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE id = ?");
			stmt.setInt(1, submissionId);
			result = stmt.executeQuery();

			while (result.next()) {
				return new Submission(result.getInt("id"),
						result.getInt("assignmentId"),
						result.getString("studentId"),
						result.getString("studentName"),
						result.getString("submission"),
						result.getDate("submitDate"),
						result.getString("grader"), result.getInt("grade"),
						result.getString("evaluation"),
						result.getInt("isGraded"), result.getInt("isPassed"));
			}

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
	public ArrayList<Submission> getSubmissionList() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();

		try {
			stmt = con.prepareStatement("SELECT * FROM studentSubmission");
			result = stmt.executeQuery();

			while (result.next()) {
				submissionList
						.add(new Submission(result.getInt("id"), result
								.getInt("assignmentId"), result
								.getString("studentId"), result
								.getString("studentName"), result
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
	public boolean taSubmitGrade(String taId,int submissionId, int grade, String evaluation) {
		// TODO Auto-generated method stub
		Submission s = this.getSubmission(submissionId);
		s.setIsGraded(2);
		s.setGrade(grade);
		s.setGrader(taId);
		s.setEvaluation(evaluation);
		if (this.updateSubmission(s))
			return true;
		else
			return false;
	}

}
