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

import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;
import com.nu.art.cyborg.modules.InternetConnectivityModule;
import com.nu.art.cyborg.modules.InternetConnectivityModule.InternetConnectivityListener;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class ControllerV1_InternetConnection
	extends CyborgController
	implements InternetConnectivityListener {

	@ViewIdentifier(viewId = R.id.TV_Result,
	                listeners = ViewListener.OnClick)
	private TextView results;

	public ControllerV1_InternetConnection() {
		super(R.layout.controller__internet_connectivity);
	}

	@Override
	protected void onCreate() {
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		renderUI();
	}

	@Override
	protected void onResume() {
		renderUI();
	}

	@Override
	public void onInternetConnectivityChanged() {
		renderUI();
	}

	@Override
	protected void render() {
		super.render();
		results.setText((getModule(InternetConnectivityModule.class).isConnected() ? "HAS" : "NO") + " INTERNET");
	}
}
