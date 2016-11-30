package com.helpfooter.magicmainland.ClassesItemExtends;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import android.util.Log;

import com.helpfooter.magicmainland.Classes.EventRecord;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.EventExtends.SwitchEvent;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;


public class Luggage {

	public ArrayList<ItemQty> alConsumableItems=new ArrayList<ItemQty>();
	public ArrayList<ItemQty> alEquipments=new ArrayList<ItemQty>();
	public ArrayList<ItemQty> alPlotItems=new ArrayList<ItemQty>();
	
	public int amount=0;
	
	private static Luggage instance=null;
	public static Luggage getInstance(){
		
		if(instance==null){
			instance=new Luggage();
		}
		return instance;
	}

	private Luggage(){
		
	}
	
	

	public void addItem(ItemQty itemQty) {
		// TODO Auto-generated method stub
		if(itemQty.qty>0){
			Item item=itemQty.item;
			ArrayList<ItemQty> alItem=getItemTypeAl(item);
			addItemTypeItemQty(alItem,itemQty);
		}
	}

	private void addItemTypeItemQty(
		ArrayList<ItemQty> alItem, ItemQty itemQty) {
		// TODO Auto-generated method stub
		if(itemQty.item==null){
			Log.d("itemnull", "y");
		}
		if(itemQty.item.canCombine==false){
			for(int i=0;i<itemQty.qty;i++){
				alItem.add(new ItemQty((Item)itemQty.item.clone(), 1));
			}
		}else{
			boolean isAdded=false;
			int qtySize=alItem.size();
			for(int i=0;i<qtySize;i++){
				ItemQty itemqty=alItem.get(i);
				if(itemqty.item.id.equals(itemQty.item.id)){
					Log.d("sameitem", "t");
					itemqty.qty+=itemQty.qty;
					isAdded=true;
					break;
				}
			}
			if(isAdded==false){
				Log.d("sameitem", "f");
				alItem.add(itemQty);
			}
		}
	}

	private ArrayList<ItemQty> getItemTypeAl(Item item) {
		// TODO Auto-generated method stub
		if(item instanceof ConsumableItem){
			return alConsumableItems;
		}else if(item instanceof Equipment){
			return alEquipments;
		}else if(item instanceof PlotItem){
			return alPlotItems;
		}
		return null;
	}

	public void addMoney(int amount) {
		// TODO Auto-generated method stub
		this.amount+=amount;
	}

	public void addItem(ItemPriceCatalog priceCatalog) {
		// TODO Auto-generated method stub
		int amount=0;
		int count=priceCatalog.alItemPrice.size();
		for(int i=0;i<count;i++){
			ItemPrice ip=priceCatalog.alItemPrice.get(i);
			int qty=priceCatalog.alBuyAccount.get(i);
			ItemQty iq=new ItemQty(ip.item, qty);
			this.addItem(iq);
		}
		
	}

	public void consumerItem(FightPerson fightPerson, ItemQty itemQty) {
		// TODO Auto-generated method stub
		ConsumableItem item=(ConsumableItem)itemQty.item;
		if(item.isQueueUse){
			item.use();
		}
		else{
			item.use(fightPerson);
		}
		
		 if(item.isNotConsumable==false){
			 itemQty.qty--;
		 }
		 if(itemQty.qty<=0){
			 alConsumableItems.remove(itemQty);
		 }
	}

	public void loadEquipment(ArrayList<FightPerson> alFightPerson, FightPerson fightPerson, ItemQty itemQty) {
		// TODO Auto-generated method stub

		
		Equipment item=(Equipment)itemQty.item;
		fightPerson.equipmentSuit.load(item);
	}

	
	
	
}
