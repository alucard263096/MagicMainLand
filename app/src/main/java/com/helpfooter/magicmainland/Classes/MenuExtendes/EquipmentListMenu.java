package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

import com.helpfooter.magicmainland.Common.StaticObject;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.EquipmentDialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.ItemShowDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;

public class EquipmentListMenu extends BaseItemListMenu {

	public EquipmentListMenu(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void itemListInitialization(){
		Hero hero=StaticObject.StarHero;
		itemQties=hero.luggage.alEquipments;
		itemShowDialog=new EquipmentDialog(itemQties);
	}
	
	public void buttonAEvent(){
		if(itemQties.size()>0){
			ItemQty iq=itemQties.get(pcoursor-1);
			selectedMenu=new EquipmentLoadMenu(iq);
			selectedMenu.setSuperMenu(this);
			selectedMenu.initialization();
			this.isOptionSeleted=true;
		}
	}
	
}
