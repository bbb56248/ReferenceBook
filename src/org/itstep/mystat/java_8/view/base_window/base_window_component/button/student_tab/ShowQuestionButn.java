package org.itstep.mystat.java_8.view.base_window.base_window_component.button.student_tab;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.student_tab.ShowQuestionButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.BaseWindowButn;

public class ShowQuestionButn extends BaseWindowButn {

	private static final long serialVersionUID = 2600837472297784552L;

	public ShowQuestionButn(BaseWindow baseWindow) {
		super("Показать вопрос");
		addActionListener(new ShowQuestionButnActionListener(baseWindow));
	}

}
