/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.servicesTypeHandling;

import android.content.Intent;

import com.nu.art.cyborg.core.CyborgServiceBase;

/**
 * Created by TacB0sS on 18-May 2016.
 */
public abstract class ReportingService
	extends CyborgServiceBase {

	@Override
	public void onCreate() {
		super.onCreate();
		getModule(ServicesModule.class).onServiceCreated(this);
	}

	@Override
	public void onDestroy() {
		getModule(ServicesModule.class).onServiceDestroyed(this);
		super.onDestroy();
	}

	@Override
	protected void onBindImpl(Intent intent) {
		getModule(ServicesModule.class).onServiceBinded(this);
		super.onBindImpl(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		getModule(ServicesModule.class).onServiceBinded(this);
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		getModule(ServicesModule.class).onServiceUnbind(this);
		return true; // ensures onRebind is called
	}
}
