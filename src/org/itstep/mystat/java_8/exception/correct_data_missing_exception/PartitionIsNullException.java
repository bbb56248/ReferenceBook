package org.itstep.mystat.java_8.exception.correct_data_missing_exception;

public class PartitionIsNullException extends CorrectDataMissingException {

	private static final long serialVersionUID = 5537761187190222490L;

	private static final String MESSAGE_PART_1 = "База данных: Раздел №";
	private static final String MESSAGE_PART_2 = " = null";

	public PartitionIsNullException(int partitionNumber) {
		super(MESSAGE_PART_1 + partitionNumber + MESSAGE_PART_2);
	}

}
