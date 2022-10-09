package org.itstep.mystat.java_8.view.base_window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SpringLayout;

import org.itstep.mystat.java_8.controller.AllWindowController;
import org.itstep.mystat.java_8.controller.ContentController;
import org.itstep.mystat.java_8.controller.DatabaseController;
import org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller.MyTabbedPaneChangeListener;
import org.itstep.mystat.java_8.my_enum.User;
import org.itstep.mystat.java_8.my_interface.logging_error.LoggingErrorAndShowingMessage;
import org.itstep.mystat.java_8.view.base_window.base_window_component.DownloadOrUpdateCheckBox;
import org.itstep.mystat.java_8.view.base_window.base_window_component.MyLabel;
import org.itstep.mystat.java_8.view.base_window.base_window_component.MyScrollPane;
import org.itstep.mystat.java_8.view.base_window.base_window_component.MyTree;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab.DownloadContentButn;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab.DownloadLogoButn;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.admin_tab.SaveContentAndLogoButn;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.student_tab.ShowAnswerButn;
import org.itstep.mystat.java_8.view.base_window.base_window_component.button.student_tab.ShowQuestionButn;

public class BaseWindow extends JFrame implements LoggingErrorAndShowingMessage {

	private static final long serialVersionUID = 4320888157222765418L;

	private DatabaseController databaseController;
	private ContentController contentController;
	private AllWindowController allWindowController;

	private Container adminTabContainer = new Container();
	private Container studentTabContainer = new Container();

	private JTree myTree;
	private JScrollPane myScrollPane;
	private JLabel logoLabel = new JLabel();
	private JLabel questionLabel = new MyLabel("");
	private JTextArea answerTextArea = new JTextArea(10, 45);
	private JLabel questionSelectedLabel = new MyLabel("0");
	private JLabel restQuestionsLabel = new MyLabel("0");
	private JCheckBox downloadOrUpdateCheckBox;
	private JButton saveContentAndLogoButn;
	private JTabbedPane myTabbedPane = new JTabbedPane();

	public BaseWindow(DatabaseController databaseController, ContentController contentController) {
		this.databaseController = databaseController;
		this.contentController = contentController;
		createWindow();
	}

	public DatabaseController getDatabaseController() {
		return databaseController;
	}

	public void setDatabaseController(DatabaseController databaseController) {
		this.databaseController = databaseController;
	}

	public ContentController getContentController() {
		return contentController;
	}

	public void setContentController(ContentController contentController) {
		this.contentController = contentController;
	}

	public AllWindowController getAllWindowController() {
		return allWindowController;
	}

	public void setAllWindowController(AllWindowController allWindowController) {
		this.allWindowController = allWindowController;
	}

	public Container getAdminTabContainer() {
		return adminTabContainer;
	}

	public void setAdminTabContainer(Container adminTabContainer) {
		this.adminTabContainer = adminTabContainer;
	}

	public Container getStudentTabContainer() {
		return studentTabContainer;
	}

	public void setStudentTabContainer(Container studentTabContainer) {
		this.studentTabContainer = studentTabContainer;
	}

	public JTree getMyTree() {
		return myTree;
	}

	public void setMyTree(JTree myTree) {
		this.myTree = myTree;
	}

	public JScrollPane getMyScrollPane() {
		return myScrollPane;
	}

