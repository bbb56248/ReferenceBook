package org.itstep.mystat.java_8.view.base_window.base_window_component.student_tab;

import org.itstep.mystat.java_8.controller.base_window_component_controller.student_tab.ShowAnswerButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.BaseWindowButn;

public class ShowAnswerButn extends BaseWindowButn {

	private static final long serialVersionUID = 2324572689183025659L;

	public ShowAnswerButn(BaseWindow baseWindow) {
		super("Показать ответ");
		addActionListener(new ShowAnswerButnActionListener(baseWindow));
	}

}
