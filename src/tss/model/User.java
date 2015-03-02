package tss.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	private String username;
	private String password;
	private String realName;
	private String email;
//	1 (male) 2 (female)
	private Integer gender;
//	1（系统管理员）2（授课教师）3（选课学生）4（助教）5（教学负责人）6（选课学生和助教）7（授课教师和教学负责人）
	private Integer role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public User(String username, String password, String realName,
			String email, Integer gender, Integer role) {
		super();
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.email = email;
		this.gender = gender;
		this.role = role;
	}
}
