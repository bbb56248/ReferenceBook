package org.itstep.mystat.java_8.view.base_window.base_window_component.admin_tab;

import org.itstep.mystat.java_8.controller.base_window_component_controller.admin_tab.DownloadContentButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.BaseWindowButn;

public class DownloadContentButn extends BaseWindowButn {

	private static final long serialVersionUID = 1666165901790256957L;

	public DownloadContentButn(BaseWindow baseWindow) {
		super("<html><p align=\"center\">Загрузить<br>содержимое<br>справочника</p>");
		addActionListener(new DownloadContentButnActionListener(baseWindow));
	}

}
