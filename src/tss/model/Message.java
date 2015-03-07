package tss.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="message")
public class Message {
	@Id
	private Integer Id;
	private String userId;
	private String message;
	private Integer flag;
	
	public Message(Integer Id, String userId, String message, Integer flag){
		this.Id = Id;
		this.userId = userId;
		this.message = message;
		this.flag = flag;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
