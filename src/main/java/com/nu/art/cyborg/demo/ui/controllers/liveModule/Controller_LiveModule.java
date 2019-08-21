/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: adam.vdk@nu-art-software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.liveModule;

import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;
import com.nu.art.modular.core.HackApi;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class Controller_LiveModule
	extends CyborgController {

	static LiveModule module = new LiveModule();

	public Controller_LiveModule() {
		super(R.layout.controller__dynamic_a);
	}

	@Override
	protected void onCreate() {
		super.onCreate();
		getRootView().setBackgroundColor(getColor(R.color.white));
		HackApi.registerModuleInstance(module);
	}
}
