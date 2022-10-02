package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class StringFieldIsEmptyException extends CorrectDataMissingException {

	private static final long serialVersionUID = 9063407180340804190L;

	public StringFieldIsEmptyException(String message) {
		super(message);
	}

}
