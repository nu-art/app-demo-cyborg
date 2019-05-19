/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: Adam.Zehavi@Nu-Art-Software.com
 */

package com.nu.art.cyborg.demo.ui.controllers.examplesSelection;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nu.art.core.generics.Processor;
import com.nu.art.cyborg.annotations.ItemType;
import com.nu.art.cyborg.annotations.ViewIdentifier;
import com.nu.art.cyborg.common.consts.ViewListener;
import com.nu.art.cyborg.core.CyborgController;
import com.nu.art.cyborg.core.CyborgRecycler;
import com.nu.art.cyborg.core.ItemRenderer;
import com.nu.art.cyborg.core.stackTransitions.StackTransitions;
import com.nu.art.cyborg.core.dataModels.ListDataModel;
import com.nu.art.cyborg.demo.R;
import com.nu.art.reflection.annotations.ReflectiveInitialization;

/**
 * Created by TacB0sS on 13-Jun 2015.
 */
@SuppressWarnings("unchecked")
@ReflectiveInitialization
public class ControllerV1_ExamplesSelection
	extends CyborgController {

	@ViewIdentifier(viewId = R.id.ExampleSelectionList,
	                listeners = {ViewListener.OnRecyclerItemClicked})
	private CyborgRecycler recycler;

	private ControllerV1_ExamplesSelection() {
		super(R.layout.v1_controller__examples_selection);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		setupRecycler(recycler, new Processor<ListDataModel<Example>>() {
			@Override
			public void process(ListDataModel<Example> processor) {
				processor.add(Example.values());
			}
		}, ExampleRenderer.class);
	}

	@Override
	public void onRecyclerItemClicked(Object clickedItem, RecyclerView parentView, View view, int position) {
		Example example = (Example) clickedItem;
		createLayerBuilder().setTransitions(StackTransitions.CubeT2B).setControllerType(example.getControllerType()).build();
	}

	@ItemType(type = Example.class)
	public static class ExampleRenderer
		extends ItemRenderer<Example> {

		@ViewIdentifier(viewId = R.id.ExampleLabel)
		TextView exampleLabel;

		public ExampleRenderer() {
			super(R.layout.list_node__example);
		}

		@Override
		protected void renderItem(Example item) {
			exampleLabel.setText(item.getLabelId());
		}
	}
}
