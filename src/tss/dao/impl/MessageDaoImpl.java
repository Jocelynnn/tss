package tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tss.dao.*;
import tss.model.Assignment;
import tss.model.Message;
import tss.model.User;

public class MessageDaoImpl implements MessageDao {
	private Configuration config;
	private SessionFactory sessionFactory;
	private Session session;

	private DaoHelper daoHelper;
	private StudentDao studentDao;
	private UserDao userDao;
	private SubmissionDao submissionDao;
	private CourseDao courseDao;
	private AssignmentDao assignmentDao;
	

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public SubmissionDao getSubmissionDao() {
		return submissionDao;
	}

	public void setSubmissionDao(SubmissionDao submissionDao) {
		this.submissionDao = submissionDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

	@Override
	public boolean updateStudentMessage() {
		ArrayList<Assignment> assignmentList = assignmentDao
				.getAssignmentList();

		try {
			for (Assignment assignment : assignmentList) {
				// 如果今天日期是提交日期前一天
				if (calculateDayDiff(assignment.getSubmissionDeadline(),
						new Date()) == 1) {
					ArrayList<User> studentList = courseDao
							.getCourseStudent(assignment.getCourseId());
					for (User student : studentList) {
						// 如果message提醒未存在于数据库，则存入
						if (this.getUserUnReadMessage(student.getUsername()) == null){
							try {
								config = new Configuration().configure();
								sessionFactory = config.buildSessionFactory();
								session = sessionFactory.openSession();
								Transaction tx = session.beginTransaction();
								session.save(new Message(0,
										student.getUsername(),
										"you have homework deadline tomorrow", 1,new Date())); // 保存Entity到数据库中
								tx.commit();
								session.close();
								sessionFactory.close();
								System.out.println("insert messageInfo ok");
							} catch (Exception e) {
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private int calculateDayDiff(Date dateOne, Date dateTwo) {
		// 计算时间差
		long nd = 1000 * 24 * 60 * 60;
		long diff = 0;
		int result = -1;

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			// 获得两个时间的毫秒时间差异
			diff = sdf.parse(sdf.format(dateOne)).getTime()
					- sdf.parse(sdf.format(dateTwo)).getTime();
			result = (int) (diff / nd);// 计算差多少天
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}

	@Override
	public Message getUserUnReadMessage(String userId) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("SELECT * FROM message WHERE userId = ? AND flag = 1");
			stmt.setString(1, userId);
			result = stmt.executeQuery();

			while (result.next()) {
				return new Message(result.getInt("id"), result.getString("userId"), result.getString("message"), result.getInt("flag"), result.getDate("date"));
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
	public boolean markTheMessageRead(Message message) {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			message.setFlag(2);
			session.update(message);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("UPDATE messageInfo ok");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateTAMessage() {
		ArrayList<Assignment> assignmentList = assignmentDao
				.getAssignmentList();

		try {
			for (Assignment assignment : assignmentList) {
				// 如果今天日期是批改日期前一天
				if (calculateDayDiff(assignment.getSubmissionDeadline(),
						new Date()) == 1) {
					ArrayList<String> taList = this.getCourseTA(assignment.getCourseId()); 
					for (String ta : taList) {
						// 如果message提醒未存在于数据库，则存入
						if (this.getUserUnReadMessage(ta) == null){
							try {
								config = new Configuration().configure();
								sessionFactory = config.buildSessionFactory();
								session = sessionFactory.openSession();
								Transaction tx = session.beginTransaction();
								session.save(new Message(0,
										ta,
										"you have to grade some work before tomorrow", 1, new Date())); // 保存Entity到数据库中
								tx.commit();
								session.close();
								sessionFactory.close();
								System.out.println("insert messageInfo ok");
							} catch (Exception e) {
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	private ArrayList<String> getCourseTA(String courseId){
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM teachingAssistant WHERE courseId = ?");
			stmt.setString(1, courseId);
			result = stmt.executeQuery();

			while (result.next()) {
				list.add(result.getString("assistantId"));
			}
			return list;
			
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
