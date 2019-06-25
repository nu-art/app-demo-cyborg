/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers;

import android.view.View;
import android.widget.TextView;

import com.nu.art.belog.BeConfig;
import com.nu.art.belog.BeLogged;
import com.nu.art.belog.LoggerClient;
import com.nu.art.belog.loggers.FileLogger;
import com.nu.art.core.exceptions.runtime.BadImplementationException;
import com.nu.art.core.interfaces.Getter;
import com.nu.art.core.tools.StreamTools;
import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;

import java.io.IOException;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class Controller_FileLogger
	extends CyborgController {

	private static int Counter = 0;

	@ViewIdentifier(viewId = {
		R.id.TV_PrintLog,
		R.id.TV_LoadNewConfig,
		R.id.TV_Rotate
	},
	                listeners = {ViewListener.OnClick})
	private TextView[] clickable;

	public Controller_FileLogger() {
		super(R.layout.controller__file_logger);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.TV_PrintLog:
				logInfo("This is a log line " + (Counter++));
				break;

			case R.id.TV_Rotate:
				LoggerClient logger = BeLogged.getInstance().getClient("test-file-logger");
				((FileLogger) logger).rotate();
				break;

			case R.id.TV_LoadNewConfig:
				try {
					BeLogged beLogged = BeLogged.getInstance();
					beLogged.addConfigParam("appName", "cyborg-demo-app");
					String configAsString = StreamTools.readFullyAsString(getResources().openRawResource(R.raw.log_config_simple));
					beLogged.setConfig(configAsString);
				} catch (IOException e) {
					throw new BadImplementationException("Unable to deserialize log config");
				}
				break;
		}
	}
}
