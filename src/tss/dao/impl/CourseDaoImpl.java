package tss.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tss.dao.CourseDao;
import tss.dao.DaoHelper;
import tss.model.Course;
import tss.model.User;

public class CourseDaoImpl implements CourseDao {
	private DaoHelper daoHelper;
	private Configuration config;
	private SessionFactory sessionFactory;
	private Session session;

	private Map<String, String[]> courseTimeList = new HashMap<String, String[]>();

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
								.getDate("initializationDeadline"), result
								.getInt("status")));
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
						result.getString("teacherName"), null, result
								.getInt("status")));
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
					.prepareStatement("INSERT INTO teachingAssistant(assistantId, courseId) values (?,?)");
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
					.prepareStatement("DELETE FROM teachingAssistant WHERE assistantId = ? And courseId = ?");
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

	@Override
	public ArrayList<Course> getCourseList() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Course> courseList = new ArrayList<Course>();

		try {
			stmt = con.prepareStatement("SELECT * FROM course");
			result = stmt.executeQuery();

			while (result.next()) {
				courseList.add(new Course(result.getString("courseId"), result
						.getString("courseName"), result
						.getString("description"),
						result.getString("semester"), result
								.getString("teacherName"), result
								.getDate("initializationDeadline"), result
								.getInt("status")));
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
	public boolean updateCourse(Course c) {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(c); // 保存Entity到数据库中
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCourseStatus() throws ParseException {
		// TODO Auto-generated method stub
		initCourseTimeList();
		ArrayList<Course> courseList = this.getCourseList();

		for (Course c : courseList) {
			String semester = c.getSemester();
			String start = courseTimeList.get(semester)[0];
			String end = courseTimeList.get(semester)[1];
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//
			// 小写的mm表示的是分钟
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date startDate = format.parse(start);
			java.util.Date endDate = format.parse(end);
			java.util.Date now = new java.util.Date();
			System.out.println("start~~" + startDate.toLocaleString()
					+ " end~~" + endDate.toLocaleString() + " now~"
					+ now.toLocaleString());
			// now-startDate <0 课程未到时间
			// now -startDate >=0 && now- endDate<0 课程已经开始 还未结束
			// now -endDate>=0
			if (calculateDayDiff(now, startDate) < 0) {
				c.setStatus(1);
			} else if (calculateDayDiff(now, endDate) < 0) {
				c.setStatus(2);
			} else if (calculateDayDiff(now, endDate) < 0) {
				c.setStatus(3);
			}
			updateCourse(c);
		}
		return true;
	}

	public void initCourseTimeList() {
		courseTimeList.clear();
		String[] spring = { "2015-1-1", "2015-4-1" };
		String[] summer = { "2015-4-2", "2015-7-1" };
		String[] fall = { "2015-7-2", "2015-10-1" };
		String[] winter = { "2015-10-2", "2015-12-31" };
		courseTimeList.put("2015 spring", spring);
		courseTimeList.put("2015 summer", summer);
		courseTimeList.put("2015 fall", fall);
		courseTimeList.put("2015 winter", winter);
	}

	public Map<String, String[]> getCourseTimeList() {
		return courseTimeList;
	}

	public void setCourseTimeList(Map<String, String[]> courseTimeList) {
		this.courseTimeList = courseTimeList;
	}

	private int calculateDayDiff(java.util.Date now, java.util.Date startDate) {
		// 计算时间差
		long nd = 1000 * 24 * 60 * 60;
		long diff = 0;
		int result = -1;

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			// 获得两个时间的毫秒时间差异
			diff = sdf.parse(sdf.format(now)).getTime()
					- sdf.parse(sdf.format(startDate)).getTime();
			result = (int) (diff / nd);// 计算差多少天
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}

	@Override
	public Course getCourse(String courseId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		Course course=null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM course WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				course = new Course(result.getString("courseId"), result
						.getString("courseName"), result
						.getString("description"),
						result.getString("semester"), result
								.getString("teacherName"), result
								.getDate("initializationDeadline"), result
								.getInt("status"));
			}

			return course;
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
