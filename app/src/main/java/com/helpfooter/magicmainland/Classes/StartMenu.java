package com.helpfooter.magicmainland.Classes;


import com.helpfooter.magicmainland.Classes.MenuExtendes.Menu;
import com.helpfooter.magicmainland.Classes.MenuExtendes.StartGameItem;
import com.helpfooter.magicmainland.Common.GameCpu;

public class StartMenu extends AbstractMenu {
	
private GameCpu cpu;

public  StartMenu(GameCpu cpu){
	this.cpu=cpu;
		mainMenu=new Menu("���˵�",1);
		
		mainMenu.addOption(new StartGameItem("��ʼ��Ϸ"));
		mainMenu.addOption(new Menu("��ȡ�浵", 0));
		
		
	}
}
