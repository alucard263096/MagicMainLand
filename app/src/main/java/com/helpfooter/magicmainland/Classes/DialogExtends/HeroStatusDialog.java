package com.helpfooter.magicmainland.Classes.DialogExtends;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.Classes.DialogExtends.DialogShowForm;
import com.helpfooter.magicmainland.Classes.GameController;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.ClassesItemExtends.Equipment;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.ConstEquipmentType;
import com.helpfooter.magicmainland.Utils.GameConfig;


public class HeroStatusDialog implements IDialog {
	
	DialogShowForm sd;

	int x0;
	int y0;
	int x1;
	int y1;
	
	

	Paint paint;
	Paint paint2;

	private FightPerson fightPerson;
	private Ability ablitity;
	
	public HeroStatusDialog(FightPerson fightPerson){
		this.fightPerson= fightPerson;
		this.ablitity=fightPerson.getTotalAblitity();
		sd=new DialogShowForm();
		
		GameController gcon=GameController.getInstance();
		
		x0=(int)(gcon.rightArrowX+ GameConfig.BUTTON_SIZE)-(int)GameConfig.BUTTON_ARGIN;
		y0=(int)GameConfig.BUTTON_ARGIN;
		x1=x0+280;
		y1=y0+220;
		
		sd.setBounds(x0, y0, x1, y1);
		

		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setTextSize(14);
		
		paint2=new Paint();
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);
		paint2.setTextSize(13);
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		sd.draw(canvas);
		
		int ycourse=2*(int)GameConfig.BUTTON_ARGIN;
		int nextX=x0+130;
		Equipment ep;
		
		canvas.drawText(fightPerson.name, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint);
		canvas.drawText("�ȼ���"+fightPerson.level, nextX, y0+ycourse, paint);
		
		ycourse+=(int)GameConfig.BUTTON_ARGIN;
		canvas.drawLine(x0, y0+ycourse, x1, y0+ycourse, paint);

		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("����ֵ��"+fightPerson.currentHp+"/"+this.ablitity.hp, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.Head);
		canvas.drawText("ͷ����"+ep.name, nextX, y0+ycourse, paint2);

		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("ħ��ֵ��"+fightPerson.currentMp+"/"+this.ablitity.mp, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.Body);
		canvas.drawText("���ף�"+ep.name, nextX, y0+ycourse, paint2);

		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("������"+this.ablitity.act, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.Hand);
		canvas.drawText("���֣�"+ep.name, nextX, y0+ycourse, paint2);

		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("������"+this.ablitity.def, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.Foot);
		canvas.drawText("���ȣ�"+ep.name, nextX, y0+ycourse, paint2);
		
		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("�ٶȣ�"+this.ablitity.spd, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.Weapon);
		canvas.drawText("������"+ep.name, nextX, y0+ycourse, paint2);
		
		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("���ɣ�"+this.ablitity.tec, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		ep=fightPerson.equipmentSuit.getEquipment(ConstEquipmentType.SpecialDecorative);
		canvas.drawText("���"+ep.name, nextX, y0+ycourse, paint2);
		
		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("ħ����"+this.ablitity.mgact, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		canvas.drawText("����EXP��0000000000", nextX, y0+ycourse, paint2);
		
		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("ħ����"+this.ablitity.mgdef, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		canvas.drawText("ְҵ������", nextX, y0+ycourse, paint2);
		
		ycourse+=2*(int)GameConfig.BUTTON_ARGIN;
		canvas.drawText("���ˣ�"+this.ablitity.lck, x0+(int)GameConfig.BUTTON_ARGIN, y0+ycourse, paint2);
		
	}

}
