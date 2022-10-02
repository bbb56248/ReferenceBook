package org.itstep.mystat.java_8.view.admin_window.admin_window_component.button;

import org.itstep.mystat.java_8.controller.admin_window_component_controller.DeleteButnActionListener;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class DeleteButn extends AdminWindowButn {

	private static final long serialVersionUID = -9208218693197786013L;

	public DeleteButn(AdminWindow adminWindow) {
		super("Удалить");
		addActionListener(new DeleteButnActionListener(adminWindow));
	}

}
