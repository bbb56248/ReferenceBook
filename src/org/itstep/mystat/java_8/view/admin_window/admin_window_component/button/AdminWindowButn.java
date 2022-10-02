package org.itstep.mystat.java_8.view.admin_window.admin_window_component.button;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public abstract class AdminWindowButn extends JButton {

	private static final long serialVersionUID = -2726141776811720373L;

	public AdminWindowButn(String text) {
		super(text);
		setFont(new Font(getFont().getName(), Font.PLAIN, 20));
		setPreferredSize(new Dimension(235, 50));
	}

}
