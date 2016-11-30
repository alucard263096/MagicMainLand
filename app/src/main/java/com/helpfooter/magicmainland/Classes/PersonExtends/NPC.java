package com.helpfooter.magicmainland.Classes.PersonExtends;


import android.graphics.Bitmap;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;

public class NPC extends Person {

	Event event;
	
	public NPC(String id,String name,Bitmap image) {
		super(id,name,image);
		// TODO Auto-generated constructor stub
	}
	public void SetTalkingEvent(Event event) {
		// TODO Auto-generated method stub
		this.event=event;
	}
	
	public void Talking(String defaultDirect){
		super.Talking(defaultDirect);
		if(event!=null){
			event.doAction();
		}
	}
	
	
	
	
	
}
