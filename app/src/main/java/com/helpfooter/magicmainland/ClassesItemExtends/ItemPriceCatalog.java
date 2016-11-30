package com.helpfooter.magicmainland.ClassesItemExtends;

import java.util.ArrayList;

public class ItemPriceCatalog {
	
	public ArrayList<ItemPrice> alItemPrice=new ArrayList<ItemPrice>();
	public ArrayList<Integer> alBuyAccount=new ArrayList<Integer>();
	
	public void addItem(Item item,int price){
	
		ItemPrice itemPrice=new ItemPrice(item, price);
		alItemPrice.add(itemPrice);
	
	}
	
	public void addItem(ItemPrice itemPrice){

		alItemPrice.add(itemPrice);
		alBuyAccount.add(0);
		
	}
	
	public int getItemTypeQty(){
		return alItemPrice.size();
	}
	
	public int getAmount(){
		int amount=0;
		int count=alItemPrice.size();
		for(int i=0;i<count;i++){
			ItemPrice ip=alItemPrice.get(i);
			int qty=alBuyAccount.get(i);
			if(qty>0){
				amount+=ip.price*qty;
			}
		}
		
		return amount;
	}

	public void reset() {
		// TODO Auto-generated method stub
		int count=alItemPrice.size();
		for(int i=0;i<count;i++){
			alBuyAccount.set(i, 0);
		}
	}
}
