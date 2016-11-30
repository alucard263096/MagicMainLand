package com.helpfooter.magicmainland.Classes.EventExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.KeyEventManager;

public class SceneAppearCondition {
	ArrayList<String> alOccurEvent=new ArrayList<String>();
	ArrayList<String> alNotOccurEvent=new ArrayList<String>();
	
	public void AddOccurEvent(String event){
		 alOccurEvent.add(event);
	}

	public void AddNotOccurEvent(String event){
		 alNotOccurEvent.add(event);
	}
	
	public boolean getAppearStatus(){
		KeyEventManager kem=KeyEventManager.getInstance();
		for(String event: alOccurEvent){
			if(kem.getEventIsCompleted(event)==false){
				return false;
			}
		}
		
		for(String event: alNotOccurEvent){
			if(kem.getEventIsCompleted(event)==true){
				return false;
			}
		}
		
		return true;
	}
	
	
}
