package spring;

import java.time.LocalDateTime;

public class Member {

	private int id;
	private String email;
	private String password;
	private String name;
	private String city;
	private LocalDateTime registerDateTime;

	public Member(String email, String password, 
			String name, String city, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.city = city;
		this.registerDateTime = regDateTime;
	}

	void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

}
