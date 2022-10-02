package org.itstep.mystat.java_8.my_interface.logging_error;

import org.apache.log4j.Logger;

public interface LoggingError {

	public static final Logger LOGGER = Logger.getLogger(LoggingError.class);

	public default void logError(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
	}

	public default void logError(Exception ex, String message) {
		LOGGER.error(message, ex);
	}

}
