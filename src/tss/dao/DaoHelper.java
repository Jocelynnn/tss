package tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface DaoHelper {
	public Connection getConnection();
	public void closeConnection(Connection con);
	public void closePreparedStatement(PreparedStatement stmt);
	public void closeResult(ResultSet result);
	
	public ArrayList<Integer> getLists(String sql, int c_identifier, String value);
}
