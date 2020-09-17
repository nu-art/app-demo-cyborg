package com.nu.art.cyborg.demo.test;

import javax.inject.Inject;

public class MyClass {

	@Inject
	MyModule1 module1;

	@Inject
	MyModule2 module2;

	@Inject
	MyClass() {
	}

	public void init() {
		module1.init();
		module2.init();
	}
}
