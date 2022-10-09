package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.button.admin_tab;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.BaseWindowComponentController;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab.SaveContentAndLogoButn;

public class DownloadLogoButnActionListener extends BaseWindowComponentController
		implements LoggingErrorAndShowingMessage {

	public DownloadLogoButnActionListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyOpenDialogFileChooser myOpenDialogFileChooser = new MyOpenDialogFileChooser();
		if (myOpenDialogFileChooser.result != MyOpenDialogFileChooser.APPROVE_OPTION) {
			return;
		}
		File selectedFile = myOpenDialogFileChooser.getSelectedFile();
		if (!selectedFile.exists()) {
			JOptionPane.showMessageDialog(null, "Справочник: Ошибка при выборе файла");
			return;
		}
		try {
			BufferedImage bufferedImage = ImageIO.read(selectedFile);
			BufferedImage newBufferedImage = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);
			newBufferedImage.getGraphics().drawImage(bufferedImage, 0, 0, 80, 80, null);
			baseWindow.getLogoLabel().setIcon(new ImageIcon(newBufferedImage));
			((SaveContentAndLogoButn) baseWindow.getSaveContentAndLogoButn()).updateStatus(baseWindow);
			JOptionPane.showMessageDialog(null, "Справочник: Логотип загружен");
		} catch (IOException e1) {
			logErrorAndShowMessage(e1, "Справочник: Ошибка при загрузке логотипа\n( " + e1.getMessage() + " )");
		}
	}

	private class MyOpenDialogFileChooser extends JFileChooser {

		private static final long serialVersionUID = 6407987794847231979L;

		private int result;

		public MyOpenDialogFileChooser() {
			setFileSelectionMode(JFileChooser.FILES_ONLY);
			setAcceptAllFileFilterUsed(false);
			setFileFilter(new FileNameExtensionFilter("jpg", "jpg"));
			setDialogTitle("Выбор файла для логотипа");
			result = showOpenDialog(null);
		}
	}

}
