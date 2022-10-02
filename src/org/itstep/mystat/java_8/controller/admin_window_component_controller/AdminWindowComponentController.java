package org.itstep.mystat.java_8.controller.admin_window_component_controller;

import java.awt.event.ActionListener;

import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public abstract class AdminWindowComponentController implements ActionListener {

	protected AdminWindow adminWindow;

	public AdminWindowComponentController(AdminWindow adminWindow) {
		this.adminWindow = adminWindow;
	}

}
