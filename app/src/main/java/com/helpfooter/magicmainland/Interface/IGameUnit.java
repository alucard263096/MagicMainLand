package com.helpfooter.magicmainland.Interface;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.content.res.Resources;
import android.graphics.Canvas;

public interface IGameUnit {
	void doDraw(Canvas canvas);
	void getControllerInput(EnumControllerButton irButton);
	void getScreenTouch(float x,float y);
	void initialization(Resources r);
	void destory();
}
