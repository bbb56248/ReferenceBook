package org.itstep.mystat.java_8.test;

import java.util.List;

import org.itstep.mystat.java_8.controller.DatabaseController;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.DatabaseIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.PartitionIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.PartitionsIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.QuestionIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.QuestionsIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsEmptyException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.StringFieldIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.TopicIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.TopicsIsNullException;
import org.itstep.mystat.java_8.model.data.Database;
import org.itstep.mystat.java_8.model.data.InitialContent;
import org.itstep.mystat.java_8.model.data.Partition;
import org.junit.Test;

public class MyTest {

	private List<Partition> partitions = (new InitialContent()).getPartitions();
	private Database database = new Database("0", "База данных", partitions);
	private DatabaseController databaseController = new DatabaseController(database);

	@Test(expected = DatabaseIsNullException.class)
	public void databaseIsNullExceptionTest() {
		databaseController.setDatabase(null);
		databaseController.getDatabase();
	}

	@Test(expected = PartitionsIsNullException.class)
	public void partitionsIsNullExceptionTest() {
		database.setPartitions(null);
		database.getPartitions();
	}

	@Test(expected = PartitionIsNullException.class)
	public void partitionIsNullExceptionTest() {
		database.getPartitions().set(0, null);
		database.getPartitions().get(0);
	}

	@Test(expected = TopicsIsNullException.class)
	public void topicsIsNullExceptionTest() {
		partitions.get(0).setTopics(null);
		partitions.get(0).getTopics();
	}

	@Test(expected = TopicIsNullException.class)
	public void topicIsNullExceptionTest() {
		partitions.get(0).getTopics().set(0, null);
		partitions.get(0).getTopics().get(0);
	}

	@Test(expected = QuestionsIsNullException.class)
	public void questionsIsNullExceptionTest() {
		partitions.get(0).getTopics().get(0).setQuestions(null);
		partitions.get(0).getTopics().get(0).getQuestions();
	}

	@Test(expected = QuestionIsNullException.class)
	public void questionIsNullExceptionTest() {
		partitions.get(0).getTopics().get(0).getQuestions().remove("1.1.3.");
		partitions.get(0).getTopics().get(0).getQuestions().put("1.1.3.", null);
		partitions.get(0).getTopics().get(0).getQuestions().get("1.1.3.");
	}

	@Test(expected = StringFieldIsEmptyException.class)
	public void stringFieldIsEmptyExceptionTest() {
		partitions.get(0).getTopics().get(0).getQuestions().get("1.1.3.").setAnswer("");
		partitions.get(0).getTopics().get(0).getQuestions().get("1.1.3.").getAnswer();
	}

	@Test(expected = StringFieldIsNullException.class)
	public void stringFieldIsNullExceptionTest() {
		partitions.get(0).getTopics().get(0).getQuestions().get("1.1.3.").setNumber(null);
		partitions.get(0).getTopics().get(0).getQuestions().get("1.1.3.").getNumber();
	}

}
