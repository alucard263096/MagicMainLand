package com.helpfooter.magicmainland.Classes.MenuExtendes;

import android.content.res.Resources;
import com.helpfooter.magicmainland.Classes.SceneView;
import com.helpfooter.magicmainland.Common.StaticObject;

public class StartGameItem extends BaseItemListMenu  {
	
	public StartGameItem(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		StaticObject.GameCpu.ChangeGameStatu(new SceneView(StaticObject.GameCpu,StaticObject.Resources));
	}

}
