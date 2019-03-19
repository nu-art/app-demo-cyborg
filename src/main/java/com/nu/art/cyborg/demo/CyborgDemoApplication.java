/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo;

import android.app.Application;

import com.nu.art.core.utils.DebugFlags;
import com.nu.art.cyborg.automation.AutomationModule;
import com.nu.art.cyborg.core.CyborgBuilder;
import com.nu.art.cyborg.core.CyborgBuilder.CyborgConfiguration;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.core.CyborgStackController;
import com.nu.art.cyborg.core.abs._DebugFlags;
import com.nu.art.cyborg.demo.model.MyModulePack;
import com.nu.art.cyborg.media.CyborgAudioRecorder;

public class CyborgDemoApplication
	extends Application {

	@Override
	@SuppressWarnings("unchecked")
	public void onCreate() {
		super.onCreate();
		CyborgStackController.DebugFlag.enable();
		CyborgController.DebugFlag.enable();
		_DebugFlags.Debug_Performance.enable();

		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this, R.layout.v1_activity__injection_example));
		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this, R.layout.v1_activity__matrix_tester_example, MyModulePack.class));
		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this, R.layout.v1_activity__dynamic_controllers_stack_example, MyModulePack.class));
		CyborgBuilder.startCyborg(new CyborgConfiguration(this, R.layout.v1_activity__examples_selection, MyModulePack.class));
	}
}
