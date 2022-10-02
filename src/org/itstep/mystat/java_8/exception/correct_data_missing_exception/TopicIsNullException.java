package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class TopicIsNullException extends CorrectDataMissingException {// ???

	private static final long serialVersionUID = -1463728400184273995L;

	private static final String MESSAGE_PART_1 = "База данных: Раздел №";
	private static final String MESSAGE_PART_2 = ": Тема №";
	private static final String MESSAGE_PART_3 = " = null";

	public TopicIsNullException(int partitionNumber, int topicNumber) {
		super(MESSAGE_PART_1 + partitionNumber + MESSAGE_PART_2 + topicNumber + MESSAGE_PART_3);
	}

}