	public void setMyScrollPane(JScrollPane myScrollPane) {
		this.myScrollPane = myScrollPane;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JLabel getQuestionLabel() {
		return questionLabel;
	}

	public void setQuestionLabel(JLabel questionLabel) {
		this.questionLabel = questionLabel;
	}

	public JLabel getQuestionSelectedLabel() {
		return questionSelectedLabel;
	}

	public JTextArea getAnswerTextArea() {
		return answerTextArea;
	}

	public void setAnswerTextArea(JTextArea answerTextArea) {
		this.answerTextArea = answerTextArea;
	}

	public void setQuestionSelectedLabel(JLabel questionSelectedLabel) {
		this.questionSelectedLabel = questionSelectedLabel;
	}

	public JLabel getRestQuestionsLabel() {
		return restQuestionsLabel;
	}

	public void setRestQuestionsLabel(JLabel restQuestionsLabel) {
		this.restQuestionsLabel = restQuestionsLabel;
	}

	public JCheckBox getDownloadOrUpdateCheckBox() {
		return downloadOrUpdateCheckBox;
	}

	public void setDownloadOrUpdateCheckBox(JCheckBox downloadOrUpdateCheckBox) {
		this.downloadOrUpdateCheckBox = downloadOrUpdateCheckBox;
	}

	public JButton getSaveContentAndLogoButn() {
		return saveContentAndLogoButn;
	}

	public void setSaveContentAndLogoButn(JButton saveContentAndLogoButn) {
		this.saveContentAndLogoButn = saveContentAndLogoButn;
	}

	public JTabbedPane getMyTabbedPane() {
		return myTabbedPane;
	}

	public void setMyTabbedPane(JTabbedPane myTabbedPane) {
		this.myTabbedPane = myTabbedPane;
	}

	private void createWindow() {
		setTitle("Справочник");
		setSize(1000, 650);
		setLocationRelativeTo(null);
		setResizable(false);

		myTree = new MyTree(this);
		myScrollPane = new MyScrollPane(myTree);

		SpringLayout studentLayout = new SpringLayout();
		studentTabContainer.setLayout(studentLayout);
		studentTabContainer.add(myScrollPane);

		File file = new File("ReferenceBooks/JAVA/Java.jpg");
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			logoLabel.setIcon(new ImageIcon(bufferedImage));
		} catch (IOException e) {
			logErrorAndShowMessage(e, "Справочник: Ошибка при загрузке исходного логотипа\n( " + e.getMessage() + " )");
		}
		logoLabel.setPreferredSize(new Dimension(80, 80));
		studentLayout.putConstraint(SpringLayout.EAST, logoLabel, 0, SpringLayout.EAST, studentTabContainer);
		studentLayout.putConstraint(SpringLayout.NORTH, logoLabel, 0, SpringLayout.NORTH, studentTabContainer);
		studentTabContainer.add(logoLabel);

		JButton showQuestionButn = new ShowQuestionButn(this);
		studentLayout.putConstraint(SpringLayout.WEST, showQuestionButn, 100, SpringLayout.EAST, myScrollPane);
		studentLayout.putConstraint(SpringLayout.SOUTH, showQuestionButn, -20, SpringLayout.SOUTH, studentTabContainer);
		studentTabContainer.add(showQuestionButn);

		JButton showAnswerButn = new ShowAnswerButn(this);
		studentLayout.putConstraint(SpringLayout.WEST, showAnswerButn, 80, SpringLayout.EAST, showQuestionButn);
		studentLayout.putConstraint(SpringLayout.SOUTH, showAnswerButn, 0, SpringLayout.SOUTH, showQuestionButn);
		studentTabContainer.add(showAnswerButn);

		JLabel label1 = new MyLabel("Вопрос:");
		studentLayout.putConstraint(SpringLayout.WEST, label1, 20, SpringLayout.EAST, myScrollPane);
		studentLayout.putConstraint(SpringLayout.NORTH, label1, 100, SpringLayout.NORTH, myScrollPane);
		studentTabContainer.add(label1);
		studentLayout.putConstraint(SpringLayout.WEST, questionLabel, 20, SpringLayout.EAST, label1);
		studentLayout.putConstraint(SpringLayout.NORTH, questionLabel, 0, SpringLayout.NORTH, label1);
		studentTabContainer.add(questionLabel);

		JLabel label2 = new MyLabel("Ответ:");
		studentLayout.putConstraint(SpringLayout.WEST, label2, 0, SpringLayout.WEST, label1);
		studentLayout.putConstraint(SpringLayout.NORTH, label2, 30, SpringLayout.SOUTH, label1);
		studentTabContainer.add(label2);
		answerTextArea.setLineWrap(true);
		answerTextArea.setWrapStyleWord(true);
		answerTextArea.setEditable(false);
		answerTextArea.setFont(new Font(label2.getFont().getName(), Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(answerTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		studentLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.EAST, label2);
		studentLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, label2);
		studentTabContainer.add(scrollPane);

		JLabel label3 = new MyLabel("Выбрано вопросов:");
		studentLayout.putConstraint(SpringLayout.WEST, label3, 0, SpringLayout.WEST, label1);
		studentLayout.putConstraint(SpringLayout.NORTH, label3, 200, SpringLayout.SOUTH, label2);
		studentTabContainer.add(label3);
		studentLayout.putConstraint(SpringLayout.WEST, questionSelectedLabel, 20, SpringLayout.EAST, label3);
		studentLayout.putConstraint(SpringLayout.NORTH, questionSelectedLabel, 0, SpringLayout.NORTH, label3);
		studentTabContainer.add(questionSelectedLabel);

		JLabel label4 = new MyLabel("Осталось вопросов:");
		studentLayout.putConstraint(SpringLayout.WEST, label4, 0, SpringLayout.WEST, label1);
		studentLayout.putConstraint(SpringLayout.NORTH, label4, 20, SpringLayout.SOUTH, label3);
		studentTabContainer.add(label4);
		studentLayout.putConstraint(SpringLayout.WEST, restQuestionsLabel, 20, SpringLayout.EAST, label4);
		studentLayout.putConstraint(SpringLayout.NORTH, restQuestionsLabel, 0, SpringLayout.NORTH, label4);
		studentTabContainer.add(restQuestionsLabel);

		SpringLayout adminLayout = new SpringLayout();
		adminTabContainer.setLayout(adminLayout);

		JButton downloadContentButn = new DownloadContentButn(this);
		adminLayout.putConstraint(SpringLayout.WEST, downloadContentButn, 40, SpringLayout.EAST, myScrollPane);
		adminLayout.putConstraint(SpringLayout.NORTH, downloadContentButn, 20, SpringLayout.NORTH, adminTabContainer);
		adminTabContainer.add(downloadContentButn);

		downloadOrUpdateCheckBox = new DownloadOrUpdateCheckBox(this);
		adminLayout.putConstraint(SpringLayout.EAST, downloadOrUpdateCheckBox, -10, SpringLayout.WEST,
				downloadContentButn);
		adminLayout.putConstraint(SpringLayout.VERTICAL_CENTER, downloadOrUpdateCheckBox, 0,
				SpringLayout.VERTICAL_CENTER, downloadContentButn);
		adminTabContainer.add(downloadOrUpdateCheckBox);

		JButton downloadLogoButn = new DownloadLogoButn(this);
		adminLayout.putConstraint(SpringLayout.WEST, downloadLogoButn, 15, SpringLayout.EAST, downloadContentButn);
		adminLayout.putConstraint(SpringLayout.NORTH, downloadLogoButn, 0, SpringLayout.NORTH, downloadContentButn);
		adminTabContainer.add(downloadLogoButn);

		saveContentAndLogoButn = new SaveContentAndLogoButn(this);
		adminLayout.putConstraint(SpringLayout.WEST, saveContentAndLogoButn, 15, SpringLayout.EAST, downloadLogoButn);
		adminLayout.putConstraint(SpringLayout.NORTH, saveContentAndLogoButn, 0, SpringLayout.NORTH, downloadLogoButn);
		adminTabContainer.add(saveContentAndLogoButn);

		myTabbedPane.addChangeListener(new MyTabbedPaneChangeListener(this));
		myTabbedPane.addTab(User.Студент.name(), studentTabContainer);
		myTabbedPane.addTab(User.Администратор.name(), adminTabContainer);
		add(myTabbedPane);
	}

}
