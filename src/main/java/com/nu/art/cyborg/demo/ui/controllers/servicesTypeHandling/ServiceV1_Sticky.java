/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: adam.vdk@nu-art-software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.servicesTypeHandling;

import android.app.Application;
import android.content.Intent;

/**
 * Created by TacB0sS on 16-May 2016.
 */
public class ServiceV1_Sticky
	extends ReportingService {

	private Application application;

	public class LocalBinder
		extends BaseBinder<ServiceV1_Sticky> {

		@Override
		public ServiceV1_Sticky getService() {
			return ServiceV1_Sticky.this;
		}
	}

	@Override
	protected BaseBinder createBinder() {
		return new LocalBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		logInfo("onCreate called: " + (application == getApplication()));
		application = getApplication();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}
}
