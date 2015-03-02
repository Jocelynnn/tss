package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tss.dao.DaoHelper;
import tss.dao.StudentDao;
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
					stmt.setString(1, "%"+searchkey+"%");
					stmt.setInt(2, 3);
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
