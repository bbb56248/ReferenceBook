package org.itstep.mystat.java_8.model.admin;

public abstract class Singleton<T> {

	private static final Object OBJECT = new Object();

	public Singleton() {
		getInstance();
	}

	private T getInstance() {
		return (T) OBJECT;
	}

}
