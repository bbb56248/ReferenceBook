package org.itstep.mystat.java_8.model.data;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.CorrectDataMissingException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsEmptyException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsNullException;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndThrowingIt;

public abstract class Level implements LoggingErrorAndThrowingIt {

	private String number;
	private String title;

	public Level(String number, String title) {
		this.number = number;
		this.title = title;
	}

	public String getNumber() throws StringFieldIsNullException, StringFieldIsEmptyException {
		checkFieldForCorrectness(number, "number");
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() throws StringFieldIsNullException, StringFieldIsEmptyException {
		checkFieldForCorrectness(title, "title");
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	protected void checkFieldForCorrectness(String fieldValue, String fieldTitle)
			throws StringFieldIsNullException, StringFieldIsEmptyException {
		if (fieldValue == null) {
			logErrorAndThrowIt(
					new StringFieldIsNullException(getClass().getSimpleName() + " " + fieldTitle + " = null"));
		}
		if (((String) fieldValue).isEmpty()) {
			logErrorAndThrowIt(
					new StringFieldIsEmptyException(getClass().getSimpleName() + " " + fieldTitle + " = empty"));
		}
	}

	protected abstract void checkFieldForCorrectness() throws CorrectDataMissingException;

}
