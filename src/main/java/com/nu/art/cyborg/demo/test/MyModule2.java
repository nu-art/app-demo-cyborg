package com.nu.art.cyborg.demo.test;

import javax.inject.Inject;

public class MyModule2
	extends ParentModule {

	@Inject
	MyModule2() {
	}

	public void init() {
		logInfo("INIT");
	}

	public void print() {
		logInfo("ZEVEL");
	}
}
