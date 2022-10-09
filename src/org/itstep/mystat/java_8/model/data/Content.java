package org.itstep.mystat.java_8.model.data;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.itstep.mystat.java_8.my_interface.Converted;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;

public class Content implements LoggingErrorAndShowingMessage {

	private String contentFolder;

	public Content(String contentFolder) {
		this.contentFolder = contentFolder;
	}

	public String getContentFolder() {
		return contentFolder;
	}

	public void setContentFolder(String contentFolder) {
		this.contentFolder = contentFolder;
	}

	public List<Partition> getPartitions() {
		Converted<List<File>, List<Partition>> converter = from -> {
			try {
				return Converted.convertFilesToPartitions(from);
			} catch (IOException e) {
				logErrorAndShowMessage(e,
						"Справочник: Ошибка при загрузке исходного содержимого\n( " + e.getMessage() + " )");
				return null;
			}
		};
		return converter.convert(
				Arrays.asList(new File(contentFolder + "/Partitions.txt"), new File(contentFolder + "/Topics.txt"),
						new File(contentFolder + "/Questions.txt"), new File(contentFolder + "/Answers.txt")));

	}

}
