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
import android.os.Environment;

import com.nu.art.belog.BeLogged;
import com.nu.art.cyborg.core.CyborgBuilder;
import com.nu.art.cyborg.core.CyborgBuilder.CyborgConfiguration;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.core.CyborgStackController;
import com.nu.art.cyborg.core.abs._DebugFlags;
import com.nu.art.cyborg.core.modules.AndroidLogger;
import com.nu.art.cyborg.demo.model.MyModulePack;

import java.io.File;

import static com.nu.art.belog.loggers.FileLogger.Config_FastFileLogger;
import static com.nu.art.belog.loggers.FileLogger.LogConfig_FileLogger;

public class CyborgDemoApplication
	extends Application {

	@Override
	@SuppressWarnings("unchecked")
	public void onCreate() {
		super.onCreate();
		CyborgStackController.DebugFlag.enable();
		CyborgController.DebugFlag.enable();
		_DebugFlags.Debug_Performance.enable();

		File logFolder = new File(Environment.getExternalStorageDirectory() + "/Downloads/cyborg-logs");
		LogConfig_FileLogger.setFolder(logFolder).setFileName("log-file");

		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this).setLaunchConfiguration(R.layout.v1_activity__injection_example));
		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this).setLaunchConfiguration(R.layout.v1_activity__matrix_tester_example, MyModulePack.class));
		//		CyborgBuilder.startCyborg(new CyborgConfiguration(this).setLaunchConfiguration(R.layout.v1_activity__dynamic_controllers_stack_example, MyModulePack.class));
		CyborgConfiguration configuration = new CyborgConfiguration(this).setLaunchConfiguration(R.layout.v1_activity__examples_selection)
		                                                                 .setModulesPacks(MyModulePack.class)
		                                                                 .setLogConfig(AndroidLogger.Config_FastAndroidLogger.merge(Config_FastFileLogger));
		CyborgBuilder.startCyborg(configuration);
	}
}
