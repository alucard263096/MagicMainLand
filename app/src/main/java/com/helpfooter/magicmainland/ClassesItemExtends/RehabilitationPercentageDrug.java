package com.helpfooter.magicmainland.ClassesItemExtends;

import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;

public class RehabilitationPercentageDrug extends ConsumableItem {
	
	boolean canResurrection=false;
	int perHp=0;
	int perMp=0;
	
	public RehabilitationPercentageDrug(String id, String name, int perHp, int perMp, boolean canResurrection) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.perHp=perHp;
		this.perMp=perMp;
		this.canResurrection=canResurrection;
	}
	
	public void use(FightPerson fightPerson) {
		// TODO Auto-generated method stub
		int hpAdd=(int)(fightPerson.baseAblitity.hp*perHp*0.01);
		int mpAdd=(int)(fightPerson.baseAblitity.mp*0.01);

		if(canResurrection==false&&fightPerson.currentHp==0){
			hpAdd=0;
			mpAdd=0;
		}
		fightPerson.addHpAndMp(hpAdd,mpAdd);
	} 

}
