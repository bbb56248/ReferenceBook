package org.itstep.mystat.java_8.view.admin_window.admin_window_component;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class MyCheckBox extends JCheckBox {

	private static final long serialVersionUID = -1462683306142067930L;

	public MyCheckBox(JPasswordField passwordField) {
		setSelected(true);
		addItemListener(e -> {
			if (e.getStateChange() == 1) {
				passwordField.setEchoChar('\u0000');
				setToolTipText("Скрыть пароль");
			} else {
				passwordField.setEchoChar('*');
				setToolTipText("Показать пароль");
			}
		});
		setSelected(false);
	}

}
