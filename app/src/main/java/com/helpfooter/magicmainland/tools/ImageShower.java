package com.helpfooter.magicmainland.tools;

import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class ImageShower {
	Bitmap bitmap;
	public int width;
	public int height;
	public int positionx;
	public int positiony;
	
	
	public ImageShower(Bitmap bitmap,int positionx,int positiony,int width,int height){
		this.bitmap=bitmap;
		this.positionx=positionx;
		this.positiony=positiony;
		this.width=width;
		this.height=height;
	}
	
	public void Draw(Canvas canvas,int x,int y, Paint p){
		
		Rect src = new Rect();// ͼƬ
		src.left =positionx*GameConfig.OBJECTBITSIZE;// imageStartX*GameConfig.BITSIZE;
		src.top = positiony*GameConfig.OBJECTBITSIZE;
		src.right = (positionx+width)*GameConfig.OBJECTBITSIZE;
		src.bottom = (positiony+height)*GameConfig.OBJECTBITSIZE;
		//Log.d("mecg", String.valueOf(src.left)+":"+String.valueOf(src.top)+":"+String.valueOf(src.right)+":"+String.valueOf(src.bottom));

		Rect dst = new Rect();// ��Ļ
		dst.left = (int)x;
		dst.top = (int)y;
		dst.right = (int)x + width*GameConfig.OBJECTBITSIZE;
		dst.bottom = (int)y + height*GameConfig.OBJECTBITSIZE;
		
		canvas.drawBitmap(bitmap, src, dst, p);
	}
}
