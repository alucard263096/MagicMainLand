package com.helpfooter.magicmainland.Classes;

import java.util.LinkedList;
import java.util.Queue;

import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.graphics.Canvas;

public class EventManager {

	private Queue<Event> queueEvent = new LinkedList<Event>();  
	
	public Event currentEvent;
	
	private static EventManager instance=null;
	public static EventManager getInstance(){
		
		if(instance==null){
			instance=new EventManager();
		}
		return instance;
	}
	
	private EventManager(){
		
	}
	
	public void drawDialog(Canvas canvas){
		if(currentEvent!=null){
			currentEvent.draw(canvas);
		}
	}

	public void setOperationButtonForDialog(EnumControllerButton irButton){
		if(currentEvent!=null){
			currentEvent.setControll(irButton);
		}
	}

	public void offerDialog(Event event){
		queueEvent.offer(event);
	}
	
	public void pollDialog(){
		currentEvent=queueEvent.poll();
	}
}
