package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import android.util.Log;
import com.helpfooter.magicmainland.Classes.MenuManager;
import com.helpfooter.magicmainland.Classes.DialogExtends.HeroStatusDialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.OptionDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;

public class HeroStatusMenu extends Menu {

	FightPerson fightPerson;
	HeroStatusDialog statusDialog;
	
	
	public HeroStatusMenu(String name,FightPerson fightPerson) {
		super(name,1);
		// TODO Auto-generated constructor stub
		this.fightPerson= fightPerson;
	}
	
	public void initialization() {
		// TODO Auto-generated method stub
		
		statusDialog=new HeroStatusDialog(fightPerson);
		dialog=statusDialog;
	}
	
	public void selectedSetControll(EnumControllerButton irButton) {
		
	}

	public void notSelectedSetControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(this.superMenu!=null){
			if(irButton==EnumControllerButton.DOWN
				||irButton== EnumControllerButton.LEFT
				||irButton== EnumControllerButton.RIGHT
				||irButton== EnumControllerButton.UP){
			
				superMenu.isOptionSeleted=false;
				superMenu.setControll(irButton);
				superMenu.setControll(EnumControllerButton.A);
			}
			else if(irButton==EnumControllerButton.B){			
				superMenu.isOptionSeleted=false;
			}
		}
	}
}
