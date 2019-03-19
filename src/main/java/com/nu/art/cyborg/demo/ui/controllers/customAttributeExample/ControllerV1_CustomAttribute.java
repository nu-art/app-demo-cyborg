/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.customAttributeExample;

import android.widget.TextView;

import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;
import com.nu.art.reflection.annotations.ReflectiveInitialization;

@ReflectiveInitialization
public class ControllerV1_CustomAttribute
	extends CyborgController
	implements AttributeSetterV1_CustomValueInterface {

	@ViewIdentifier(viewId = R.id.AttributeValue)
	TextView attributeValue;

	ControllerV1_CustomAttribute() {
		super(R.layout.v1_controller__custom_attribute);
	}

	@Override
	public final void setAttributeValue(String value) {
		attributeValue.setText(value);
	}
}
