package com.helpfooter.magicmainland.Classes.EventExtends;

import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.Dialog;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;


public class MoneyEvent extends Event {

	int amount;
	
	public MoneyEvent(String id,String name,int amount) {
		super( id, name, "");
		// TODO Auto-generated constructor stub
		this.amount=amount;
		this.msg="���"+this.amount+"G��";
		
	}

	public void doAction(){

		Luggage luggage=StaticObject.StarHero.luggage;
		luggage.addMoney(this.amount);
		
		super.doAction();
		
	}
}
