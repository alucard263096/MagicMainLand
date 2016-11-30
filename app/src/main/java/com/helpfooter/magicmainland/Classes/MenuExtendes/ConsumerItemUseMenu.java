package com.helpfooter.magicmainland.Classes.MenuExtendes;

import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Classes.MenuManager;
import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.HeroStatusDialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.ItemShowDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.ClassesItemExtends.ConsumableItem;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class ConsumerItemUseMenu extends QueueMenu {

	ItemQty itemQty;
	
	public ConsumerItemUseMenu(ItemQty itemQty) {
		super("");
		// TODO Auto-generated constructor stub
		
		menuStartX=(int)(4*GameConfig.BUTTON_SIZE+5*GameConfig.BUTTON_ARGIN);
		this.itemQty=itemQty;
	}
	
	public void initialization(){
		super.initialization();
		
		if(((ConsumableItem)itemQty.item).isQueueUse){
			optionDialog.selectAll=true;
		}
	}
	

	public void notSelectedSetControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		
		if(irButton==EnumControllerButton.DOWN){
			if(cursor+colNum<alOp.size()){
				cursor+=colNum;
			}
		}
		else if(irButton==EnumControllerButton.UP){

			if(cursor-colNum>=0){
				cursor-=colNum;
			}
		}
		else if(irButton==EnumControllerButton.RIGHT){
			cursor++;
			if(cursor>=alOp.size()){
				cursor=alOp.size()-1;
			}
		}
		else if(irButton==EnumControllerButton.LEFT){
			cursor--;
			if(cursor<0){
				cursor=0;
			}
		}
		else if(irButton==EnumControllerButton.A){

			FightPerson fightPerson=super.alFightPerson.get(cursor);
			Luggage luggage=StaticObject.StarHero.luggage;
			luggage.consumerItem(fightPerson,itemQty);
			if(itemQty.qty==0){
				//superMenu.alOp.remove(superMenu.cursor-1);
				ConsumerItemListMenu ilm=(ConsumerItemListMenu)superMenu;
				ilm.reloadItemList();
			}
		}
		else if(irButton==EnumControllerButton.B){			
			super.notSelectedSetControll(irButton);
		}
		if(optionDialog!=null){
			optionDialog.setCursor(cursor);
		}
	}

	
	
	
	

	
}
