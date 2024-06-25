package Com.bean;

public class Admin {
    private String loginId;
    private String password;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

    // Constructor, getters, and setters
}
