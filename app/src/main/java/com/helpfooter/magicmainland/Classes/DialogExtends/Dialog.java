package com.helpfooter.magicmainland.Classes.DialogExtends;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

import com.helpfooter.magicmainland.Classes.GameController;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class Dialog implements IDialog {
	
	
	
	
	DialogShowForm sd;
	DialogShowForm sdYN;
	
	
	
	int x0;
	int y0;
	int x1;
	int y1;
	
	

	String msg;
	String name;
	DialogShowForm nameSd;

	Paint paint;
	
	public Dialog(String msg,String name){
		this.msg=msg;
		this.name=name;
		Initialization();
		if(this.name!=null&&this.name.trim().length()>0){
			InitializationNameBox();
		}
	}
	
	
	private void InitializationNameBox() {
		// TODO Auto-generated method stub
		
		int nameSdX0=x0;
		int nameSdY0=y0-(int)(4* GameConfig.BUTTON_ARGIN);
		int nameSdX1=x0+20*(name.length()+1);
		int nameSdY1=nameSdY0+(int)(3*GameConfig.BUTTON_ARGIN);
		
		nameSd=new DialogShowForm();
		nameSd.setBounds(nameSdX0,nameSdY0,nameSdX1,nameSdY1);
	}


	private void InitializationOptionBox() {
		// TODO Auto-generated method stub

//		
//
//		Log.d("a1",String.valueOf( x1-40));
//		Log.d("a2",String.valueOf( y0-(int)(4*GameConfig.BUTTON_ARGIN)));
//		Log.d("a3", String.valueOf(x1));
//		Log.d("a4",String.valueOf( y0-(int)GameConfig.BUTTON_ARGIN));
		sdYN=new DialogShowForm();
		sdYN.setBounds(x1-40,y0-(int)(6*GameConfig.BUTTON_ARGIN),x1,y0-(int)GameConfig.BUTTON_ARGIN);

	}


	private void Initialization(){
 int i=0;
		
		GameController gcon=GameController.getInstance();
		
		x0=(int)(gcon.rightArrowX+GameConfig.BUTTON_SIZE+GameConfig.BUTTON_ARGIN);
		y0=GameConfig.SCREENHEIGHT-GameConfig.TALKINGDIALOGHEIGHT-(int)GameConfig.BUTTON_ARGIN;
		x1=(int)(gcon.buttonBX-GameConfig.BUTTON_ARGIN);
		y1=GameConfig.SCREENHEIGHT-(int)GameConfig.BUTTON_ARGIN;
		
		
//		Log.d("x0", String.valueOf(x0));
//		Log.d("y0", String.valueOf(y0));
//		Log.d("x1", String.valueOf(x1));
//		Log.d("y1", String.valueOf(y1));
		sd=new DialogShowForm();
		sd.setBounds(x0+3,y0+3,x1-3,y1-3);
		
		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setTextSize(18);
	}

	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		sd.draw(canvas);
		
		int textLength=msg.length();
		int rowMaxCharLength=(int)((x1-x0)/20);
		
//		Log.d("c", String.valueOf(x1-x0));
		
		
		int k=0;
		
		for(int i=0;i<textLength;i=i+rowMaxCharLength){
			int cki=i+rowMaxCharLength;
			if(cki>=textLength){
				cki=textLength;
			}
//			Log.d("d", String.valueOf(i));
//			Log.d("d", String.valueOf(cki));
			String subMsg=msg.substring(i, cki);
			canvas.drawText(subMsg, x0+(int)GameConfig.BUTTON_ARGIN, y0+(int)(k*2.5*GameConfig.BUTTON_ARGIN)+3*GameConfig.BUTTON_ARGIN-5, paint);
			k++;
		}
		
		if(this.name!=null&&this.name.trim().length()>0){
			nameSd.draw(canvas);
			canvas.drawText(this.name, x0+(int)GameConfig.BUTTON_ARGIN, y0-(int)(4*GameConfig.BUTTON_ARGIN)+(int)(2*GameConfig.BUTTON_ARGIN), paint);
		}
		
	}
	
	
}
