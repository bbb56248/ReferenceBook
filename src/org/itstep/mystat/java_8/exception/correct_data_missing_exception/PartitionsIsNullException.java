package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class PartitionsIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = 25044100942311897L;

	private static final String MESSAGE = "База данных: Разделы = null";

	public PartitionsIsNullException() {
		super(MESSAGE);
	}

}
