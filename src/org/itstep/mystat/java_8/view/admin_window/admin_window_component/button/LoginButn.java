package org.itstep.mystat.java_8.view.admin_window.admin_window_component.button;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.button.LoginButnActionListener;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class LoginButn extends AdminWindowButn {

	private static final long serialVersionUID = -4674287289292536104L;

	public LoginButn(AdminWindow adminWindow) {
		super("Войти");
		addActionListener(new LoginButnActionListener(adminWindow));
	}

}
