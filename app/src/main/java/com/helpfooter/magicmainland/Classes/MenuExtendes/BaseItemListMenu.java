package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Utils.EnumControllerButton;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.ItemShowDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;

public abstract class BaseItemListMenu extends Menu {

	ArrayList<ItemQty> itemQties;
	ItemShowDialog itemShowDialog;
	int pcoursor=1;
	

	public BaseItemListMenu(String name) {
		super(name, 1);
		// TODO Auto-generated constructor stub
	}
	
	public void itemListInitialization(){
		
	}

	public void initialization() {
		// TODO Auto-generated method stub
		
		itemListInitialization();
		
		selectedMenu=null;
		isOptionSeleted=false;
		cursor=0;
		
		pcoursor=1;
		
		
		dialog=itemShowDialog;
		
		
	}
	

	public void notSelectedSetControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		
		if(irButton==EnumControllerButton.DOWN){
			pcoursor++;
			if(pcoursor>itemQties.size()){
				pcoursor=itemQties.size();
			}
			itemShowDialog.setItemCursor(pcoursor);
		}
		else if(irButton==EnumControllerButton.UP){
			pcoursor--;
			if(pcoursor<1){
				pcoursor=1;
			}
			itemShowDialog.setItemCursor(pcoursor);
		}
		else if(irButton==EnumControllerButton.A){
			buttonAEvent();
		}
		else if(irButton==EnumControllerButton.B){
			buttonBEvent();
		}
	}
	
	public void buttonAEvent(){
		
	}
	
	public void buttonBEvent(){
		superMenu.isOptionSeleted=false;
	}

	public void reloadItemList() {
		// TODO Auto-generated method stub
		int ccursor=pcoursor;
		initialization();
		pcoursor=ccursor;
		if(pcoursor>itemQties.size()){
			pcoursor=itemQties.size();
		}
		itemShowDialog.setItemCursor(pcoursor);
	}
	
	
	
}
