package org.catrobat.paintroid.command.implementation.layer;

import org.catrobat.paintroid.PaintroidApplication;
import org.catrobat.paintroid.command.implementation.BaseCommand;
import org.catrobat.paintroid.dialog.layerchooser.LayerRow;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class HideLayerCommand extends BaseCommand {
	public int layerIndex;
	public LayerRow data;

	@Override
	public void run(Canvas canvas, Bitmap bitmap) {
		setChanged();
		notifyStatus(NOTIFY_STATES.COMMAND_STARTED);

		PaintroidApplication.commandManager.getCommandListByIndex(layerIndex)
				.setHidden(true);

		setChanged();
		notifyStatus(NOTIFY_STATES.COMMAND_DONE);
	}

	public HideLayerCommand(int layerIndex) {
		this.layerIndex = layerIndex;
	}
}