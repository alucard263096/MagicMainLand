package com.helpfooter.magicmainland.ClassesItemExtends;

import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;

public class RehabilitationDrug extends ConsumableItem {

	boolean canResurrection=false;
	int hpAdd=0;
	int mpAdd=0;
	
	public RehabilitationDrug(String id, String name,int hpAdd,int mpAdd, boolean canResurrection) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.hpAdd=hpAdd;
		this.mpAdd=mpAdd;
		this.canResurrection=canResurrection;
	}
	
	public void use(FightPerson fightPerson) {
		// TODO Auto-generated method stub

		int hp=hpAdd;
		int mp=mpAdd;
		if(canResurrection==false&&fightPerson.currentHp==0){
			hp=0;
			mp=0;
		}
		fightPerson.addHpAndMp(hp,mp);
	}
}
