package org.itstep.mystat.java_8.view.admin_window;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.itstep.mystat.java_8.controller.AdminController;
import org.itstep.mystat.java_8.controller.AllWindowController;
import org.itstep.mystat.java_8.my_enum.User;
import org.itstep.mystat.java_8.view.admin_window.admin_window_component.MyCheckBox;
import org.itstep.mystat.java_8.view.admin_window.admin_window_component.button.DeleteButn;
import org.itstep.mystat.java_8.view.admin_window.admin_window_component.button.LoginButn;
import org.itstep.mystat.java_8.view.admin_window.admin_window_component.button.RegisterButn;

public class AdminWindow extends JDialog {

	private static final long serialVersionUID = 5319672073321959478L;

	private AdminController adminController;
	private AllWindowController allWindowController;

	private JTextField loginField = new JTextField(15);
	private JPasswordField passwordField = new JPasswordField(15);

	public AdminWindow(AdminController adminController) {
		this.adminController = adminController;
		createWindow();
	}

	public AdminController getAdminController() {
		return adminController;
	}

	public void setAdminController(AdminController adminController) {
		this.adminController = adminController;
	}

	public AllWindowController getAllWindowController() {
		return allWindowController;
	}

	public void setAllWindowController(AllWindowController allWindowController) {
		this.allWindowController = allWindowController;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	private void createWindow() {
		setTitle(User.Администратор.name());
		setSize(350, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);

		Container container = new Container();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);

		JLabel label1 = new JLabel("Логин:");
		layout.putConstraint(SpringLayout.WEST, label1, 55, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, label1, 20, SpringLayout.NORTH, container);
		container.add(label1);
		layout.putConstraint(SpringLayout.WEST, loginField, 30, SpringLayout.EAST, label1);
		layout.putConstraint(SpringLayout.NORTH, loginField, 0, SpringLayout.NORTH, label1);
		container.add(loginField);

		JLabel label2 = new JLabel("Пароль:");
		layout.putConstraint(SpringLayout.WEST, label2, 0, SpringLayout.WEST, label1);
		layout.putConstraint(SpringLayout.NORTH, label2, 20, SpringLayout.SOUTH, label1);
		container.add(label2);
		layout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, loginField);
		layout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, label2);
		container.add(passwordField);
		JCheckBox checkBox = new MyCheckBox(passwordField);
		layout.putConstraint(SpringLayout.WEST, checkBox, 5, SpringLayout.EAST, passwordField);
		layout.putConstraint(SpringLayout.NORTH, checkBox, 0, SpringLayout.NORTH, passwordField);
		container.add(checkBox);

		JButton registerButn = new RegisterButn(this);
		layout.putConstraint(SpringLayout.WEST, registerButn, 0, SpringLayout.WEST, label2);
		layout.putConstraint(SpringLayout.NORTH, registerButn, 30, SpringLayout.SOUTH, label2);
		container.add(registerButn);

		JButton loginButn = new LoginButn(this);
		layout.putConstraint(SpringLayout.WEST, loginButn, 0, SpringLayout.WEST, registerButn);
		layout.putConstraint(SpringLayout.NORTH, loginButn, 25, SpringLayout.SOUTH, registerButn);
		container.add(loginButn);

		JButton deleteButn = new DeleteButn(this);
		layout.putConstraint(SpringLayout.WEST, deleteButn, 0, SpringLayout.WEST, loginButn);
		layout.putConstraint(SpringLayout.NORTH, deleteButn, 25, SpringLayout.SOUTH, loginButn);
		container.add(deleteButn);

		add(container);
	}

}
