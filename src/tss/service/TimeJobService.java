package tss.service;

import tss.model.Message;

public interface TimeJobService {
	public boolean updateStudentMessage();
	public Message getUserUnReadMessage(String userId);
	
	public boolean markTheMessageRead(Message message);
	public boolean updateTAMessage();
	
	public boolean updateCourseStatus();
	public boolean updateAssignmentStatus();

}
