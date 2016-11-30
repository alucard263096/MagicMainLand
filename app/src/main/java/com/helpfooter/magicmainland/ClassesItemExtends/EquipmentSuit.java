package com.helpfooter.magicmainland.ClassesItemExtends;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Utils.ConstEquipmentType;

public class EquipmentSuit {
	
	public FightPerson fightPerson;
	
	Dictionary<String,Equipment> suit=new Hashtable<String,Equipment>();
	
	public EquipmentSuit(FightPerson fightPerson){
		this.fightPerson=fightPerson;
		suit.put(ConstEquipmentType.Body, new Equipment("", "��", ConstEquipmentType.Body, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		suit.put(ConstEquipmentType.Foot,new Equipment("", "��", ConstEquipmentType.Foot, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		suit.put(ConstEquipmentType.Hand, new Equipment("", "��", ConstEquipmentType.Hand, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		suit.put(ConstEquipmentType.Head, new Equipment("", "��", ConstEquipmentType.Head, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		suit.put(ConstEquipmentType.SpecialDecorative, new Equipment("", "��", ConstEquipmentType.SpecialDecorative, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		suit.put(ConstEquipmentType.Weapon, new Equipment("", "��", ConstEquipmentType.Weapon, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
	}
	
	public Equipment getEquipment(String type){
		return suit.get(type);
	}
	
	public void load(Equipment equipment){
		if(equipment.beEquip()){
			equipment.suit.unload(equipment.type);
		}
		
		Equipment readyUnLoadEquipment=suit.get(equipment.type);
		if(readyUnLoadEquipment.beEquip()){

			readyUnLoadEquipment.suit.unload(readyUnLoadEquipment.type);
		}
		
		
		suit.remove(equipment.type);
		equipment.suit=this;
		suit.put(equipment.type, equipment);
	}
	
	public void unload(String type){
		
		Equipment readyUnLoadEquipment=suit.get(type);
		readyUnLoadEquipment.suit=null;
		
		suit.remove(type);
		suit.put(type, new Equipment("", "��", type, new Ability(0, 0, 0, 0, 0, 0, 0, 0, 0)));
		
	}
	
	public Ability getAblitity(){
		ArrayList<Ability> alAbs=new  ArrayList<Ability>();

		for (Enumeration<Equipment> e = suit.elements(); e.hasMoreElements() ;) {
			Equipment equipment=e.nextElement();
			alAbs.add(equipment.ablitity);
	      }
		
		return Ability.SumAblitity(alAbs);
	}
	
}
