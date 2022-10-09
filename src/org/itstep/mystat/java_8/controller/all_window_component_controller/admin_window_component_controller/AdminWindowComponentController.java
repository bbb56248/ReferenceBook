package org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.itstep.mystat.java_8.controller.all_window_component_controller.AllWindowComponentController;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public abstract class AdminWindowComponentController extends AllWindowComponentController implements ItemListener {

	protected AdminWindow adminWindow;

	public AdminWindowComponentController(AdminWindow adminWindow) {
		this.adminWindow = adminWindow;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

}
