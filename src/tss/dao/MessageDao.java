package tss.dao;

import tss.model.Message;

public interface MessageDao {
	public boolean updateStudentMessage();
	public Message getUserUnReadMessage(String userId);
	
	public boolean markTheMessageRead(Message message);
}
