package tss.model;

import java.util.Date;

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
//	1 for 未读  2 for 已读
	private Integer flag;
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Message(Integer Id, String userId, String message, Integer flag,Date date){
		this.Id = Id;
		this.userId = userId;
		this.message = message;
		this.flag = flag;
		this.date = date;
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
