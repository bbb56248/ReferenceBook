package org.itstep.mystat.java_8.exception;

public class CreateMyTreeException extends RuntimeException {

	private static final long serialVersionUID = 8258788757360098963L;

	private static final String MESSAGE = "Справочник: Ошибка при создании дерева";

	public CreateMyTreeException(String message) {
		super(MESSAGE + "\n\t( " + message + " )");
	}

}
