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
import tss.dao.UserDao;
import tss.model.Message;
import tss.model.Submission;
import tss.model.User;

public class UserDaoImpl implements UserDao {
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
	public User getPersonalInfo(String username) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM user WHERE username = ?");
			stmt.setString(1, username);
			result = stmt.executeQuery();

			while (result.next()) {
				return new User(result.getString("username"),
						result.getString("password"),
						result.getString("realName"),
						result.getString("email"), result.getInt("gender"),
						result.getInt("role"));
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
	public int validate(String username, String password) {
		// TODO Auto-generated method stub

		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT password, role FROM user WHERE username = ?");
			stmt.setString(1, username);
			result = stmt.executeQuery();

			while (result.next()) {
				if (result.getString("password").equals(password)) {
					return result.getInt("role");
				} else {
					return 0;
				}
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
	public boolean register(String username, String password, String realName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePersonalInfo(User user) {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(user); // 保存Entity到数据库中
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("UPDATE userinfo ok");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<User> getAllUser() {
		// TODO Auto-generated method stub

		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<User> userList = new ArrayList<User>();

		try {
			stmt = con.prepareStatement("SELECT * FROM user order by username");
			result = stmt.executeQuery();

			while (result.next()) {
				userList.add(new User(result.getString("username"), result
						.getString("password"), result.getString("realName"),
						result.getString("email"), result.getInt("gender"),
						result.getInt("role")));
			}
			return userList;
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
	public ArrayList<Message> getUserMessage(String userId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Message> messageList = new ArrayList<Message>();

		try {
			// 未读消息排在前面
			stmt = con.prepareStatement("SELECT * FROM message order by flag");
			result = stmt.executeQuery();

			while (result.next()) {
				messageList.add(new Message(result.getInt("Id"), result
						.getString("userId"), result.getString("message"),
						result.getInt("flag"),result.getDate("date")));
			}
			return messageList;
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
