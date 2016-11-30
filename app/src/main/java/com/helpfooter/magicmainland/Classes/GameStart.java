package com.helpfooter.magicmainland.Classes;

import com.helpfooter.magicmainland.Common.GameCpu;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import com.helpfooter.magicmainland.Interface.IGameUnit;

public class GameStart implements IGameUnit {
	GameController gameController;
	StartMenu menu;
	
	GameCpu cpu;
	
	public GameStart(GameCpu cpu){
		this.cpu=cpu;
		gameController=GameController.getInstance();
		menu=new StartMenu(this.cpu);
		menu.showMenu();
	}
	
	@Override
	public void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		canvas.drawColor(Color.BLACK);
		gameController.setController(canvas);
		menu.draw(canvas);

	}

	@Override
	public void getControllerInput(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		menu.setOperationButton(irButton);
	}

	@Override
	public void getScreenTouch(float x, float y) {
		// TODO Auto-generated method stub
		EnumControllerButton irButton=gameController.getButton(x,y);
    	this.getControllerInput(irButton);
	}

	@Override
	public void initialization(Resources r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

}
