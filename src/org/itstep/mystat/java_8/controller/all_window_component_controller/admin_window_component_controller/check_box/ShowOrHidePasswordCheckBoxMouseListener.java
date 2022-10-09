package org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.check_box;

import java.awt.event.MouseEvent;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.AdminWindowComponentController;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class ShowOrHidePasswordCheckBoxMouseListener extends AdminWindowComponentController {

	public ShowOrHidePasswordCheckBoxMouseListener(AdminWindow adminWindow) {
		super(adminWindow);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (adminWindow.getShowOrHidePasswordCheckBox().isSelected()) {
			adminWindow.getShowOrHidePasswordCheckBox().setToolTipText("Скрыть пароль");
		} else {
			adminWindow.getShowOrHidePasswordCheckBox().setToolTipText("Показать пароль");
		}
	}

}
