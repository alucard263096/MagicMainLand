package com.helpfooter.magicmainland.Classes.DialogExtends;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.ClassesItemExtends.Equipment;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.Utils.GameConfig;


public class EquipmentDialog extends ItemShowDialog {

	
	DialogShowForm psd;

	int px0;
	int py0;
	int px1;
	int py1;
	
	Paint paint2;
	
	public EquipmentDialog(ArrayList<ItemQty> alIq) {
		super(alIq);
		// TODO Auto-generated constructor stub
		
		psd=new DialogShowForm();
		
		
		px0=x1+(int)(0.5* GameConfig.BUTTON_ARGIN);
		py0=(int)GameConfig.BUTTON_ARGIN;
		px1=px0+200;
		py1=py0+110;
		
		psd.setBounds(px0, py0, px1, py1);
		
		paint2=new Paint();
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);
		paint2.setTextSize(14);
		

	}
	
	public void drawPointToItem(Canvas canvas, ItemQty ip) {
		// TODO Auto-generated method stub
		super.drawPointToItem(canvas, ip);
		
		psd.draw(canvas);
		
		int ycourse=py0;
		int nextX=px0+100;
		Equipment ep=(Equipment)ip.item;
		Ability abs=ep.ablitity;
		ArrayList<String> descriptionStrAl=abs.getListDesciption();
		
		int qty=descriptionStrAl.size();
		ycourse+=(int)GameConfig.BUTTON_ARGIN;
		for(int i=0;i<qty;i++){
			if(i>0&&i%2==0){
				ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
			}
			if(i%2==0){
				canvas.drawText(descriptionStrAl.get(i), px0+(int)GameConfig.BUTTON_ARGIN, py0+ycourse, paint2);
			}else{
				canvas.drawText(descriptionStrAl.get(i), nextX, py0+ycourse, paint2);
			}
		}
	}
	
	public String getItemShowName(ItemQty ip) {
		// TODO Auto-generated method stub
		String strname=super.getItemShowName(ip);
		
		Equipment ep=(Equipment)ip.item;
		if(ep.beEquip()){
			
			strname+="("+ep.suit.fightPerson.name+")";
			
		}
		return strname;
	}
}
