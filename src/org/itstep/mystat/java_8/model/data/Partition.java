package org.itstep.mystat.java_8.model.data;

import java.util.List;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.TopicIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.TopicsIsNullException;

public class Partition extends Level {

	private List<Topic> topics;

	public Partition(String number, String title, List<Topic> topics) {
		super(number, title);
		this.topics = topics;
	}

	public List<Topic> getTopics() throws TopicsIsNullException, TopicIsNullException {
		checkFieldForCorrectness();
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public void checkFieldForCorrectness() throws TopicsIsNullException, TopicIsNullException {
		int partitionNumber = Integer.valueOf(getNumber().split("[.]")[0]);
		if (topics == null) {
			logErrorAndThrowIt(new TopicsIsNullException(partitionNumber));
		}
		topics.forEach(topic -> {
			if (topic == null) {
				int topicNumber = topics.indexOf(topic) + 1;
				logErrorAndThrowIt(new TopicIsNullException(partitionNumber, topicNumber));
			}
		});
	}

}
