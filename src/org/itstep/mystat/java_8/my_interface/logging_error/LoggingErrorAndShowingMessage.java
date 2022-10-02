package org.itstep.mystat.java_8.my_interface.logging_error;

import java.io.IOException;

import javax.swing.JOptionPane;

public interface LoggingErrorAndShowingMessage extends LoggingError {

	public default void logErrorAndShowMessage(IOException ex, String message) {
		logError(ex, message);
		JOptionPane.showMessageDialog(null, message);
	}

}
