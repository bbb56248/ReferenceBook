package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class QuestionIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = 1129400117604434458L;

	private static final String MESSAGE_PART_1 = "База данных: Раздел №";
	private static final String MESSAGE_PART_2 = ": Тема №";
	private static final String MESSAGE_PART_3 = ": Вопрос №";
	private static final String MESSAGE_PART_4 = " = null";

	public QuestionIsNullException(int partitionNumber, int topicNumber, int questionNumber) {
		super(MESSAGE_PART_1 + partitionNumber + MESSAGE_PART_2 + topicNumber + MESSAGE_PART_3 + questionNumber
				+ MESSAGE_PART_4);
	}

}
