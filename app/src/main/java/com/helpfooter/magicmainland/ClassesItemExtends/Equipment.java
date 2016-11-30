package com.helpfooter.magicmainland.ClassesItemExtends;

import com.helpfooter.magicmainland.Classes.Ability;

public class Equipment extends Item {

	public Ability ablitity;
	String type;
	
	public EquipmentSuit suit;
	
	public Equipment(String id,String name,String type,Ability ablitity) {
		super(id,name,false);
		// TODO Auto-generated constructor stub
		this.ablitity=ablitity;
		this.type=type;
	}
	
	public boolean beEquip(){
		return suit!=null;
	}
}
