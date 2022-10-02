package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class QuestionsIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = -5029011946044080811L;

	private static final String MESSAGE_PART_1 = "База данных: Раздел №";
	private static final String MESSAGE_PART_2 = ": Тема №";
	private static final String MESSAGE_PART_3 = ": Вопросы = null";

	public QuestionsIsNullException(int partitionNumber, int topicNumber) {
		super(MESSAGE_PART_1 + partitionNumber + MESSAGE_PART_2 + topicNumber + MESSAGE_PART_3);
	}

}
