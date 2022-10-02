package org.itstep.mystat.java_8.controller.base_window_component_controller.student_tab;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.controller.base_window_component_controller.BaseWindowComponentController;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class ShowQuestionButnActionListener extends BaseWindowComponentController {

	public ShowQuestionButnActionListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int pick;
		Integer[] indexesSelectedQuestion;
		if (isQuestionFolderSelected) {
			baseWindow.getAnswerTextArea().setText("");
			if (isStudiedAllQuestions) {
				baseWindow.getQuestionLabel().setText("");
				pick = JOptionPane.showConfirmDialog(null, "Повторить?", "Message", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null);
				if (pick == 0) {
					baseWindow.getRestQuestionsLabel().setText(baseWindow.getQuestionSelectedLabel().getText());
					numberCurrentQuestion = 0;
					isStudiedAllQuestions = false;
				} else {
					baseWindow.getMyTree().getSelectionModel().setSelectionPaths(null);
					isQuestionFolderSelected = false;
					baseWindow.getQuestionSelectedLabel().setText("0");
					return;
				}
			}
			indexesSelectedQuestion = indexesSelectedQuestions.toArray(new Integer[0][0])[numberCurrentQuestion];
			questionTitleAndAnswer = baseWindow.getDatabaseController()
					.getQuestionTitleAndAnswer(indexesSelectedQuestion);
			baseWindow.getQuestionLabel().setText(questionTitleAndAnswer[0]);
			isStudiedOneQuestion = true;
			numberCurrentQuestion++;
			if (isStudiedOneQuestion) {
				baseWindow.getRestQuestionsLabel()
						.setText("" + (Integer.valueOf(baseWindow.getRestQuestionsLabel().getText()) - 1));
				isStudiedOneQuestion = false;
			}
			if (numberCurrentQuestion == indexesSelectedQuestions.size()) {
				isStudiedAllQuestions = true;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Нужно выбрать вопрос(ы)");
		}
	}

}
