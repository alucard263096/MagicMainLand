package com.helpfooter.magicmainland.Classes.MapSpaceExtends;

import com.helpfooter.magicmainland.tools.ImageShower;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.helpfooter.magicmainland.Interface.IMapSpace;

public class MapSpace implements IMapSpace {

	ImageShower img;
	
	public boolean canRun=true;
	
	public MapSpace(Bitmap bitmap,int positionx,int positiony,int width,int height){
		img=new ImageShower(bitmap, positionx, positiony, width, height);
	}
	
	public void Draw(Canvas canvas,int x,int y, Paint p){
		
		img.Draw(canvas, x, y, p);
	}
	
	
	
	@Override
	public void forCheckDo() {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public boolean canPass() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public void passEvent() {
		// TODO Auto-generated method stub
	}
}
