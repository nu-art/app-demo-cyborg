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

import android.app.Service;

/**
 * Created by TacB0sS on 18-May 2016.
 */
public class ServiceDetails {

	final Class<? extends Service> serviceType;

	int created;

	int binded;

	public ServiceDetails(Class<? extends Service> serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "Created: " + created + "\nBinded: " + binded;
	}
}
