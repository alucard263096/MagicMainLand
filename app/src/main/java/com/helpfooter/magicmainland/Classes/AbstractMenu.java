package com.helpfooter.magicmainland.Classes;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.graphics.Canvas;
import com.helpfooter.magicmainland.Classes.MenuExtendes.Menu;


public class AbstractMenu {

	public Menu mainMenu;
	public boolean isMenuModel;
	

	public void draw(Canvas canvas){
		if(isMenuModel){
		mainMenu.draw(canvas);
		}
	}

	public void setOperationButton(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(isMenuModel){
			mainMenu.setControll(irButton);
		}
	}
	
	public void showMenu(){
		isMenuModel=true;
		
		mainMenu.initialization();
	}
}
