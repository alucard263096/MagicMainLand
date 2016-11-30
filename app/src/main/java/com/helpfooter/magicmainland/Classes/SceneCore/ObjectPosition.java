package com.helpfooter.magicmainland.Classes.SceneCore;

import java.util.Random;

import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Canvas;
import com.helpfooter.magicmainland.Classes.PersonExtends.GameObject;

public class ObjectPosition {
	GameObject obj;
	public int x;
	public int y;
	public int subMoveX=0;
	public int subMoveY=0;
	public ObjectPosition(GameObject obj,int x,int y){
		this.obj=obj;
		this.x=x;
		this.y=y;
	}
	public void Draw(Canvas canvas, int heroX, int heroY,int moveX,int moveY) {
		// TODO Auto-generated method stub
		int centerX=GameConfig.SCREENWIDTH/2;
		int centerY=GameConfig.SCREENHEIGHT/2;
		
		
		obj.drawImage(canvas,
				(x-heroX)*GameConfig.OBJECTBITSIZE+ centerX-GameConfig.OBJECTBITSIZE/2+(subMoveX-moveX),
				(y-heroY)*GameConfig.OBJECTBITSIZE+ centerY-GameConfig.OBJECTBITSIZE+(subMoveY-moveY), null);
		
	}
}
