package com.helpfooter.magicmainland.Classes.EventExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Common.StaticObject;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.graphics.Canvas;

import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.Dialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.ClassesItemExtends.Item;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;

public class ItemEvent extends Event {
	ItemQty items;
	boolean onlyPresent=false;
	public ItemEvent(String id,String name,ItemQty items) {
		super( id, name, "");
		// TODO Auto-generated constructor stub
		this.items=items;
		
		StringBuilder sb=new StringBuilder();
		sb.append("���");
		sb.append(items.item.name);
		if(items.qty>1){
			sb.append(items.qty);
			sb.append("��");
		}
		sb.append("��");
		
		this.msg=sb.toString();
		
	}	

	public void doAction(){

		Luggage luggage=StaticObject.StarHero.luggage;
		luggage.addItem(items);
		
		super.doAction();
	}
	
}
