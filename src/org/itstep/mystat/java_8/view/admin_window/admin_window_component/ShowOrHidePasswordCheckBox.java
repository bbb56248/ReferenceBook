package org.itstep.mystat.java_8.view.admin_window.admin_window_component;

import javax.swing.JCheckBox;

import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.check_box.ShowOrHidePasswordCheckBoxItemListener;
import org.itstep.mystat.java_8.controller.all_window_component_controller.admin_window_component_controller.check_box.ShowOrHidePasswordCheckBoxMouseListener;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;

public class ShowOrHidePasswordCheckBox extends JCheckBox {

	private static final long serialVersionUID = -527368888480106733L;

	public ShowOrHidePasswordCheckBox(AdminWindow adminWindow) {
		super(null, null, true);
		addMouseListener(new ShowOrHidePasswordCheckBoxMouseListener(adminWindow));
		addItemListener(new ShowOrHidePasswordCheckBoxItemListener(adminWindow));
	}

}
