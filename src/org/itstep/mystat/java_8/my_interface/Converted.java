package org.itstep.mystat.java_8.my_interface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.itstep.mystat.java_8.model.data.Partition;
import org.itstep.mystat.java_8.model.data.Question;
import org.itstep.mystat.java_8.model.data.Topic;

@FunctionalInterface
public interface Converted<F, T> {

	public abstract T convert(F from);

	public static String convertIntegersToString(List<Integer> integers) {
		StringBuffer stringBuffer = new StringBuffer();
		integers.forEach(integer -> stringBuffer.append(integer + "."));
		return stringBuffer.toString();
	}

	public static List<Partition> convertFilesToPartitions(List<File> files) throws IOException {
		List<String> partitionTitles = createDataFromFile(files.get(0));
		List<String> topicTitles = createDataFromFile(files.get(1));
		List<String> questionTitles = createDataFromFile(files.get(2));
		List<String> answerTitles = createDataFromFile(files.get(3));
		List<Partition> partitions = new ArrayList<>();
		List<Topic> topics;
		Map<String, Question> questions;
		String number;
		for (int i = 1; i <= partitionTitles.size(); i++) {
			topics = new ArrayList<>();
			for (int j = 1; j <= topicTitles.size(); j++) {
				questions = new LinkedHashMap<>();
				for (int k = 1; k <= questionTitles.size(); k++) {
					if (!questionTitles.get(k - 1).isEmpty()) {
						number = convertIntegersToString(Arrays.asList(i, j, k));
						questions.put(number, new Question(number, questionTitles.get(k - 1), answerTitles.get(k - 1)));
					} else {
						questionTitles.subList(0, questions.size() + 1).clear();
						answerTitles.subList(0, questions.size() + 1).clear();
						break;
					}
				}
				if (!topicTitles.get(j - 1).isEmpty()) {
					number = convertIntegersToString(Arrays.asList(i, j));
					topics.add(new Topic(number, topicTitles.get(j - 1), questions));
				} else {
					topicTitles.subList(0, topics.size() + 1).clear();
					break;
				}
			}
			number = convertIntegersToString(Arrays.asList(i));
			partitions.add(new Partition(number, partitionTitles.get(i - 1), topics));
		}
		return partitions;
	}

	static List<String> createDataFromFile(File file) throws IOException {
		List<String> data = new ArrayList<>(
				Files.newBufferedReader(file.toPath()).lines().collect(Collectors.toList()));
//		Удаление пустых строк вначале и в конце списка
		while (data.get(0).length() < 2) {
			data.remove(0);
		}
		int lastIndex = data.size() - 1;
		while (data.get(lastIndex).isEmpty()) {
			data.remove(lastIndex);
			lastIndex = data.size() - 1;
		}
		return data;
	}

}
