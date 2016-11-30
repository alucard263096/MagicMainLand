package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Common.StaticObject;

import android.util.Log;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;

public class QueueMenu extends Menu {

	ArrayList<FightPerson> alFightPerson=new ArrayList<FightPerson>();
	
	public QueueMenu(String name) {
		super(name, 1);
		// TODO Auto-generated constructor stub
	}

	public void initialization() {
		// TODO Auto-generated method stub
		
		alOp.clear();
		
		Hero hero=StaticObject.StarHero;
		
		HeroStatusMenu hsop=new HeroStatusMenu(hero.name, hero);
		this.addOption(hsop);
		alFightPerson.add(hero);
		Log.d("2s",String.valueOf(hero.partners.size()) );
		
		ArrayList<FightPerson> alFp=hero.partners;
		for(FightPerson fightPerson:alFp){
			HeroStatusMenu sop=new HeroStatusMenu(fightPerson.name, fightPerson);
			this.addOption(sop);
			alFightPerson.add(fightPerson);
		}
		super.initialization();
	}
	
}
