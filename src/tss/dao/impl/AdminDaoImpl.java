package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tss.dao.AdminDao;
import tss.dao.DaoHelper;
import tss.dao.UserDao;
import tss.model.User;

public class AdminDaoImpl implements AdminDao {
	private DaoHelper daoHelper;
	private UserDao userDao;

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO user(username, password, realName,email,gender,role) values (?,?,?,?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRealName());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, user.getGender());
			stmt.setInt(6, user.getRole());

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
	public ArrayList<User> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllTeachingAssistant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllTeachingManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeacher(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleStudent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeacherAssistant(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleTeachingManager(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTeacher(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeachingAssistan(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeachingManager(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> searchUser(String searchkey) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<User> users = new ArrayList<User>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM user WHERE username LIKE ?");
			stmt.setString(1, '%' + searchkey + '%');
			result = stmt.executeQuery();

			while (result.next()) {
				users.add(new User(result.getString("username"), null, result
						.getString("realName"), result.getString("email"),
						result.getInt("gender"),result.getInt("role")));
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

}
