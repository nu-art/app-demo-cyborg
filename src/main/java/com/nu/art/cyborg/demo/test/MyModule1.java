package com.nu.art.cyborg.demo.test;

import javax.inject.Inject;

public class MyModule1
	extends ParentModule {

	@Inject
	MyModule1() {
	}

	public void init() {
		logInfo("INIT");
	}

	public void print() {
		logInfo("PAH");
	}
}
