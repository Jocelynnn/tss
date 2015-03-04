package tss.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import tss.dao.CourseDao;
import tss.dao.DaoHelper;
import tss.model.Course;
import tss.model.User;

public class CourseDaoImpl implements CourseDao {
	private DaoHelper daoHelper;

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO course(courseId, courseName, description,semester,teacherName,initializationDeadline) values (?,?,?,?,?,?)");
			stmt.setString(1, course.getCourseId());
			stmt.setString(2, course.getCourseName());
			stmt.setString(3, course.getDescription());
			stmt.setString(4, course.getSemester());
			stmt.setString(5, course.getTeacherName());
			Date date = new Date(0);
			stmt.setDate(6, date);

			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return false;
	}

	@Override
	public ArrayList<Course> getCourses(String searchKey) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Course> courseList = new ArrayList<Course>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE courseName LIKE ?");
			stmt.setString(1, '%' + searchKey + '%');
			result = stmt.executeQuery();

			while (result.next()) {
				courseList.add(new Course(result.getString("courseId"), result
						.getString("courseName"), result
						.getString("description"),
						result.getString("semester"), result
								.getString("teacherName"), result
								.getDate("initializationDeadline")));
			}

			return courseList;
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
	public ArrayList<Course> getTeacherCourses(String teacherName) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Course> courseList = new ArrayList<Course>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE teacherName = ?");
			stmt.setString(1, teacherName);
			result = stmt.executeQuery();

			while (result.next()) {
				courseList.add(new Course(result.getString("courseId"), result
						.getString("courseName"), null, result
						.getString("semester"),
						result.getString("teacherName"), null));
			}

			return courseList;
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
	public ArrayList<User> getCourseStudent(String courseId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<User> studentList = new ArrayList<User>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentCourseSelection WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				nameList.add(result.getString("studentName"));
			}
			System.out.println(nameList.size());
			Iterator<String> iter = nameList.iterator();
			while (iter.hasNext()) {
				String username = iter.next();
				stmt = con
						.prepareStatement("SELECT * FROM user WHERE username = ?");
				stmt.setString(1, username);
				result = stmt.executeQuery();
				while (result.next()) {
					studentList.add(new User(result.getString("username"),
							null, result.getString("realName"), result
									.getString("email"), result
									.getInt("gender"), result.getInt("role")));
				}

			}
			System.out.println(studentList.size());

			return studentList;
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
	public boolean addCourseStudent(String courseId, String studentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO studentCourseSelection(courseId, studentName) values (?,?)");
			stmt.setString(1, courseId);
			stmt.setString(2, studentId);

			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return false;
	}

	@Override
	public boolean addCourseTA(String courseId, String taId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO teachingAssistant(assistantName, courseId) values (?,?)");
			stmt.setString(1, taId);
			stmt.setString(2, courseId);

			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return false;
	}

	@Override
	public boolean removeCourseStudent(String courseId, String studentId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("DELETE FROM studentCourseSelection WHERE courseId= ? AND studentName= ? ");
			stmt.setString(1, courseId);
			stmt.setString(2, studentId);

			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return false;
	}

	@Override
	public boolean removeCourseTA(String courseId, String taId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("DELETE FROM teachingAssistant WHERE assistantName = ? And courseId = ?");
			stmt.setString(1, taId);
			stmt.setString(2, courseId);

			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return false;
	}

	@Override
	public String getCourseName(String courseId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		String courseName = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				courseName = result.getString("courseName");
			}

			return courseName;
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
	public ArrayList<String> getTACourses(String taId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> courseList = new ArrayList<String>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM teachingAssistant WHERE assistantId = ?");
			stmt.setString(1, taId);
			result = stmt.executeQuery();

			while (result.next()) {
				courseList.add(result.getString("courseId"));
			}

			return courseList;
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
