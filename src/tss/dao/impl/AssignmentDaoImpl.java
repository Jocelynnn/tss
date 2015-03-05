package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tss.dao.AssignmentDao;
import tss.dao.CourseDao;
import tss.dao.DaoHelper;
import tss.dao.StudentDao;
import tss.model.Assignment;
import tss.model.Course;

public class AssignmentDaoImpl implements AssignmentDao {
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

	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	private StudentDao studentDao;
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Map<String,ArrayList<Assignment>> getCourseAssignment(String teacherId) {
		// TODO Auto-generated method stub
		
		Map<String, ArrayList<Assignment>> allAssign=new HashMap<String,ArrayList<Assignment>>();
		ArrayList<Course> courses=courseDao.getTeacherCourses(teacherId);
		
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		

		for(Course c:courses){
			String courseId=c.getCourseId();
			
			try {
				ArrayList<Assignment> assigns=new ArrayList<Assignment>();

				stmt = con
						.prepareStatement("SELECT * FROM assignment WHERE courseId = ?");
				stmt.setString(1, courseId);
				result = stmt.executeQuery();

				while (result.next()) {
					assigns.add(new Assignment(result.getInt("id"), result
							.getString("courseId"), result.getString("courseName"),
							result.getInt("number"), result
									.getString("description"), result
									.getString("format"), result
									.getDate("submissionDeadline"), result
									.getDate("gradeDeadline"), result
									.getInt("score"), result.getString("level"),
							result.getString("sample"), result
									.getString("generalGrade")));
				}
				allAssign.put(courseId, assigns);

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		
		
		if(!allAssign.isEmpty())
			return allAssign;
		else
			return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean save(Assignment a) {
		// TODO Auto-generated method stub
		try {
			System.out.println(a.getCourseId() + "!!!!!!");
			config = new Configuration().configure();
			sessionFactory=config.buildSessionFactory();	
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(a); //保存Entity到数据库中
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
			return true;
		}catch (Exception e) {			
			e.printStackTrace();
		}
		
		return false;	}

	@Override
	public Assignment getAssignment(int assignId) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		Assignment a=null;
		
		try {
			stmt = con
					.prepareStatement("SELECT * FROM assignment WHERE id = ?");
			stmt.setInt(1, assignId);
			result = stmt.executeQuery();

			while (result.next()) {
				a=new Assignment(result.getInt("id"), result
						.getString("courseId"), result.getString("courseName"),
						result.getInt("number"), result
								.getString("description"), result
								.getString("format"), result
								.getDate("submissionDeadline"), result
								.getDate("gradeDeadline"), result
								.getInt("score"), result.getString("level"),
						result.getString("sample"), result
								.getString("generalGrade"));
			}

			return a;
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
	public Map<String, ArrayList<Assignment>> getTACourseAssignment(String taId) {
		// TODO Auto-generated method stub
		
				Map<String, ArrayList<Assignment>> allAssign=new HashMap<String,ArrayList<Assignment>>();
				ArrayList<String> courses=courseDao.getTACourses(taId);
				
				Connection con = daoHelper.getConnection();
				PreparedStatement stmt = null;
				ResultSet result = null;
				

				for(String c:courses){
					
					try {
						ArrayList<Assignment> assigns=new ArrayList<Assignment>();

						stmt = con
								.prepareStatement("SELECT * FROM assignment WHERE courseId = ?");
						stmt.setString(1, c);
						result = stmt.executeQuery();

						while (result.next()) {
							assigns.add(new Assignment(result.getInt("id"), result
									.getString("courseId"), result.getString("courseName"),
									result.getInt("number"), result
											.getString("description"), result
											.getString("format"), result
											.getDate("submissionDeadline"), result
											.getDate("gradeDeadline"), result
											.getInt("score"), result.getString("level"),
									result.getString("sample"), result
											.getString("generalGrade")));
						}
						allAssign.put(c, assigns);

					} catch (SQLException e) {
						e.printStackTrace();
					} 
				}
				
					daoHelper.closeConnection(con);
					daoHelper.closePreparedStatement(stmt);
					daoHelper.closeResult(result);
				
				
				if(!allAssign.isEmpty())
					return allAssign;
				else
					return null;
	}

	@Override
	public Assignment getOneAssignment(int assignmentId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM assignment WHERE id = ?");
			stmt.setInt(1, assignmentId);
			result = stmt.executeQuery();

			while (result.next()) {
				return new Assignment(result.getInt("id"), result
						.getString("courseId"), result.getString("courseName"),
						result.getInt("number"), result
								.getString("description"), result
								.getString("format"), result
								.getDate("submissionDeadline"), result
								.getDate("gradeDeadline"), result
								.getInt("score"), result.getString("level"),
						result.getString("sample"), result
								.getString("generalGrade"));
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
	public Map<String, ArrayList<Assignment>> getStudentAssignment(
			String studentId) {
		Map<String, ArrayList<Assignment>> allAssign = new HashMap<String, ArrayList<Assignment>>();
		ArrayList<Course> courses = (ArrayList<Course>) studentDao.getStuStudiedCourses((studentId));

		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		

		for(Course c:courses){
			String courseId=c.getCourseId();
			
			try {
				ArrayList<Assignment> assigns=new ArrayList<Assignment>();

				stmt = con
						.prepareStatement("SELECT * FROM assignment WHERE courseId = ?");
				stmt.setString(1, courseId);
				result = stmt.executeQuery();

				while (result.next()) {
					assigns.add(new Assignment(result.getInt("id"), result
							.getString("courseId"), result.getString("courseName"),
							result.getInt("number"), result
									.getString("description"), result
									.getString("format"), result
									.getDate("submissionDeadline"), result
									.getDate("gradeDeadline"), result
									.getInt("score"), result.getString("level"),
							result.getString("sample"), result
									.getString("generalGrade")));
				}
				allAssign.put(courseId, assigns);

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		
		
		if(!allAssign.isEmpty())
			return allAssign;
		else
			return null;
	}

}
