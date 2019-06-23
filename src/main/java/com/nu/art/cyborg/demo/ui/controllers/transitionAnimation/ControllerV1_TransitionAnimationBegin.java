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

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.core.CyborgStackController.StackLayerBuilder;
import com.nu.art.cyborg.core.stackTransitions.StackTransitions;
import com.nu.art.cyborg.demo.R;

/**
 * Created by TacB0sS on 14-Jul 2015.
 */
public class ControllerV1_TransitionAnimationBegin
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

	public ControllerV1_TransitionAnimationBegin() {
		super(R.layout.controller__transition_animation_begin_example);
	}

	@Override
	public void onCreate() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void onClick(View v) {
//		FloatingViewTransitionAnimator floatingAnimation;
//		PredefinedStackTransitionAnimator transition;
//		//		LeadingViewAnimationBuilder leadingViewAnimation;
//		switch (v.getId()) {
//			case R.id.imageView:
//				floatingAnimation = new FloatingViewTransitionAnimator(R.id.imageView, R.id.imageView);
//				transition = new PredefinedStackTransitionAnimator(getActivity(), PredefinedTransitions.Slide, BaseTransition.ORIENTATION_HORIZONTAL, true);
//				break;
//
//			case R.id.textView4:
//				floatingAnimation = new FloatingViewTransitionAnimator(R.id.textView4, R.id.textView4);
//				transition = new PredefinedStackTransitionAnimator(getActivity(), PredefinedTransitions.Cube, BaseTransition.ORIENTATION_HORIZONTAL, true);
//				break;
//
//			default:
//				return;
//		}

		StackLayerBuilder layerBuilder = createLayerBuilder();
		layerBuilder.setTransitions(StackTransitions.Slide);
		layerBuilder.setTransitionDuration(1500);
		layerBuilder.setControllerType(ControllerV1_TransitionAnimationEnd.class);
		layerBuilder.build();
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
