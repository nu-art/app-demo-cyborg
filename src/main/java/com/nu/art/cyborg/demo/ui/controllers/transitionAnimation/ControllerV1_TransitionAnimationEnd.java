/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.transitionAnimation;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;

/**
 * Created by TacB0sS on 14-Jul 2015.
 */
public class ControllerV1_TransitionAnimationEnd
	extends CyborgController {

	@ViewIdentifier(viewId = R.id.imageView,
	                listeners = ViewListener.OnClick)
	private ImageView image;

	@ViewIdentifier(viewId = R.id.textView4,
	                listeners = ViewListener.OnClick)
	private TextView text;

	@ViewIdentifier(viewId = R.id.ratingBar,
	                listeners = ViewListener.OnClick)
	private RatingBar ratingBar;

	public ControllerV1_TransitionAnimationEnd() {
		super(R.layout.controller__transition_animation_end_example);
	}

	public RatingBar getRatingBar() {
		return ratingBar;
	}

	public TextView getText() {
		return text;
	}

	public ImageView getImage() {
		return image;
	}
}
