package spring;

public class AuthInfo {
	private int id;
	private String email;
	private String name;
	
	public AuthInfo(int id, String email, String name) {
		this.id = id;
		this.setEmail(email);
		this.setName(name);
	}
	
	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
