package org.itstep.mystat.java_8.view.base_window.base_window_component;

import javax.swing.JCheckBox;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.DownloadOrUpdateCheckBoxMouseListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class DownloadOrUpdateCheckBox extends JCheckBox {

	private static final long serialVersionUID = -341005474273190957L;

	public DownloadOrUpdateCheckBox(BaseWindow baseWindow) {
		addMouseListener(new DownloadOrUpdateCheckBoxMouseListener(baseWindow));
	}

}
