/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.model;

import com.google.auth.oauth2.GoogleCredentials;
import com.nu.art.belog.BeLogged;
import com.nu.art.belog.FileLoggerClient;
import com.nu.art.core.exceptions.runtime.BadImplementationException;
import com.nu.art.core.interfaces.Getter;
import com.nu.art.core.tools.SizeTools;
import com.nu.art.cyborg.automation.AutomationModule;
import com.nu.art.cyborg.core.CyborgBuilder;
import com.nu.art.cyborg.core.CyborgStackController;
import com.nu.art.cyborg.core.ItemRenderer;
import com.nu.art.cyborg.core.abs._DebugFlags;
import com.nu.art.cyborg.core.modules.ABTestingModule;
import com.nu.art.cyborg.demo.ui.controllers.servicesTypeHandling.ServicesModule;
import com.nu.art.cyborg.logcat.Module_LogcatViewer;
import com.nu.art.cyborg.media.CyborgAudioRecorder;
import com.nu.art.cyborg.modules.BlurModule;
import com.nu.art.cyborg.modules.ContactsModule;
import com.nu.art.cyborg.modules.FingerprintModule;
import com.nu.art.cyborg.modules.InternetConnectivityModule;
import com.nu.art.cyborg.modules.LocationModule;
import com.nu.art.cyborg.modules.apps.AppsStatusModule;
import com.nu.art.cyborg.modules.calls.NativeCallsModule;
import com.nu.art.cyborg.modules.camera.CameraModule;
import com.nu.art.cyborg.stt.STT_Google;
import com.nu.art.http.HttpModule;
import com.nu.art.modular.core.ModulesPack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TacB0sS on 18-Apr 2015.
 */
@SuppressWarnings("unchecked")
public class MyModulePack
	extends ModulesPack {

	private static final long MAX_LOG_FILE_SIZE_IN_BYTES = 4 * SizeTools.MegaByte;

	private static final int MAX_LOG_FILES = 20;

	private static final Class[] Modules = {
		InternetConnectivityModule.class,
		MyModule.class,
		BlurModule.class,
		CameraModule.class,
		AutomationModule.class,
		HttpModule.class,
		MyStorageModule.class,
		NativeCallsModule.class,
		ContactsModule.class,
		ServicesModule.class,
		FingerprintModule.class,
		CyborgAudioRecorder.class,
		ABTestingModule.class,
		LocationModule.class,
		STT_Google.class,
		AppsStatusModule.class,
		Module_LogcatViewer.class,
	};

	private MyModulePack() {
		super(Modules);
	}

	@Override
	protected void init() {
		//		ItemRenderer.DebugFlag.enable();
		//		_DebugFlags.Debug_Performance.enable();
		//		CyborgStackController.DebugFlag.enable();
		//		getModule(CyborgAudioRecorder.class).DebugFlag.enable();
		//		getModule(AutomationModule.class).DebugFlag.enable();

		FileLoggerClient logClient = new FileLoggerClient();
		logClient.set(new File(CyborgBuilder.getInstance().getApplicationContext().getFilesDir(), "logs"), "debug-log", MAX_LOG_FILE_SIZE_IN_BYTES, MAX_LOG_FILES);
		BeLogged.getInstance().addClient(logClient);

		// You can get any module declared in the constructor and PRE-CONFIGURE it before it is initialized.
		getModule(MyModule.class).addString("0");
//		getModule(STT_Google.class).setCredentialsGetter(new Getter<GoogleCredentials>() {
//			@Override
//			public GoogleCredentials get() {
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				// TODO load this from the sdcard... not to be in the sdk...!!
//				InputStream inputStream;
//				try {
//					inputStream = CyborgBuilder.getInstance().getAsset("user-credentials.json");
//				} catch (IOException e) {
//					try {
//						inputStream = CyborgBuilder.getInstance().getAsset("dummy-credentials.json");
//					} catch (IOException e1) {
//						throw new BadImplementationException("cannot resolve stt credentials", e1);
//					}
//				}
//
//				try {
//					return GoogleCredentials.fromStream(inputStream);
//				} catch (IOException e) {
//					throw new BadImplementationException("cannot resolve stt credentials", e);
//				}
//			}
//		});
		getModule(ABTestingModule.class).addRating("Demo", new float[]{
			0.2f,
			0.5f,
			0.3f
		});
	}

	@Override
	protected void postInit() {
		// You can get any module declared in the constructor and POST-CONFIGURE after it has initialized.
		getModule(MyModule.class).addString("4");
	}
}
