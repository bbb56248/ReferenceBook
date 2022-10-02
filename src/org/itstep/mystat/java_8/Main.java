package org.itstep.mystat.java_8;

import org.itstep.mystat.java_8.controller.AdminController;
import org.itstep.mystat.java_8.controller.AllWindowController;
import org.itstep.mystat.java_8.controller.DatabaseController;
import org.itstep.mystat.java_8.model.admin.Admin;
import org.itstep.mystat.java_8.model.data.Database;
import org.itstep.mystat.java_8.model.data.InitialContent;
import org.itstep.mystat.java_8.view.admin_window.AdminWindow;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class Main {

	public static void main(String[] args) {

		Admin admin = new Admin();
		AdminController adminController = new AdminController(admin);
		AdminWindow adminWindow = new AdminWindow(adminController);

		Database database = new Database("0", "База данных", (new InitialContent()).getPartitions());
		DatabaseController databaseController = new DatabaseController(database);
		BaseWindow baseWindow = new BaseWindow(databaseController);

		AllWindowController allWindowController = new AllWindowController(baseWindow, adminWindow);
		adminWindow.setAllWindowController(allWindowController);
		baseWindow.setAllWindowController(allWindowController);

		baseWindow.setVisible(true);
	}

}
