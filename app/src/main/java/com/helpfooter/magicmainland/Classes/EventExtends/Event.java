package com.helpfooter.magicmainland.Classes.EventExtends;

import com.helpfooter.magicmainland.Classes.EventManager;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.DialogExtends.Dialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.graphics.Canvas;
import android.util.Log;

public class Event {
	public String id;
	public String name;
	public String msg;
	public String talkerName;
	Event nextEvent;
	
	public Person person;
	
	boolean isKeyEvent;
	public String eventId="";
	
	
	IDialog dialog;
	
	public Event(String id,String name,String msg){
		this.id=id;
		this.name=name;
		this.msg=msg;
		this.isKeyEvent=false;
		if(person!=null){
			talkerName=person.name;
		}
	}
	
	public void setTalkIngPerson(Person person){

		this.person=person;
	}
	
	public void setNextEvent(Event event){
		
		this.nextEvent=event;
		
	}
	
	public void doAction(){

		dialog=getDialog();
		
		EventManager em=EventManager.getInstance();
		em.currentEvent=this;

		if(isKeyEvent){
			KeyEventManager kem=KeyEventManager.getInstance();
			kem.completedEvent(eventId);
		}
		
	}
	
	public IDialog getDialog() {
		// TODO Auto-generated method stub
		return new Dialog(this.msg, talkerName);
	}

	public void setNextDialog(){
		if(nextEvent !=null){
			nextEvent.doAction();
		}
		else{
			EventManager em=EventManager.getInstance();
			em.currentEvent=null;
		}
	}
	
	public void RegisterKeyEvent(String eventId){
		this.isKeyEvent=true;
		this.eventId=eventId;
		KeyEventManager kem=KeyEventManager.getInstance();
		kem.registerKeyEvent(eventId);
	}


	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		if(dialog!=null){
			dialog.draw(canvas);
		}
	}

	public void setControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(irButton==EnumControllerButton.DOWN
				||irButton==EnumControllerButton.A){
				this.setNextDialog();
			}
	}
	
	
	
}
