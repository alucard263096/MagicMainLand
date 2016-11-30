package com.helpfooter.magicmainland.Classes.DialogExtends;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import com.helpfooter.magicmainland.Utils.EnumDialogOption;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class YesNoDialog extends Dialog {

	DialogShowForm sdYN;
	EnumDialogOption dialogSelected;
	
	public YesNoDialog(String msg, String name) {
		super(msg, name);
		// TODO Auto-generated constructor stub
		dialogSelected=EnumDialogOption.YES;
		InitializationOptionBox();
		
	}

	private void InitializationOptionBox() {
		// TODO Auto-generated method stub

//		
		sdYN=new DialogShowForm();
		
		Log.d("doit", "xx");
		
		sdYN.setBounds(x1-40,y0-(int)(6* GameConfig.BUTTON_ARGIN),x1,y0-(int)GameConfig.BUTTON_ARGIN);

	}
	
	public void setYesNo(EnumDialogOption selected){
		this.dialogSelected=selected;
	}

	@SuppressWarnings("unused")
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		Log.d("doit", "xxx");
		
			
			
			sdYN.draw(canvas);
			canvas.drawText("��", x1-25, y0-(int)(4*GameConfig.BUTTON_ARGIN), paint);
			canvas.drawText("��", x1-25, y0-(int)(2*GameConfig.BUTTON_ARGIN), paint);
			
			int detaY=dialogSelected==EnumDialogOption.YES?0:(int)(2*GameConfig.BUTTON_ARGIN);
			
			
//			Path path=new Path();
//			path.moveTo(x1-35,y0-(int)(5*GameConfig.BUTTON_ARGIN)+detaY);
//			path.lineTo(x1-35,y0-(int)(4*GameConfig.BUTTON_ARGIN)+detaY);
//			path.lineTo(x1-25,y0-(int)(4.5*GameConfig.BUTTON_ARGIN)+detaY);
//			path.close();
//			canvas.drawPath(path, tpaint);
			drawSelectedTrangle(canvas,x1-35,y0-(int)(5*GameConfig.BUTTON_ARGIN)+detaY);
	}
	
	public static void drawSelectedTrangle(Canvas canvas,int x,int y){
		Paint tpaint=new Paint();
		tpaint.setAntiAlias(true);
		tpaint.setColor(Color.WHITE);
		tpaint.setStyle(Paint.Style.FILL);
		
		Path path=new Path();
		path.moveTo(x,y);
		path.lineTo(x,y+(int)(1*GameConfig.BUTTON_ARGIN));
		path.lineTo(x+(int)(GameConfig.BUTTON_ARGIN),y+(int)(0.5*GameConfig.BUTTON_ARGIN));
		path.close();
		canvas.drawPath(path, tpaint);
	}
}
