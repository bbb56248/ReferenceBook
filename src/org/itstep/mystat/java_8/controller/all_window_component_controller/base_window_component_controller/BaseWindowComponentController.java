package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.itstep.mystat.java_8.controller.all_window_component_controller.AllWindowComponentController;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public abstract class BaseWindowComponentController extends AllWindowComponentController implements ChangeListener {

	protected BaseWindow baseWindow;

	protected static int numberCurrentQuestion;
	protected static SortedSet<Integer[]> indexesSelectedQuestions = new TreeSet<>(
			BaseWindowComponentController::compareIntegersWithIntegers);
	protected static String[] questionTitleAndAnswer;
	protected static boolean isQuestionFolderSelected;
	protected static boolean isStudiedOneQuestion;
	protected static boolean isStudiedAllQuestions;

	public BaseWindowComponentController(BaseWindow baseWindow) {
		this.baseWindow = baseWindow;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}

	protected static int compareIntegersWithIntegers(Integer[] a, Integer[] b) {
		return (a[0] != b[0]) ? a[0] - b[0] : (a[1] != b[1]) ? a[1] - b[1] : a[2] - b[2];
	}

	protected void setInitialState() {
		baseWindow.getQuestionLabel().setText("");
		baseWindow.getAnswerTextArea().setText("");
		baseWindow.getQuestionSelectedLabel().setText("0");
		baseWindow.getRestQuestionsLabel().setText("0");
		numberCurrentQuestion = 0;
		indexesSelectedQuestions.clear();
		questionTitleAndAnswer = null;
		isQuestionFolderSelected = false;
		isStudiedOneQuestion = false;
		isStudiedAllQuestions = false;
	}

}
