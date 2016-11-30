package com.helpfooter.magicmainland.Classes.PersonExtends;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.ClassesItemExtends.EquipmentSuit;
import android.graphics.Bitmap;

public class FightPerson extends NPC{

	public EquipmentSuit equipmentSuit;
	//Ѫ��
	public int currentHp;
	//ħ����
	public int currentMp;
	
	public Ability baseAblitity;
	
	public int level;
	public int exp;
	
	
	public FightPerson(String id,String name, Bitmap image,Ability ablitity) {
		super( id,name, image);
		// TODO Auto-generated constructor stub
		this.baseAblitity= ablitity;
		this.currentHp=ablitity.hp;
		this.currentMp=ablitity.mp;
		level=1;
		equipmentSuit=new EquipmentSuit(this);
	}
	
	public Ability getTotalAblitity(){
		
		ArrayList<Ability> alAbs=new ArrayList<Ability>();
		alAbs.add(this.baseAblitity);
		alAbs.add(equipmentSuit.getAblitity());
		
		return Ability.SumAblitity(alAbs);
	}

	public void addHpAndMp(int hpAdd, int mpAdd) {
		// TODO Auto-generated method stub
		currentHp+=hpAdd;
		currentMp+=mpAdd;
		
		setCorrectHpMp();
		
	}
	
	public void setCorrectHpMp(){
		if(currentHp<0){
			currentHp=0;
		}
		if(currentHp>baseAblitity.hp){
			currentHp=baseAblitity.hp;
		}
		if(currentMp<0){
			currentMp=0;
		}
		if(currentMp>baseAblitity.mp){
			currentMp=baseAblitity.mp;
		}
	}

	public void addAblitity(Ability ablitity) {
		// TODO Auto-generated method stub
		ArrayList<Ability> alAbs=new ArrayList<Ability>();
		alAbs.add(baseAblitity);
		alAbs.add(ablitity);
		this.baseAblitity=Ability.SumAblitity(alAbs);
	}
	
}
