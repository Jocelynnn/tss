package tss.dao;

import java.util.ArrayList;

import tss.model.User;

public interface StudentDao {
	public ArrayList<User> searchStudent(String searchkey);

}
