package tss.service.impl;

import tss.dao.MessageDao;
import tss.dao.impl.MessageDaoImpl;
import tss.model.Message;
import tss.service.TimeJobService;

public class TimeJobServiceImpl implements TimeJobService {
	private MessageDao messageDao;
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
	

}
