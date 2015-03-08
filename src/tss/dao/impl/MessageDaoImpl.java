package tss.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tss.dao.*;
import tss.dao.impl.*;
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
						try {
							config = new Configuration().configure();
							sessionFactory = config.buildSessionFactory();
							session = sessionFactory.openSession();
							Transaction tx = session.beginTransaction();
							session.save(new Message(1,
									student.getUsername(),
									"you have homework deadline tomorrow", 1,new Date())); // 保存Entity到数据库中
							tx.commit();
							session.close();
							sessionFactory.close();
							System.out.println("UPDATE userinfo ok");
							return true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
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
}
