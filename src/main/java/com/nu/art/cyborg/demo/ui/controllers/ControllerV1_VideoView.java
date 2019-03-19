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

import android.os.Environment;

import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.demo.R;
import com.nu.art.cyborg.demo.model.MyModule;
import com.nu.art.cyborg.media.CyborgMediaPlayer;
import com.nu.art.cyborg.ui.views.VideoView;

/**
 * Created by TacB0sS on 24-Aug 2016.
 */

public class ControllerV1_VideoView
	extends CyborgController {

	@ViewIdentifier(viewId = R.id.VV_VideoView)
	private VideoView videoView;

	public ControllerV1_VideoView() {
		super(R.layout.v1_controller__video_view);
	}

	@Override
	protected void onResume() {
		super.onResume();
		String outputFile = Environment.getExternalStorageDirectory() + "/recorded-video/1530654992676.mp4";
		CyborgMediaPlayer player = getModule(MyModule.class).createPlayer();
		player.createBuilder().setAutoPlay(true).setUri(outputFile).prepare();
		videoView.setMediaPlayer(player);
	}
}
