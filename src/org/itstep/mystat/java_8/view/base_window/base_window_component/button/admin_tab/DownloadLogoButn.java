package org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.admin_tab.DownloadLogoButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.BaseWindowButn;

public class DownloadLogoButn extends BaseWindowButn {

	private static final long serialVersionUID = -709874885920004141L;

	public DownloadLogoButn(BaseWindow baseWindow) {
		super("<html><p align=\"center\">Загрузить<br>логотип<br>справочника</p>");
		addActionListener(new DownloadLogoButnActionListener(baseWindow));
	}

}
