package com.helpfooter.magicmainland.Classes.PersonExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.ClassesItemExtends.ConsumableItem;
import com.helpfooter.magicmainland.ClassesItemExtends.Equipment;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;
import com.helpfooter.magicmainland.ClassesItemExtends.PlotItem;
import android.graphics.Bitmap;

public class Hero extends FightPerson {

	public Luggage luggage;
	public ArrayList<FightPerson> partners=new ArrayList<FightPerson>();
	
	
	
	public Hero(String id,String name, Bitmap image,
			Ability ablitity) {
		super(id,name, image, ablitity);
		// TODO Auto-generated constructor stub
		luggage=Luggage.getInstance();
	}
	
	

		
}
