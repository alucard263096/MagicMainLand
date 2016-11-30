package com.helpfooter.magicmainland.Classes.EventExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Common.StaticObject;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;

public class JoinQueueEvent extends Event {
	FightPerson friend;
	public JoinQueueEvent(String id,String name, FightPerson friend) {
		super( id, name, friend.name+"�����˶���");
		// TODO Auto-generated constructor stub
		this.friend=friend;
	}
	
	
	
	
	public void setControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(irButton==EnumControllerButton.DOWN
				||irButton==EnumControllerButton.A){
			
				Hero hero=StaticObject.StarHero;
				hero.partners.add(friend);
				//alPerson.remove(person);
				if(StaticObject.CurrentScene!=null){
					StaticObject.CurrentScene.removePersonById(friend.id);
				}
			}
		super.setControll(irButton);
	}
}
