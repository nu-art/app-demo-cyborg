/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: adam.vdk@nu-art-software.com
 */

package com.nu.art.cyborg.demo.ui.controllers;

import com.nu.art.android.views.RoundedImageView;
import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class ControllerV1_RoundedImage
	extends CyborgController {

	@ViewIdentifier(viewId = R.id.IV_RoundedImageView)
	private RoundedImageView imageView;

	public ControllerV1_RoundedImage() {
		super(R.layout.controller__rounded_image_view);
	}
}
