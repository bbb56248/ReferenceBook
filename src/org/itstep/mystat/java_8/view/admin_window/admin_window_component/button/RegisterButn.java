package org.itstep.mystat.java_8.view.admin_window.admin_window_component.button;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.button.RegisterButnActionListener;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class RegisterButn extends AdminWindowButn {

	private static final long serialVersionUID = -6086974378985038253L;

	public RegisterButn(AdminWindow adminWindow) {
		super("Зарегистрироваться");
		addActionListener(new RegisterButnActionListener(adminWindow));
	}

}
