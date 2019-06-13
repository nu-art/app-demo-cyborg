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

import com.nu.art.belog.BeConfig;
import com.nu.art.belog.BeLogged;
import com.nu.art.core.exceptions.runtime.BadImplementationException;
import com.nu.art.core.interfaces.Getter;
import com.nu.art.core.tools.StreamTools;
import com.nu.art.cyborg.core.CyborgBuilder;
import com.nu.art.cyborg.core.CyborgBuilder.CyborgConfiguration;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.core.CyborgStackController;
import com.nu.art.cyborg.core.abs._DebugFlags;
import com.nu.art.cyborg.core.loggers.AndroidLogger;
import com.nu.art.cyborg.demo.model.MyModulePack;

import java.io.File;
import java.io.IOException;

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

		Getter<BeConfig> logConfigLoader = new Getter<BeConfig>() {
			@Override
			public BeConfig get() {
				try {
					String configAsString = StreamTools.readFullyAsString(getResources().openRawResource(R.raw.log_config));
					return (BeConfig) BeLogged.getInstance().getSerializer().deserialize(configAsString, BeConfig.class);
				} catch (IOException e) {
					throw new BadImplementationException("Unable to deserialize log config");
				}
			}
		};

		CyborgBuilder.startCyborg(new CyborgConfiguration(this)
			                          .setLaunchConfiguration(R.layout.v1_activity__examples_selection)
			                          .setModulesPacks(MyModulePack.class)
			                          .setLogConfig(logConfigLoader));
	}
}
