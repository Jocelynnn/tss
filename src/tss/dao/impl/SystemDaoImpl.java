package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tss.dao.AssignmentDao;
import tss.dao.CourseDao;
import tss.dao.DaoHelper;
import tss.dao.StudentDao;
import tss.dao.SubmissionDao;
import tss.dao.SystemDao;
import tss.dao.UserDao;
import tss.model.Course;

public class SystemDaoImpl implements SystemDao {
	private DaoHelper daoHelper;
	private StudentDao studentDao;
	private UserDao userDao;
	private SubmissionDao submissionDao;
	private CourseDao courseDao;
	private AssignmentDao assignmentDao;

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public SubmissionDao getSubmissionDao() {
		return submissionDao;
	}

	public void setSubmissionDao(SubmissionDao submissionDao) {
		this.submissionDao = submissionDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

	@Override
	public String getTeacherName(String courseId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				return result.getString("teacherName");
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
	public ArrayList<String> getTaNameList(String courseId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> taNameList = new ArrayList<String>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM teachingAssistant WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				taNameList.add(result.getString("assistantId"));
			}
			return taNameList;
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
	public ArrayList<String> getStudentName(String courseId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> studentNameList = new ArrayList<String>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentCourseSelection WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				studentNameList.add(result.getString("studentName"));
			}

			return studentNameList;
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
	public int getStudentAverageGrade(String studentId) {
		int count = 0;
		int allGrade = 0;

		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentSubmission WHERE studentId = ? AND isGraded = 2 AND isPassed = 2");
			stmt.setString(1, studentId);
			result = stmt.executeQuery();

			while (result.next()) {
				count++;
				allGrade += result.getInt("grade");
			}

			if (count != 0) {
				return allGrade / count;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return 0;
	}

	@Override
	public Course getCourseInfo(String courseId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				return new Course(result.getString("courseId"),
						result.getString("courseName"),
						result.getString("description"),
						result.getString("semester"),
						result.getString("teacherName"),
						result.getDate("initializationDeadline"),result.getInt("status"));
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

}
