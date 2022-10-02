package org.itstep.mystat.java_8.view.base_window.base_window_component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public abstract class BaseWindowButn extends JButton {

	private static final long serialVersionUID = 1023967302830111266L;

	public BaseWindowButn(String text) {
		super(text);
		setFont(new Font(getFont().getName(), Font.PLAIN, 18));
		setPreferredSize(new Dimension(200, 120));
	}

}
