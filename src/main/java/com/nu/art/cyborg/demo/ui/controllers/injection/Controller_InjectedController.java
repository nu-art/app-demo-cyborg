/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.injection;

import com.nu.art.cyborg.annotations.Restorable;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;
import com.nu.art.reflection.annotations.ReflectiveInitialization;

/**
 * This example gives you a small impression of what Cyborg can do for you in terms of minimizing code and utilizing events and callbacks...
 */
@Restorable
@ReflectiveInitialization
public class Controller_InjectedController
	extends CyborgController {

	private Controller_InjectedController() {
		super(R.layout.controller__injected_controller);
	}
}
