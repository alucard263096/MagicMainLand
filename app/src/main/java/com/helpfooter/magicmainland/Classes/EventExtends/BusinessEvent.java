package com.helpfooter.magicmainland.Classes.EventExtends;

import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.BusinessDialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.YesNoDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPriceCatalog;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;
import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.EnumDialogOption;

public class BusinessEvent extends Event {
	
	ItemPriceCatalog priceCatalog;
	BusinessDialog businessDialog;
	int cursor=1;
	private boolean readyPaymentModel=false;
	EnumDialogOption dialogSelected;
	
	public BusinessEvent(String id,String name,ItemPriceCatalog priceCatalog) {
		super( id, name, "");
		// TODO Auto-generated constructor stub
		this.priceCatalog=priceCatalog;
	}
	
	public void doAction(){
		priceCatalog.reset();
		cursor=1;
		super.doAction();
	}


	public IDialog getDialog() {
		// TODO Auto-generated method stub
		
		Luggage luggage= StaticObject.StarHero.luggage;
		
		businessDialog=new BusinessDialog(luggage.amount);
		businessDialog.setItemCursor(1);
		businessDialog.updatePriceItemData(priceCatalog);
		return businessDialog;
	}
	
	public void setControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if( readyPaymentModel==false){
			if(irButton==EnumControllerButton.DOWN){
				cursor++;
				if(cursor>priceCatalog.getItemTypeQty()){
					cursor=priceCatalog.getItemTypeQty();
				}
				businessDialog.setItemCursor(cursor);
			}
			else if(irButton==EnumControllerButton.UP){
				cursor--;
				if(cursor<1){
					cursor=1;
				}
				businessDialog.setItemCursor(cursor);
			}
			else if(irButton==EnumControllerButton.RIGHT){
				int qty=priceCatalog.alBuyAccount.get(cursor-1);
				qty++;
				if(qty>99){
					qty=99;
				}
				priceCatalog.alBuyAccount.set(cursor-1, qty);
				businessDialog.updatePriceItemData(priceCatalog);
				businessDialog.updatePayAmount(priceCatalog.getAmount());
			}
			else if(irButton==EnumControllerButton.LEFT){
				int qty=priceCatalog.alBuyAccount.get(cursor-1);
				qty--;
				if(qty<0){
					qty=0;
				}
				priceCatalog.alBuyAccount.set(cursor-1, qty);
				businessDialog.updatePriceItemData(priceCatalog);
				businessDialog.updatePayAmount(priceCatalog.getAmount());
			}
			else if(irButton==EnumControllerButton.A){
				Luggage luggage=StaticObject.StarHero.luggage;
				int amount=priceCatalog.getAmount();
				if(amount>0){
					if(luggage.amount>=amount){
						businessDialog.showReadyPayment();
						this.readyPaymentModel=true;
						dialogSelected=EnumDialogOption.YES;
						businessDialog.readyPaySetOption(dialogSelected);
					}
					else{
						businessDialog.showNotEnoughMoney();
					}
				}
			}
			else if(irButton==EnumControllerButton.B){
				
				this.setNextDialog();
				
			}
		}
		else{
			if(irButton==EnumControllerButton.DOWN){
				dialogSelected=EnumDialogOption.NO;
				businessDialog.readyPaySetOption(dialogSelected);
			}
			else if(irButton==EnumControllerButton.UP){
				dialogSelected=EnumDialogOption.YES;
				businessDialog.readyPaySetOption(dialogSelected);
			}
			else if(irButton==EnumControllerButton.A){
				if(dialogSelected==EnumDialogOption.YES){
					Luggage luggage=StaticObject.StarHero.luggage;
					luggage.addItem(priceCatalog);
					luggage.addMoney(-1*priceCatalog.getAmount());
					this.readyPaymentModel=false;
					this.setNextDialog();
				}
				else if(dialogSelected==EnumDialogOption.NO){
					this.readyPaymentModel=false;
					businessDialog.setSelectedItemModel();
				}
			}
		}
		//
	}
}
