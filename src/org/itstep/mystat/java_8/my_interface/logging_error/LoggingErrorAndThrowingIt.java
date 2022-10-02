package org.itstep.mystat.java_8.my_interface.logging_error;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.CorrectDataMissingException;

public interface LoggingErrorAndThrowingIt extends LoggingError {

	public default void logErrorAndThrowIt(CorrectDataMissingException ex) throws CorrectDataMissingException {
		logError(ex);
		throw ex;
	}

}
