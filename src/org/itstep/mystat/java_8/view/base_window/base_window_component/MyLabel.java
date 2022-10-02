package org.itstep.mystat.java_8.view.base_window.base_window_component;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = -781447621386152478L;

	public MyLabel(String text) {
		super(text);
		setFont(new Font(getFont().getName(), Font.PLAIN, 14));
	}

}
