package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class DatabaseIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = 6320230989952686874L;

	private static final String MESSAGE = "База данных = null";

	public DatabaseIsNullException() {
		super(MESSAGE);
	}

}
