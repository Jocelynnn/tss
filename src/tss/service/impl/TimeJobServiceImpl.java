package tss.service.impl;

import java.text.ParseException;

import tss.dao.AssignmentDao;
import tss.dao.CourseDao;
import tss.dao.MessageDao;
import tss.dao.impl.MessageDaoImpl;
import tss.model.Message;
import tss.service.TimeJobService;

public class TimeJobServiceImpl implements TimeJobService {
	private MessageDao messageDao;
	private CourseDao courseDao;
	private AssignmentDao assignmentDao;
	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public boolean updateStudentMessage() {
		return messageDao.updateStudentMessage();
	}

	@Override
	public Message getUserUnReadMessage(String userId) {
		return messageDao.getUserUnReadMessage(userId);
	}

	@Override
	public boolean markTheMessageRead(Message message) {
		return messageDao.markTheMessageRead(message);
	}

	@Override
	public boolean updateTAMessage() {
		return messageDao.updateTAMessage();
	}

	@Override
	public boolean updateCourseStatus() {
		// TODO Auto-generated method stub
		try {
			return courseDao.updateCourseStatus();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public boolean updateAssignmentStatus() {
		// TODO Auto-generated method stub
		return assignmentDao.updateAssignmentStatus();
	}
	

}
