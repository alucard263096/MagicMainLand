package com.helpfooter.magicmainland.Classes.GameLoadObject;

import android.graphics.Canvas;
import android.util.Log;

public abstract class AbstractGameLoadObject {
	
	private boolean isActive=false;
	private boolean isCompleted=false;
	private long startTime=0;
	private long showTime;
	
	public AbstractGameLoadObject(long showTime){
		this.showTime=showTime;
	}
	
	
	
	public void doDraw(Canvas canvas,long runtime){
		

		if((runtime-startTime)/1000>=showTime){
			isCompleted=true;
		}
	}
	
	public boolean IsActive(){
		return isActive;
	}
	public boolean IsCompleted(){
		return isCompleted;
	}
	public void Active(long startTime){
		Log.d("r", String.valueOf(startTime));
		this.startTime=startTime;
		isActive=true;
	}



	public void reset() {
		// TODO Auto-generated method stub

		isActive=false;
		isCompleted=false;
		 startTime=0;
	}
}
