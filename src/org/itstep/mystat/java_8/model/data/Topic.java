package org.itstep.mystat.java_8.model.data;

import java.util.Map;

import org.itstep.mystat.java_8.exception.correct_data_missing_exception.QuestionIsNullException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.QuestionsIsNullException;

public class Topic extends Level {

	private Map<String, Question> questions;

	public Topic(String number, String title, Map<String, Question> questions) {
		super(number, title);
		this.questions = questions;
	}

	public Map<String, Question> getQuestions() throws QuestionsIsNullException, QuestionIsNullException {
		checkFieldForCorrectness();
		return questions;
	}

	public void setQuestions(Map<String, Question> questions) {
		this.questions = questions;
	}

	@Override
	public void checkFieldForCorrectness() throws QuestionsIsNullException, QuestionIsNullException {
		int partitionNumber = Integer.valueOf(getNumber().split("[.]")[0]);
		int topicNumber = Integer.valueOf(getNumber().split("[.]")[1]);
		if (questions == null) {
			logErrorAndThrowIt(new QuestionsIsNullException(partitionNumber, topicNumber));
		}
		questions.forEach((number, question) -> {
			if (question == null) {
				int questionNumber = Integer.valueOf(number.split("[.]")[2]);
				logErrorAndThrowIt(new QuestionIsNullException(partitionNumber, topicNumber, questionNumber));
			}
		});
	}
}
