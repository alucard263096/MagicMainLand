package com.helpfooter.magicmainland.Classes;

import com.helpfooter.magicmainland.Classes.MenuExtendes.EquipmentListMenu;
import com.helpfooter.magicmainland.Classes.MenuExtendes.ConsumerItemListMenu;
import com.helpfooter.magicmainland.Classes.MenuExtendes.Menu;
import com.helpfooter.magicmainland.Classes.MenuExtendes.PlotItemListMenu;
import com.helpfooter.magicmainland.Classes.MenuExtendes.QueueMenu;

public class MenuManager extends AbstractMenu {
	
	private static MenuManager instance=null;
	
	
	public static MenuManager getInstance(){
		
		if(instance==null){
			instance=new MenuManager();
		}
		return instance;
	}
	
	private MenuManager(){
		mainMenu=getSystemMenu();
	}
	
	public Menu getSystemMenu(){
		
		Menu m1=new Menu("���˵�",2);
		QueueMenu m1_1=new QueueMenu("״̬");
		m1.addOption(m1_1);
		
		m1.addOption(new PlotItemListMenu("����Ʒ"));
		m1.addOption(new ConsumerItemListMenu("����"));
		m1.addOption(new EquipmentListMenu("װ��"));
		m1.addOption(new Menu("��ͼ", 0));
		
		
		Menu sm=new Menu("ϵͳ", 1);
		sm.addOption(new Menu("�浵", 0));
		sm.addOption(new Menu("��ȡ", 0));
		sm.addOption(new Menu("�˳�", 0));
		m1.addOption(sm);
		
		
		return m1;
	}
	

}
