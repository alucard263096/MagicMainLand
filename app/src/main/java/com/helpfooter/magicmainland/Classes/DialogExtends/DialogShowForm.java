package com.helpfooter.magicmainland.Classes.DialogExtends;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

public class DialogShowForm {

	ShapeDrawable sd;
	ShapeDrawable bsd;
	int alf=0;
	
	public DialogShowForm(){
		float[] R=new float[]{10,10,10,10,10,10,10,10};
		//RectF insect=new RectF(10,10,10,10);
		Shader mShader=new LinearGradient(0,0,100,100,new int[]{Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK},null,Shader.TileMode.REPEAT);
		sd=new ShapeDrawable(new RoundRectShape(R,null,null));
		sd.getPaint().setShader(mShader);
		

		Shader mShader2=new LinearGradient(0,0,100,100,new int[]{Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE},null,Shader.TileMode.REPEAT);
		bsd=new ShapeDrawable(new RoundRectShape(R,null,null));
		bsd.getPaint().setShader(mShader2);
	}
	
	public void setBounds(int x0,int y0,int x1,int y1){

		bsd.setBounds(x0-2,y0-2,x1+2,y1+2);
		sd.setBounds(x0,y0,x1,y1);
		
	}
	
	public void draw(Canvas canvas){

		bsd.draw(canvas);
		sd.draw(canvas);

		
	}
}
