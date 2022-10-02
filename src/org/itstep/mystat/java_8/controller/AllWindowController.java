package org.itstep.mystat.java_8.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.itstep.mystat.java_8.view.admin_window.AdminWindow;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class AllWindowController {

	private BaseWindow baseWindow;
	private AdminWindow adminWindow;

	public AllWindowController(BaseWindow baseWindow, AdminWindow adminWindow) {
		this.baseWindow = baseWindow;
		this.baseWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				getBaseWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				int pick = JOptionPane.showConfirmDialog(null, "Закрыть программу?", "Message",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				if (pick == 1) {
					getBaseWindow().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		this.adminWindow = adminWindow;
		this.adminWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				getAdminWindow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				int pick = JOptionPane.showConfirmDialog(null, "Закрыть окно?", "Message", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null);
				if (pick == 0) {
					JOptionPane.showMessageDialog(null, "Вы не вошли как Администратор");
					getBaseWindow().getMyTabbedPane().setSelectedIndex(0);
				} else {
					getAdminWindow().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	public BaseWindow getBaseWindow() {
		return baseWindow;
	}

	public void setBaseWindow(BaseWindow baseWindow) {
		this.baseWindow = baseWindow;
	}

	public AdminWindow getAdminWindow() {
		return adminWindow;
	}

	public void setAdminWindow(AdminWindow adminWindow) {
		this.adminWindow = adminWindow;
	}

}
