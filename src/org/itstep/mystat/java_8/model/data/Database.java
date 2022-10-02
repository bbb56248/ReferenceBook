package org.itstep.mystat.java_8.model.data;

import java.util.Arrays;
import java.util.List;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.PartitionIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.PartitionsIsNullException;
import org.itstep.mystat.java_8.my_interface.Converted;

public class Database extends Level {

	private List<Partition> partitions;

	public Database(String number, String title, List<Partition> partitions) {
		super(number, title);
		this.partitions = partitions;
	}

	public List<Partition> getPartitions() throws PartitionsIsNullException, PartitionIsNullException {
		checkFieldForCorrectness();
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

	public String[] getQuestionTitleAndAnswer(Integer[] indexesSelectedQuestion) {
		int partitionNumber = indexesSelectedQuestion[0];
		int topicNumber = indexesSelectedQuestion[1];
		int questionNumber = indexesSelectedQuestion[2];
		Converted<List<Integer>, String> converter = Converted::convertIntegersToString;
		String key = converter.convert(Arrays.asList(partitionNumber + 1, topicNumber + 1, questionNumber + 1));
		Question question = getPartitions().get(partitionNumber).getTopics().get(topicNumber).getQuestions().get(key);
		return new String[] { question.getTitle(), question.getAnswer() };
	}

	@Override
	public void checkFieldForCorrectness() throws PartitionsIsNullException, PartitionIsNullException {
		if (partitions == null) {
			logErrorAndThrowIt(new PartitionsIsNullException());
		}
		partitions.forEach(partition -> {
			if (partition == null) {
				int partitionNumber = partitions.indexOf(partition) + 1;
				logErrorAndThrowIt(new PartitionIsNullException(partitionNumber));
			}
		});
	}

}
