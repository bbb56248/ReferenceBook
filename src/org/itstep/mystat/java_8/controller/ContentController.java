package org.itstep.mystat.java_8.controller;

import org.itstep.mystat.java_8.model.data.Content;

public class ContentController {

	private Content content;

	public ContentController(Content content) {
		this.content = content;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

}
