package org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.check_box;

import java.awt.event.ItemEvent;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.AdminWindowComponentController;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class ShowOrHidePasswordCheckBoxItemListener extends AdminWindowComponentController {

	public ShowOrHidePasswordCheckBoxItemListener(AdminWindow adminWindow) {
		super(adminWindow);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			adminWindow.getPasswordField().setEchoChar('\u0000');
		} else {
			adminWindow.getPasswordField().setEchoChar('*');
		}
	}

}
