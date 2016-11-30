package com.helpfooter.magicmainland.ClassesItemExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;

public class IncreaseDrug extends ConsumableItem {

	Ability ablitity=null;
	
	public IncreaseDrug(String id, String name, Ability ablitity) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.ablitity=ablitity;
	}
	
	public void use(FightPerson fightPerson) {
		// TODO Auto-generated method stub
		fightPerson.addAblitity(ablitity);
	} 

}
