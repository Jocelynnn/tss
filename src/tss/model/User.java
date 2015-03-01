package tss.model;

public class User {
	public User(String username, String password, String realName,
			String email, int gender, int role) {
		super();
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.email = email;
		this.gender = gender;
		this.role = role;
	}
	private String username;
	private String password;
	private String realName;
	private String email;
//	1 (male) 2 (female)
	private int gender;
//	1（系统管理员）2（授课教师）3（选课学生）4（助教）5（教学负责人）6（选课学生和助教）7（授课教师和教学负责人）
	private int role;
	
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	

}
