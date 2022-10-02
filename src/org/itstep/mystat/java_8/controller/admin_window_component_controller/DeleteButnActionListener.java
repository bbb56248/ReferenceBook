package org.itstep.mystat.java_8.controller.admin_window_component_controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class DeleteButnActionListener extends AdminWindowComponentController {

	public DeleteButnActionListener(AdminWindow adminWindow) {
		super(adminWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String login = adminWindow.getLoginField().getText();
		String password = new String(adminWindow.getPasswordField().getPassword());
		if ((login != null) && (!login.isEmpty()) && (password != null) && (!password.isEmpty())) {
			if (adminWindow.getAdminController().delete(login, password)) {
				JOptionPane.showMessageDialog(null, "Администратор успешно удален");
				adminWindow.getLoginField().setText("");
				adminWindow.getPasswordField().setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Такой Администратор не зарегистрирован");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Введите логин и пароль");
		}
	}

}
