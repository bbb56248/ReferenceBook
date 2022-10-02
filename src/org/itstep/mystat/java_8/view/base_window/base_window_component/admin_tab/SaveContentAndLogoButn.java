package org.itstep.mystat.java_8.view.base_window.base_window_component.admin_tab;

import org.itstep.mystat.java_8.controller.base_window_component_controller.admin_tab.SaveContentAndLogoButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.BaseWindowButn;

public class SaveContentAndLogoButn extends BaseWindowButn {

	private static final long serialVersionUID = 9098776493721282329L;

	public SaveContentAndLogoButn(BaseWindow baseWindow) {
		super("<html><p align=\"center\">Сохранить<br>содержимое и<br>логотип справочника</p>");
		updateStatus(baseWindow);
		addActionListener(new SaveContentAndLogoButnActionListener(baseWindow));
	}

	public void updateStatus(BaseWindow baseWindow) {
		if ((baseWindow.getMyTree().getModel() == null) || (baseWindow.getLogoLabel().getIcon() == null)) {
			setEnabled(false);
		} else {
			setEnabled(true);
		}
	}

}
