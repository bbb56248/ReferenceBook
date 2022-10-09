package org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.button;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.AdminWindowComponentController;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class LoginButnActionListener extends AdminWindowComponentController {

	public LoginButnActionListener(AdminWindow adminWindow) {
		super(adminWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String login = adminWindow.getLoginField().getText();
		String password = new String(adminWindow.getPasswordField().getPassword());
		if ((login != null) && (!login.isEmpty()) && (password != null) && (!password.isEmpty())) {
			if (adminWindow.getAdminController().login(login, password)) {
				JOptionPane.showMessageDialog(null, "Вы успешно вошли как Администратор");
				adminWindow.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Такой Администратор не зарегистрирован");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Введите логин и пароль");
		}
	}

}
