package org.itstep.mystat.java_8.view.base_window.base_window_component.student_tab;

import org.itstep.mystat.java_8.controller.base_window_component_controller.student_tab.ShowQuestionButnActionListener;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.BaseWindowButn;

public class ShowQuestionButn extends BaseWindowButn {

	private static final long serialVersionUID = 2600837472297784552L;

	public ShowQuestionButn(BaseWindow baseWindow) {
		super("Показать вопрос");
		addActionListener(new ShowQuestionButnActionListener(baseWindow));
	}

}
