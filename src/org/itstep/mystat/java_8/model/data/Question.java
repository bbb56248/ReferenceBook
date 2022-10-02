package org.itstep.mystat.java_8.model.data;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsEmptyException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsNullException;

public class Question extends Level {

	private String answer;

	public Question(String number, String title, String answer) {
		super(number, title);
		this.answer = answer;
	}

	public String getAnswer() throws StringFieldIsNullException, StringFieldIsEmptyException {
		checkFieldForCorrectness();
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public void checkFieldForCorrectness() throws StringFieldIsNullException, StringFieldIsEmptyException {
		checkFieldForCorrectness(answer, "answer");
	};

}
