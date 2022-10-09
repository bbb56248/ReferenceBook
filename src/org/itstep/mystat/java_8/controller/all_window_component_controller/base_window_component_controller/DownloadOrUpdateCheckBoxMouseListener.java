package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller;

import java.awt.event.MouseEvent;

import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class DownloadOrUpdateCheckBoxMouseListener extends BaseWindowComponentController {

	public DownloadOrUpdateCheckBoxMouseListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (baseWindow.getDownloadOrUpdateCheckBox().isSelected()) {
			baseWindow.getDownloadOrUpdateCheckBox().setToolTipText("Загрузить из текущей папки");
		} else {
			baseWindow.getDownloadOrUpdateCheckBox().setToolTipText("Загрузить из новой папки");
		}
	}
}
