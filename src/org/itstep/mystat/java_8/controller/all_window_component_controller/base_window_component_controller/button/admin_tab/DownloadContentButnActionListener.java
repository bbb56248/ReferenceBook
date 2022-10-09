package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.admin_tab;

import java.awt.Component;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import org.itstep.mystat.java_8.controller.ContentController;
import org.itstep.mystat.java_8.controller.DatabaseController;
import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.BaseWindowComponentController;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.DatabaseIsNullException;
import org.itstep.mystat.java_8.model.data.Content;
import org.itstep.mystat.java_8.model.data.Database;
import org.itstep.mystat.java_8.model.data.Partition;
import org.itstep.mystat.java_8.my_interface.Converted;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.MyScrollPane;
import org.itstep.mystat.java_8.view.base_window.base_window_component.MyTree;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab.SaveContentAndLogoButn;

public class DownloadContentButnActionListener extends BaseWindowComponentController
		implements LoggingErrorAndShowingMessage {

	public DownloadContentButnActionListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File contentFolder;
		if (baseWindow.getDownloadOrUpdateCheckBox().isSelected()) {
			MyOpenDialogFolderChooser myOpenDialogFolderChooser = new MyOpenDialogFolderChooser();
			if (myOpenDialogFolderChooser.result != MyOpenDialogFolderChooser.APPROVE_OPTION) {
				return;
			}
			contentFolder = myOpenDialogFolderChooser.getSelectedFile();
			if (!contentFolder.exists()) {
				JOptionPane.showMessageDialog(null, "Справочник: Ошибка при выборе папки");
				return;
			}
		} else {
			contentFolder = new File(baseWindow.getContentController().getContent().getContentFolder());
		}
		File partitions = new File(contentFolder + "/Partitions.txt");
		File topics = new File(contentFolder + "/Topics.txt");
		File questions = new File(contentFolder + "/Questions.txt");
		File answers = new File(contentFolder + "/Answers.txt");
		Converted<List<File>, List<Partition>> converter = from -> {
			try {
				return Converted.convertFilesToPartitions(from);
			} catch (IOException e1) {
				logErrorAndShowMessage(e1, "Справочник: Ошибка при загрузке содержимого\n( " + e1.getMessage() + " )");
				return null;
			}
		};
		List<Partition> newPartitions = converter.convert(Arrays.asList(partitions, topics, questions, answers));
		if (newPartitions == null) {
			dry();
			return;
		}
		if ((new BaseWindow(new DatabaseController(new Database("1", "База данных", newPartitions)),
				new ContentController(new Content(contentFolder.getPath())))).getMyTree().getModel() == null) {
			dry();
			JOptionPane.showMessageDialog(null, "Справочник: Ошибка при загрузке содержимого");
			return;
		}
		try {
			baseWindow.getDatabaseController().getDatabase().setPartitions(newPartitions);
		} catch (DatabaseIsNullException ex) {
			baseWindow.getDatabaseController().setDatabase(new Database("0", "База данных", newPartitions));
		}
		JTree newMyTree = new MyTree(baseWindow);
		baseWindow.setMyTree(newMyTree);
		Stream<Component> components = Stream.of(baseWindow.getAdminTabContainer().getComponents());
		baseWindow.getAdminTabContainer()
				.remove(components.filter(component -> component instanceof JScrollPane).findFirst().get());
		JScrollPane newMyScrollPane = new MyScrollPane(newMyTree);
		baseWindow.setMyScrollPane(newMyScrollPane);
		baseWindow.getAdminTabContainer().add(newMyScrollPane);
		((SaveContentAndLogoButn) baseWindow.getSaveContentAndLogoButn()).updateStatus(baseWindow);
		baseWindow.getAdminTabContainer().repaint();
		if (baseWindow.getDownloadOrUpdateCheckBox().isSelected()) {
			baseWindow.getContentController().getContent().setContentFolder(contentFolder.getPath());
		}
		JOptionPane.showMessageDialog(null, "Справочник: Содержимое загружено");
	}

	private class MyOpenDialogFolderChooser extends JFileChooser {

		private static final long serialVersionUID = 1795007105370618089L;

		private int result;

		public MyOpenDialogFolderChooser() {
			setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			setDialogTitle("Из какой папки загрузить содержимое справочника?");
			result = showOpenDialog(null);
		}

	}

	private void dry() {
		if (!baseWindow.getDownloadOrUpdateCheckBox().isSelected()) {
			baseWindow.getMyTree().setModel(null);
			((SaveContentAndLogoButn) baseWindow.getSaveContentAndLogoButn()).updateStatus(baseWindow);
		}
	}

}
