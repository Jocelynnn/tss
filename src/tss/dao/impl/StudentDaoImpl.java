package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tss.dao.DaoHelper;
import tss.dao.StudentDao;
import tss.model.Course;
import tss.model.User;

public class StudentDaoImpl implements StudentDao {
	private DaoHelper daoHelper;

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@Override
	public ArrayList<User> searchStudent(String searchkey) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<User> users = new ArrayList<User>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM user WHERE username like ? AND role = ?");
			stmt.setString(1, "%" + searchkey + "%");
			stmt.setInt(2, 3);
			result = stmt.executeQuery();

			while (result.next()) {
				users.add(new User(result.getString("username"), null, result
						.getString("realName"), result.getString("email"),
						result.getInt("gender"), result.getInt("role")));
			}

			return users;
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
	public ArrayList<User> getAllStudent() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<User> users = new ArrayList<User>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM user WHERE role = ? ORDER BY username");
			stmt.setInt(1, 3);
			result = stmt.executeQuery();

			while (result.next()) {
				users.add(new User(result.getString("username"), null, result
						.getString("realName"), result.getString("email"),
						result.getInt("gender"), result.getInt("role")));
			}

			return users;
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
	public ArrayList<User> getCourseTA(String courseId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<User> studentList = new ArrayList<User>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM teachingAssistant WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				nameList.add(result.getString("assistantName"));
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
	public User getStudent(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getStuStudiedCourses(String studentName) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<Course> courseList = new ArrayList<Course>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM studentCourseSelection WHERE studentName = ?");
			stmt.setString(1, studentName);
			result = stmt.executeQuery();

			while (result.next()) {
				nameList.add(result.getString("courseId"));
			}
			System.out.println(nameList.size());
			Iterator<String> iter = nameList.iterator();
			while (iter.hasNext()) {
				String courseId = iter.next();
				stmt = con
						.prepareStatement("SELECT * FROM course WHERE courseId = ?");
				stmt.setString(1, courseId);
				result = stmt.executeQuery();
				while (result.next()) {
					courseList.add(new Course(result.getString("courseId"), result
							.getString("courseName"), result.getString("description"), result
							.getString("semester"),
							result.getString("teacherName"), null));
				}

			}
			System.out.println(courseList.size());

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
