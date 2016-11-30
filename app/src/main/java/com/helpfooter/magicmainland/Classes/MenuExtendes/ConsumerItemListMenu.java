package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;


import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.HeroStatusDialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.ItemShowDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;
import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.EnumDialogOption;
import android.util.Log;

import com.helpfooter.magicmainland.Classes.MenuExtendes.BaseItemListMenu;

public class ConsumerItemListMenu extends BaseItemListMenu {
	
	
	
	public ConsumerItemListMenu(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void itemListInitialization(){
		Hero hero= StaticObject.StarHero;
		itemQties=hero.luggage.alConsumableItems;
		itemShowDialog=new ItemShowDialog(itemQties);
	}
	
	public void buttonAEvent(){
		if(itemQties.size()>0){
			ItemQty iq=itemQties.get(pcoursor-1);
			selectedMenu=new ConsumerItemUseMenu(iq);
			selectedMenu.setSuperMenu(this);
			selectedMenu.initialization();
			this.isOptionSeleted=true;
		}
	}
}
