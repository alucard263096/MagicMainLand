package com.helpfooter.magicmainland.ClassesItemExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Common.StaticObject;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;

public abstract class ConsumableItem extends Item {

	public boolean isNotConsumable;
	public boolean isQueueUse;

	public ConsumableItem(String id,String name) {
		super(id,name,true);
		// TODO Auto-generated constructor stub
	}

	public void use(FightPerson fightPerson) {
		// TODO Auto-generated method stub
	}
	
	public void use(){
		Hero hero=StaticObject.StarHero;
		use(hero);
		ArrayList<FightPerson> alFp=hero.partners;
		for(FightPerson fightPerson:alFp){
			use(fightPerson);
		}
	}
}
