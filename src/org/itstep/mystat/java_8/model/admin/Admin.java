package org.itstep.mystat.java_8.model.admin;

public final class Admin extends Singleton<Admin> {

	private boolean isAdminCreated;

	private String login;
	private String password;

	public boolean login(String login, String password) {
		return (isAdminCreated) && (this.login.equals(login)) && (this.password.equals(password));
	}

	public boolean register(String login, String password) {
		if (!isAdminCreated) {
			this.login = login;
			this.password = password;
			isAdminCreated = true;
			return true;
		}
		return false;
	}

	public boolean delete(String login, String password) {
		if ((isAdminCreated) && (this.login.equals(login)) && (this.password.equals(password))) {
			this.login = null;
			this.password = null;
			isAdminCreated = false;
			return true;
		}
		return false;
	}

}
