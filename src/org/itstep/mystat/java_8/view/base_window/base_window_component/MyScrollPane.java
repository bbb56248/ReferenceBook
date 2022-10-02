package org.itstep.mystat.java_8.view.base_window.base_window_component;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane {

	private static final long serialVersionUID = 1025792903588066569L;

	public MyScrollPane(Component view) {
		super(view, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
		setPreferredSize(new Dimension(300, 570));
	}

}
