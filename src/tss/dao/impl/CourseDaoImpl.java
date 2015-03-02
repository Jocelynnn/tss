package tss.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			stmt.setString(5,course.getTeacherName());
			Date date=new Date(0);
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
						courseList.add(new Course(result.getString("courseId"), result.getString("courseName"), result
								.getString("description"), result.getString("semester"),
								result.getString("teacherName"),result.getDate("initializationDeadline")));
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
