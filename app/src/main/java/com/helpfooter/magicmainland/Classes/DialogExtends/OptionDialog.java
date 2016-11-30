package com.helpfooter.magicmainland.Classes.DialogExtends;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class OptionDialog implements IDialog {

	int col=1;
	ArrayList<String> alOption;
	
	DialogShowForm sd;

	int x0;
	int y0;
	int x1;
	int y1;

	Paint paint;
	
	public OptionDialog(int startX,int startY,int col,ArrayList<String> alOption){
		this.col=col;
		this.alOption=alOption;
		
		int maxStringLength=getmaxStringLength(alOption);
		
		sd=new DialogShowForm();
	

		x0=startX+(int) GameConfig.BUTTON_ARGIN;
		y0=startY+(int)GameConfig.BUTTON_ARGIN;
		x1=x0+col*maxStringLength/2*(int)(GameConfig.COMMONSIZE);
		y1=y0+(alOption.size()/col)*2*(int)(GameConfig.BUTTON_ARGIN)+5;
		
		sd.setBounds(x0, y0, x1, y1);
		

		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setTextSize(14);
	}
	
	private int getmaxStringLength(ArrayList<String> alOption2) {
		// TODO Auto-generated method stub
		int maxLength=0;
		
		for(String str:alOption2){
			if(str.length()>maxLength){
				maxLength=str.length();
			}
		}
		
		
		return maxLength;
	}

	public int cursor;
	public boolean selectAll;
	public void setCursor(int cursor){
		this.cursor=cursor;
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		sd.draw(canvas);
		
		int qty=alOption.size();
		
		int detaY=y0;
		int detaX=(int)(GameConfig.BUTTON_ARGIN+GameConfig.COMMONSIZE);
		
		for(int i=0;i<qty;i++){
			
			if(i%col==0){
				detaY+=2*(int)(GameConfig.BUTTON_ARGIN);
			}
			int rx=(i%col)*detaX;
			
			String str=alOption.get(i);
			canvas.drawText(str, x0+rx+(int)(GameConfig.BUTTON_ARGIN)+5, detaY-3, paint);
			if(selectAll==true||i==cursor){
				
				YesNoDialog.drawSelectedTrangle(canvas, x0+rx+3,detaY-3-(int)(GameConfig.BUTTON_ARGIN));
				
			}
		}
		
	}

}
