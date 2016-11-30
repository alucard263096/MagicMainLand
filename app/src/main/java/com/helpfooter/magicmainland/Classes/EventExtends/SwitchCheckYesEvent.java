package com.helpfooter.magicmainland.Classes.EventExtends;

import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;

public class SwitchCheckYesEvent extends SwitchEvent {
	
	String checkKeyEventId;
	boolean onlyCheck;
	
	public SwitchCheckYesEvent(String id,String name, String msg, Event yEvent,
			Event nEvent,String checkKeyEventId,boolean onlyCheck) {
		super( id, name, msg, yEvent, nEvent);
		// TODO Auto-generated constructor stub
		this.checkKeyEventId=checkKeyEventId;
		this.onlyCheck=onlyCheck;
	}

	public void SetSelectEvent(boolean tOrf){
		
		if(tOrf){
			KeyEventManager kem=KeyEventManager.getInstance();
			tOrf=kem.getEventIsCompleted(checkKeyEventId);
		}
		super.setNextEvent(tOrf?yEvent:nEvent);
		
	}
	
	public void doAction(){
		if(this.onlyCheck){
			KeyEventManager kem=KeyEventManager.getInstance();
			boolean checkIsCompletedEvent=kem.getEventIsCompleted(checkKeyEventId);
			if(checkIsCompletedEvent){
				if(yEvent!=null){
					yEvent.doAction();
				}
			}
			else{
				if(nEvent!=null){
					nEvent.doAction();
				}
			}
		}
		else{
			super.doAction();
		}
		
	}
}
