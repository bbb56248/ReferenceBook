package org.itstep.mystat.java_8.view.base_window.base_window_component.button.student_tab;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.student_tab.ShowAnswerButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.BaseWindowButn;

public class ShowAnswerButn extends BaseWindowButn {

	private static final long serialVersionUID = 2324572689183025659L;

	public ShowAnswerButn(BaseWindow baseWindow) {
		super("Показать ответ");
		addActionListener(new ShowAnswerButnActionListener(baseWindow));
	}

}
