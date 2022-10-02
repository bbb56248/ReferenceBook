package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class TopicsIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = -6231732201837267973L;

	private static final String MESSAGE_PART_1 = "База данных: Раздел №";
	private static final String MESSAGE_PART_2 = ": Темы = null";

	public TopicsIsNullException(int partitionNumber) {
		super(MESSAGE_PART_1 + partitionNumber + MESSAGE_PART_2);
	}

}
