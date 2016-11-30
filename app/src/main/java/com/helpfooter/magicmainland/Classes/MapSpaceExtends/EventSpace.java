package com.helpfooter.magicmainland.Classes.MapSpaceExtends;

import android.graphics.Bitmap;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;

public class EventSpace extends MapSpace {
	
	public EventSpace(Bitmap bitmap, int positionx, int positiony, int width,
			int height,Event event) {
		super(bitmap, positionx, positiony, width, height);
		// TODO Auto-generated constructor stub
		this.event=event;
	}

	Event event;
	
//	public EventSpace(){
//		
//	}
	
	public void forCheckDo() {
		// TODO Auto-generated method stub
		KeyEventManager kem=KeyEventManager.getInstance();
		boolean isDoEvent=kem.getEventIsCompleted(event.eventId);
		if(isDoEvent==false){
			event.doAction();
		}
	}
}
