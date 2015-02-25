package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tss.dao.DaoHelper;
import tss.dao.UserDao;
import tss.model.User;

public class UserDaoImpl implements UserDao {
	
	private DaoHelper daoHelper;
	public DaoHelper getDaoHelper() {
		return daoHelper;
	}
	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@Override
	public User getPersonalInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int validate(String username, String password) {
		// TODO Auto-generated method stub
		
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("SELECT password, role FROM user WHERE username = ?");
			stmt.setString(1, username);
			result = stmt.executeQuery();
			
			while(result.next()){
				if(result.getString("password").equals(password)){
					return result.getInt("role");
				}
				else{
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
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
	public boolean updatePersonalInfo(User User, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
