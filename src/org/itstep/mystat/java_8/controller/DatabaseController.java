package org.itstep.mystat.java_8.controller;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.DatabaseIsNullException;
import org.itstep.mystat.java_8.model.data.Database;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndThrowingIt;

public class DatabaseController implements LoggingErrorAndThrowingIt {

	private Database database;

	public DatabaseController(Database database) {
		this.database = database;
	}

	public Database getDatabase() throws DatabaseIsNullException{
		checkDatabaseForNull();
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public String[] getQuestionTitleAndAnswer(Integer[] indexesSelectedQuestion) {
		return getDatabase().getQuestionTitleAndAnswer(indexesSelectedQuestion);
	}

	public void checkDatabaseForNull() throws DatabaseIsNullException {
		if (database == null) {
			logErrorAndThrowIt(new DatabaseIsNullException());
		}
	}

}
