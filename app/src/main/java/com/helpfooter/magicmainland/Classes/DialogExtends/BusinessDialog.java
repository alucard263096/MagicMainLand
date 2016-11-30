package com.helpfooter.magicmainland.Classes.DialogExtends;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.helpfooter.magicmainland.ClassesItemExtends.ItemPrice;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPriceCatalog;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.EnumDialogOption;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class BusinessDialog implements IDialog {
	
	ItemPriceCatalog itemPriceCatalog;
	Paint paint;
	

	int balance=0;
	DialogShowForm cashSd;
	DialogShowForm sd;
	int x0;
	int y0;
	int x1;
	int y1;
	 int cursor=1;
	 int showCursor=1;
	
	
	public BusinessDialog(int balance){
		sd=new DialogShowForm();
		x0=(int) GameConfig.BUTTON_ARGIN;
		y0=(int)GameConfig.BUTTON_ARGIN;
		
		qtyX=x0+GameConfig.ITEMNAMESTRLEN/2*(int)(GameConfig.COMMONSIZE);
		priceX=qtyX+(int)(GameConfig.COMMONSIZE);
		x1=priceX+(int)(2*GameConfig.BUTTON_ARGIN+GameConfig.COMMONSIZE);
		
		y1=(int)(4*GameConfig.BUTTON_SIZE);
		
		sd.setBounds(x0, y0, x1, y1);
		cashSd=new DialogShowForm();
		cashSd.setBounds(x1+2*(int)GameConfig.BUTTON_ARGIN, y0, x1+2*(int)GameConfig.BUTTON_ARGIN+4*(int)GameConfig.BUTTON_SIZE, y0+2*(int)GameConfig.BUTTON_ARGIN);
		
		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setTextSize(14);
		
		this.balance=balance;
	}
	
	int qtyX;
	int priceX;
	
	public void updatePriceItemData(ItemPriceCatalog ip){
		this.itemPriceCatalog=ip;
	}
	
	public void setItemCursor(int cursor){
		
		if(cursor>this.cursor){
			this.cursor=cursor;
			showCursorDown();
		}
		else if(cursor<this.cursor){
			this.cursor=cursor;
			showCursorUp();
		}
		//Log.d("ckc",String.valueOf(this.cursor) );
		//Log.d("ckca",String.valueOf(this.showCursor) );
		
	}
	public void showCursorUp(){
		while(showCursor>this.cursor){
			showCursor--;
		}
	}
	public void showCursorDown(){
		while(showCursor+GameConfig.BUSINESS_SALE_ITEM_NUMBER-1<this.cursor){
			showCursor++;
		}
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		cashSd.draw(canvas);
		
		canvas.drawText("�ֽ�"+String.valueOf(this.balance)+"G", x1+3*(int)GameConfig.BUTTON_ARGIN, y0+(int)(2*GameConfig.BUTTON_ARGIN)-5, paint);
		
		sd.draw(canvas);
		
		int itemPriceCatalogCount=this.itemPriceCatalog.getItemTypeQty();

		
		//if(cursor>itemPriceCatalogCount)
		for(int i=1;i<=itemPriceCatalogCount&&i<=GameConfig.BUSINESS_SALE_ITEM_NUMBER;i++){
			
			int j=showCursor+i-1;
			
			ItemPrice ip=this.itemPriceCatalog.alItemPrice.get(j-1);
			int qty=this.itemPriceCatalog.alBuyAccount.get(j-1);
			
			
			canvas.drawText(ip.item.name, x0+(int)GameConfig.BUTTON_ARGIN+GameConfig.BUTTON_ARGIN, y0+(int)(i*2*GameConfig.BUTTON_ARGIN), paint);
			canvas.drawText(String.valueOf(qty), qtyX, y0+(int)(i*2*GameConfig.BUTTON_ARGIN), paint);
			canvas.drawText(String.valueOf(ip.price), priceX, y0+(int)(i*2*GameConfig.BUTTON_ARGIN), paint);
			
			if(j==cursor){
				YesNoDialog.drawSelectedTrangle(canvas, x0+(int)GameConfig.BUTTON_ARGIN, y0+(int)(i*2*GameConfig.BUTTON_ARGIN)-(int)GameConfig.BUTTON_ARGIN);
			}
			
		}
		
		canvas.drawText(String.valueOf(amount), x0+3*(int)GameConfig.COMMONSIZE, y0+(int)(7*2*GameConfig.BUTTON_ARGIN)+(int)(0.5*GameConfig.BUTTON_ARGIN), paint);
		
		if(showNotEnoughMoneydialog){
			notEnoughMoneydialog.draw(canvas);
		}
		if(showReadyPaymentdialog){
			readyPaymentdialog.draw(canvas);
		}
	}
	int amount=0;
	public void updatePayAmount(int amount) {
		// TODO Auto-generated method stub
		this.amount=amount;
	}
	boolean showNotEnoughMoneydialog=false;
	Dialog notEnoughMoneydialog;
	public void showNotEnoughMoney() {
		// TODO Auto-generated method stub
		showNotEnoughMoneydialog=true;
		showReadyPaymentdialog=false;
		if(notEnoughMoneydialog==null){
			notEnoughMoneydialog=new Dialog("�������Ѳ��࣬�뼰ʱ��ֵ��", "");
		}
	}
	
	boolean showReadyPaymentdialog=false;
	YesNoDialog readyPaymentdialog;
	public void showReadyPayment() {
		// TODO Auto-generated method stub
		showReadyPaymentdialog=true;
		showNotEnoughMoneydialog=false;
		if(readyPaymentdialog==null){
			readyPaymentdialog=new YesNoDialog("һ������ô��ô��", "");
		}
	}

	public void readyPaySetOption(EnumDialogOption dialogSelected) {
		// TODO Auto-generated method stub
		if(readyPaymentdialog!=null){
			readyPaymentdialog.setYesNo(dialogSelected);
		}
	}

	public void setSelectedItemModel() {
		// TODO Auto-generated method stub
		showReadyPaymentdialog=false;
		showNotEnoughMoneydialog=false;
	}

}
