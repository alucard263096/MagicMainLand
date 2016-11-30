package com.helpfooter.magicmainland.Classes.GameLoadObject;

import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class Banner extends AbstractGameLoadObject {

	private Bitmap bmBanner;

	public Banner(long showTime,Bitmap bmBanner) {
		super(showTime);
		// TODO Auto-generated constructor stub
		this.bmBanner=bmBanner;
	}
	
	public void doDraw(Canvas canvas,long runtime){

		Rect rectF = new Rect(0, 0,GameConfig.SCREENWIDTH,GameConfig.SCREENHEIGHT);   //w��h�ֱ�����Ļ�Ŀ�͸ߣ�Ҳ����������ͼƬ��ʾ�Ŀ�͸�  
		if(bmBanner==null){
			Log.d("b1", "b1");
		}
		canvas.drawBitmap(bmBanner, null, rectF, null); 
		super.doDraw(canvas, runtime);
	}

}
