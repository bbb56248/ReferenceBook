package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public abstract class CorrectDataMissingException extends RuntimeException {

	private static final long serialVersionUID = -1841906199854216549L;

	public CorrectDataMissingException(String message) {
		super(message);
	}

}
