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

import com.nu.art.belog.BeLogged;
import com.nu.art.belog.LoggerClient;
import com.nu.art.belog.loggers.FileLogger;
import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class Controller_FileLogger
	extends CyborgController {

	private static int Counter = 0;

	@ViewIdentifier(viewId = R.id.TV_PrintLog,
	                listeners = {ViewListener.OnClick})
	private TextView printLog;

	@ViewIdentifier(viewId = R.id.TV_Rotate,
	                listeners = {ViewListener.OnClick})
	private TextView rotate;

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
		}
	}
}
