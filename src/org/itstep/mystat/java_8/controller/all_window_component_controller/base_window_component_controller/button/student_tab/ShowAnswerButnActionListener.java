package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.student_tab;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.BaseWindowComponentController;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class ShowAnswerButnActionListener extends BaseWindowComponentController {

	public ShowAnswerButnActionListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((isQuestionFolderSelected) && (questionTitleAndAnswer != null)) {
			baseWindow.getAnswerTextArea().setText(questionTitleAndAnswer[1]);
		} else {
			JOptionPane.showMessageDialog(null, "Нет изучаемого вопроса");
		}
	}

}
