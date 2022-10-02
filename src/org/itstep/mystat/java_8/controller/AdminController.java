package org.itstep.mystat.java_8.controller;

import org.itstep.mystat.java_8.model.admin.Admin;

public class AdminController {

	private Admin admin;

	public AdminController(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public boolean login(String login, String password) {
		return admin.login(login, password);
	}

	public boolean register(String login, String password) {
		return admin.register(login, password);
	}

	public boolean delete(String login, String password) {
		return admin.delete(login, password);
	}

}
