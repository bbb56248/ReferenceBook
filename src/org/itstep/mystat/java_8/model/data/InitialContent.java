package org.itstep.mystat.java_8.model.data;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.itstep.mystat.java_8.my_interface.Converted;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;

public class InitialContent implements LoggingErrorAndShowingMessage {

	private List<Partition> partitions = new ArrayList<>();

	public InitialContent() {
		File partitions = new File("ReferenceBooks/JAVA/Content/Partitions.txt");
		File topics = new File("ReferenceBooks/JAVA/Content/Topics.txt");
		File questions = new File("ReferenceBooks/JAVA/Content/Questions.txt");
		File answers = new File("ReferenceBooks/JAVA/Content/Answers.txt");
		Converted<List<File>, List<Partition>> converter = from -> {
			try {
				return Converted.convertFilesToPartitions(from);
			} catch (IOException e) {
				logErrorAndShowMessage(e,
						"Справочник: Ошибка при загрузке исходного содержимого\n( " + e.getMessage() + " )");
				return null;
			}
		};
		this.partitions = converter.convert(Arrays.asList(partitions, topics, questions, answers));
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

}
