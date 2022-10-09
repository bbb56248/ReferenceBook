package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.TreeSelectionModel;

import org.itstep.mystat.java_8.my_enum.User;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class MyTabbedPaneChangeListener extends BaseWindowComponentController {

	public MyTabbedPaneChangeListener(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int selectedIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();
		String selectedTitle = ((JTabbedPane) e.getSource()).getTitleAt(selectedIndex);
		baseWindow.getMyTree().getSelectionModel().setSelectionPaths(null);
		if (selectedTitle.equals(User.Администратор.name())) {
			baseWindow.getMyTree().getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			baseWindow.getAdminTabContainer().add(baseWindow.getMyScrollPane());
			baseWindow.getAllWindowController().getAdminWindow().getLoginField().setText("");
			baseWindow.getAllWindowController().getAdminWindow().getPasswordField().setText("");
			baseWindow.getAllWindowController().getAdminWindow().getShowOrHidePasswordCheckBox().setSelected(false);
			baseWindow.getDownloadOrUpdateCheckBox().setSelected(false);
			baseWindow.getAllWindowController().getAdminWindow().setVisible(true);
			return;
		}
		if (selectedTitle.equals(User.Студент.name())) {
			setInitialState();
			baseWindow.getMyTree().getSelectionModel()
					.setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
			baseWindow.getStudentTabContainer().add(baseWindow.getMyScrollPane());
		}
	}
}
