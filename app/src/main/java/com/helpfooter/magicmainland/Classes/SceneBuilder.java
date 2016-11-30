package com.helpfooter.magicmainland.Classes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.EventExtends.BusinessEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Classes.EventExtends.ItemEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.JoinQueueEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.MoneyEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.SceneAppearCondition;
import com.helpfooter.magicmainland.Classes.EventExtends.SwitchCheckYesEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.SwitchEvent;
import com.helpfooter.magicmainland.Classes.MapSpaceExtends.EventSpace;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.Classes.PersonExtends.NPC;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Classes.PersonExtends.TreasureBox;
import com.helpfooter.magicmainland.Classes.SceneCore.Scene;
import com.helpfooter.magicmainland.Classes.XmlDataLoader.GameSettingLoader;
import com.helpfooter.magicmainland.ClassesItemExtends.ConsumableItem;
import com.helpfooter.magicmainland.ClassesItemExtends.Equipment;
import com.helpfooter.magicmainland.ClassesItemExtends.IncreaseDrug;
import com.helpfooter.magicmainland.ClassesItemExtends.Item;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPrice;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPriceCatalog;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.ClassesItemExtends.PlotItem;
import com.helpfooter.magicmainland.ClassesItemExtends.RehabilitationDrug;
import com.helpfooter.magicmainland.ClassesItemExtends.RehabilitationPercentageDrug;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SceneBuilder {
	
	Resources resource;
	Scene currentScene;
	

	public SceneBuilder(Resources r) {
		// TODO Auto-generated constructor stub
		this.resource=r;
		
//		Bitmap bmphero=BitmapFactory.decodeResource(r, R.drawable.hero);
//		hero=new Hero("��³����",bmphero,EnumDirect.SOUTH,Ablitity.GetRandom());
//		hero.luggage.addMoney(10000);
//		currentScene=getFirstScene();
	}
	
	public Scene getFirstScene(GameSettingLoader gameSetting){
		return null;
	}
//
//	private Scene getFirstScene() {
//		// TODO Auto-generated method stub
//		
//		Bitmap bmpBack=BitmapFactory.decodeResource(resource, R.drawable.back);		
//		SceneMap map=new SceneMap(bmpBack,12,8);
//		
//		MoneyEvent me=new MoneyEvent(1000);
//		me.RegisterKeyEvent("getMoney");
//		EventSpace esp=new EventSpace(me);
//		map.mapGuid[1][1]=esp;
//		
//		ArrayList<Person> alPerson=new ArrayList<Person>();
//		
//		alPerson.add(getNZ());
//		alPerson.add(getLuRenJia());
//		alPerson.add(getTreasureBox());
//		alPerson.add(setBusinessNpc());
//		
//		SceneAppearCondition appcod=new SceneAppearCondition();
//		appcod.AddNotOccurEvent("addToQueue");
//		if(appcod.getAppearStatus()){
//			alPerson.add(setPartner(alPerson));
//		}
//		
//		map.heroX=1;
//		map.heroY=3;
//		
//		hero.x=map.heroX;
//		hero.y=map.heroY;
//		
//		Scene s=new Scene(map,alPerson,hero);
//		return s;
//	}
//	
//	private Person setPartner(ArrayList<Person> alPerson) {
//		// TODO Auto-generated method stub
//		Bitmap bmpNpc=BitmapFactory.decodeResource(resource, R.drawable.friend);
//		FightPerson p=new FightPerson("����",bmpNpc,EnumDirect.SOUTH,Ablitity.GetRandom());
//		
//		p.x=6;
//		p.y=7;
//		
//		JoinQueueEvent e0=new JoinQueueEvent(p, "һ��ȥ���",alPerson);
//		e0.RegisterKeyEvent("addToQueue");
//		p.SetTalkingEvent(e0);
//		
//		return p;
//	}
//
//	private Person setBusinessNpc() {
//		// TODO Auto-generated method stub
//		Bitmap bmpNpc=BitmapFactory.decodeResource(resource, R.drawable.npc);
//		NPC p=new NPC("����",bmpNpc,EnumDirect.SOUTH);
//		p.x=7;
//		p.y=3;
////		p.addTalkingContent("��ã����������ܺá�");
////		p.addTalkingContent("Ҫ��Ҫ������");
//		
//		Event e3=new Event(p,"��ӭ�´ι��١�");
////		
//		ItemPriceCatalog ipc=new ItemPriceCatalog();
//		ConsumableItem ci=new RehabilitationDrug("it1", "�����ָ�ҩˮ",100,0,false);
//		ci.description="����ֵ+100";
//		ipc.addItem(new ItemPrice(ci, 100));
//		ci=new RehabilitationDrug("it2", "���������ָ�ҩˮ",1000,0,false);
//		ci.description="����ֵ+1000";
//		ipc.addItem(new ItemPrice(ci, 1000));
//		ci=new RehabilitationDrug("it3", "�㶼�ָ�ҩˮ",100,100,false);
//		ci.description="����ֵ+100��ħ��ֵ+100";
//		ipc.addItem(new ItemPrice(ci, 10000));
//		ci=new RehabilitationPercentageDrug("it4", "ִ��������",10,0,true);
//		ci.description="����ֵ+10%";
//		ipc.addItem(new ItemPrice(ci, 1000));
//		ci=new RehabilitationDrug("it5", "ȫ��ָ�ҩ",30,30,false);
//		ci.description="ȫ����Ա����ֵ+30,ħ��ֵ+30";
//		ci.isQueueUse=true;
//		ipc.addItem(new ItemPrice(ci, 101));
//
//		ci=new RehabilitationDrug("it7", "���޻ָ�ҩˮ",1,0,false);
//		ci.isNotConsumable=true;
//		ci.description="�ü�������ɹ";
//		ipc.addItem(new ItemPrice(ci, 9999));
//		
//
//		ci=new IncreaseDrug("it6", "ʮȫ�󲹵�",Ablitity.GetRandom());
//		ci.description="������ǿҩ��";
//		ipc.addItem(new ItemPrice(ci, 9999));
//		
//		Equipment ep=new Equipment("it", "˿��", EnumEquipmentType.Head, Ablitity.GetRandom());
//		ep.description="�������ר��";
//		ipc.addItem(new ItemPrice(ep, 30));
//		ep=new Equipment("it", "�ܵ���", EnumEquipmentType.Body, Ablitity.GetRandom());
//		ep.description="�������ר��";
//		ipc.addItem(new ItemPrice(ep, 8888));
//		
//		BusinessEvent e2=new BusinessEvent(ipc);
//		e2.setNextEvent(e3);
//		Event e1=new Event(p,"������������");
//		e1.setNextEvent(e2);
//		
//		p.SetTalkingEvent(e1);
//		
//		return p;
//	}
//
//	private Person getTreasureBox() {
//		// TODO Auto-generated method stub
//		Bitmap bmpNpc=BitmapFactory.decodeResource(resource, R.drawable.npc);
//		Bitmap treasurebox=BitmapFactory.decodeResource(resource, R.drawable.treasurebox);
//		
//		Equipment pi=new Equipment("sword","����֮��", EnumEquipmentType.Weapon,Ablitity.GetRandom());
//		pi.description="ֻ�����߲��ܹ�ʹ�õĽ���";
//		ItemEvent itemEvent=new ItemEvent(new ItemQty(pi,1));
//		itemEvent.RegisterKeyEvent("getSword");
//		
//		TreasureBox tb=new TreasureBox("", treasurebox,bmpNpc,EnumDirect.NORTH,itemEvent);
//
//		tb.x=4;
//		tb.y=7;
//		
//		return tb;
//	}
//
//	public Person getNZ(){
//		Bitmap bmpNpc=BitmapFactory.decodeResource(resource, R.drawable.npc);
//		NPC p=new NPC("��֥",bmpNpc,EnumDirect.SOUTH);
//		p.x=4;
//		p.y=4;
////		p.addTalkingContent("��ã����������ܺá�");
////		p.addTalkingContent("Ҫ��Ҫ������");
////		
//		
//		Event e3_1_1=new Event(p,"�ã���������");
//		Event e3_1_2=new Event(p,"�ǻ�����ȥ�򣬿�����������ﰡ");
//		
//		SwitchCheckYesEvent e3_1=new SwitchCheckYesEvent(p,"̫���ˣ������������û�У�",e3_1_1,e3_1_2,"gettao",false);
//		e3_1.RegisterKeyEvent("wantml");
//		Event e3_2=new Event(p,"5555,̫������");
//		
//		SwitchEvent e2=new SwitchEvent(p,"��ħ��Ҫץ�ң����Һò��ã�",e3_1,e3_2);
//		
//		Event e1=new Event(p,"��ã����������ܺá�");
//		e1.setNextEvent(e2);
//		
//		p.SetTalkingEvent(e1);
//		
//		return p;
//	}
//	
//	public Person getLuRenJia(){
//		Bitmap bmpNpc=BitmapFactory.decodeResource(resource, R.drawable.npc);
//		NPC p=new NPC("��ϣ",bmpNpc,EnumDirect.SOUTH);
//		p.x=8;
//		p.y=2;
//		
//		Event e1_1=new Event(p,"��֪��ϲ��ϲ������");
//		Event e1=new Event(p,"������Ů������~~");
//		e1.setNextEvent(e1_1);
//		
//		
//		PlotItem pi=new PlotItem("sony","���������","getSony" );
//		pi.description="�ĵ����������";
//		Event e2_2=new Event(p,"������������ɣ�");
//		
//		ItemEvent itemEvent=new ItemEvent(new ItemQty(pi,1));
//		itemEvent.RegisterKeyEvent("getSony");
//
//		e2_2.setNextEvent(itemEvent);
//
//		Event e2_k=new Event(p,"�㶮��");
//		
//		Event e2_1=new Event(p,"�����˶�֪����");
//		e2_1.setNextEvent(itemEvent);
//		
//		Event e2=new Event(p,"������������");
//		e2.setNextEvent(e2_1);
//
//		SwitchCheckYesEvent e1_2=new SwitchCheckYesEvent(p,"",e2_k,e2,"getSony",true);
//		
//		SwitchCheckYesEvent e0=new SwitchCheckYesEvent(p,"",e1_2,e1,"wantml",true);
//		
//		p.SetTalkingEvent(e0);
//		
//		return p;
//	}

	public Scene getScene(String startScene) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}
