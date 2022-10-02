package org.itstep.mystat.java_8.controller.base_window_component_controller.admin_tab;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.controller.base_window_component_controller.BaseWindowComponentController;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class SaveContentAndLogoButnActionListener extends BaseWindowComponentController
		implements LoggingErrorAndShowingMessage {

	private volatile boolean isReferenceBookSaved;
	private volatile File folderForContentAndLogo;

	public SaveContentAndLogoButnActionListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MySaveDialogFileChooser mySaveDialogFileChooser = new MySaveDialogFileChooser();
		if (mySaveDialogFileChooser.result != MySaveDialogFileChooser.APPROVE_OPTION) {
			return;
		}
		File selectedFolder = mySaveDialogFileChooser.getSelectedFile();
		if (!selectedFolder.exists()) {
			JOptionPane.showMessageDialog(null, "Справочник: Ошибка при выборе папки");
			return;
		}
		String referenceBookTitle = JOptionPane.showInputDialog("Название справочника?");
		if (referenceBookTitle == null) {
			return;
		}
		if (referenceBookTitle.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Справочник: Ошибка в названии");
			return;
		}
		folderForContentAndLogo = new File(selectedFolder + "/" + referenceBookTitle.trim());
		if (!folderForContentAndLogo.mkdir()) {
			JOptionPane.showMessageDialog(null, "Справочник: Ошибка при создании папки " + folderForContentAndLogo);
			return;
		}
		isReferenceBookSaved = true;
		ThreadForSavingContent threadForSavingContent = new ThreadForSavingContent(folderForContentAndLogo);
		threadForSavingContent.start();
		ThreadForSavingLogo threadForSavingLogo = new ThreadForSavingLogo(folderForContentAndLogo);
		threadForSavingLogo.start();
		try {
			threadForSavingContent.join();
			threadForSavingLogo.join();
		} catch (InterruptedException e1) {
			Thread.currentThread().interrupt();
		}
		if (isReferenceBookSaved) {
			JOptionPane.showMessageDialog(null, "Справочник: Меня сохранили в папку\n" + folderForContentAndLogo);
		}
	}

	private class MySaveDialogFileChooser extends JFileChooser {

		private static final long serialVersionUID = 587916536125408765L;

		private int result;

		public MySaveDialogFileChooser() {
			setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			setDialogTitle("Куда сохранить?");
			result = showSaveDialog(null);
		}

	}

	private void saveContent(File folderForContentAndLogo) {
		File contentFolder = new File(folderForContentAndLogo + "/Content");
		contentFolder.mkdir();
		File partitions = new File(contentFolder + "/Partitions.txt");
		File topics = new File(contentFolder + "/Topics.txt");
		File questions = new File(contentFolder + "/Questions.txt");
		File answers = new File(contentFolder + "/Answers.txt");
		try {
			partitions.createNewFile();
			topics.createNewFile();
			questions.createNewFile();
			answers.createNewFile();
			BufferedWriter partitionsWriter = new BufferedWriter(new FileWriter(partitions, false));
			BufferedWriter topicsWriter = new BufferedWriter(new FileWriter(topics, false));
			BufferedWriter questionsWriter = new BufferedWriter(new FileWriter(questions, false));
			BufferedWriter answersWriter = new BufferedWriter(new FileWriter(answers, false));
			baseWindow.getDatabaseController().getDatabase().getPartitions().forEach(partition -> {
				try {
					partitionsWriter.write(partition.getTitle() + System.lineSeparator());
					partition.getTopics().forEach(topic -> {
						try {
							topicsWriter.write(topic.getTitle() + System.lineSeparator());
							topic.getQuestions().values().forEach(question -> {
								try {
									questionsWriter.write(question.getTitle() + System.lineSeparator());
									answersWriter.write(question.getAnswer() + System.lineSeparator());
								} catch (IOException e1) {
									handleError(e1);
								}
							});
							questionsWriter.write(System.lineSeparator());
							answersWriter.write(System.lineSeparator());
						} catch (IOException e1) {
							handleError(e1);
						}
					});
					topicsWriter.write(System.lineSeparator());
					questionsWriter.write(System.lineSeparator());
					answersWriter.write(System.lineSeparator());
				} catch (IOException e1) {
					handleError(e1);
				}
			});
			partitionsWriter.close();
			topicsWriter.close();
			questionsWriter.close();
			answersWriter.close();
		} catch (IOException e1) {
			handleError(e1);
		}
	}

	private void saveLogo(File folderForContentAndLogo) {
		ImageIcon imageIcon = (ImageIcon) baseWindow.getLogoLabel().getIcon();
		BufferedImage bufferedImage = (BufferedImage) imageIcon.getImage();
		try {
			ImageIO.write(bufferedImage, "jpg", new File(folderForContentAndLogo + "/Logo.jpg"));

		} catch (IOException e1) {
			handleError(e1);
		}

	}

	private synchronized void handleError(IOException e1) {
		logErrorAndShowMessage(e1, "Справочник: Ошибка при сохранении\n( " + e1.getMessage() + " )");
		if (isReferenceBookSaved) {
			isReferenceBookSaved = false;
		}
	}

	private class ThreadForSavingContent extends Thread {

		private File folderForContentAndLogo;

		public ThreadForSavingContent(File folderForContentAndLogo) {
			this.folderForContentAndLogo = folderForContentAndLogo;
		}

		@Override
		public void run() {
			saveContent(folderForContentAndLogo);
		}
	}

	private class ThreadForSavingLogo extends Thread {

		private File folderForContentAndLogo;

		public ThreadForSavingLogo(File folderForContentAndLogo) {
			this.folderForContentAndLogo = folderForContentAndLogo;
		}

		@Override
		public void run() {
			saveLogo(folderForContentAndLogo);
		}
	}

}
