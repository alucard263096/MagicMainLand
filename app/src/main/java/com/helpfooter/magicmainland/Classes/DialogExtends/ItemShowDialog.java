package com.helpfooter.magicmainland.Classes.DialogExtends;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class ItemShowDialog implements IDialog {
	
	ArrayList<ItemQty> alIq;
	Dialog descriptionDialog;
	DialogShowForm sd;
	int x0;
	int y0;
	int x1;
	int y1;
	int cursor=1;
	int showCursor=1;
	Paint paint;
	
	public ItemShowDialog(ArrayList<ItemQty> alIq) {
		// TODO Auto-generated constructor stub
		this.alIq=alIq;
		
		sd=new DialogShowForm();
		x0=(int) GameConfig.BUTTON_ARGIN;
		y0=(int)GameConfig.BUTTON_ARGIN;
		x1=x0+GameConfig.ITEMNAMESTRLEN/2*(int)(GameConfig.COMMONSIZE)+(int)GameConfig.COMMONSIZE;
		y1=(int)(4*GameConfig.BUTTON_SIZE);
		
		sd.setBounds(x0, y0, x1, y1);

		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setTextSize(14);
		descriptionDialog=new Dialog("", "");
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		sd.draw(canvas);
		
		int itemPriceCatalogCount=alIq.size();

		
		//if(cursor>itemPriceCatalogCount)
		for(int i=1;i<=itemPriceCatalogCount&&i<=GameConfig.BUSINESS_SALE_ITEM_NUMBER;i++){
			int j=showCursor+i-1;
			ItemQty ip=alIq.get(j-1);
			int qty=ip.qty;
			
			
			String itemName=getItemShowName(ip);
			
			canvas.drawText(itemName, x0+(int)GameConfig.BUTTON_ARGIN+GameConfig.BUTTON_ARGIN, y0+(int)(i*2*GameConfig.BUTTON_ARGIN), paint);
			if(ip.item.canCombine){
				canvas.drawText(String.valueOf(qty), x1-(int)GameConfig.COMMONSIZE-GameConfig.BUTTON_ARGIN, y0+(int)(i*2*GameConfig.BUTTON_ARGIN), paint);
			}
			
			if(j==cursor){
				YesNoDialog.drawSelectedTrangle(canvas, x0+(int)GameConfig.BUTTON_ARGIN, y0+(int)(i*2*GameConfig.BUTTON_ARGIN)-(int)GameConfig.BUTTON_ARGIN);
				descriptionDialog.msg=ip.item.description;
				descriptionDialog.draw(canvas);
				
				drawPointToItem(canvas,ip);
				
			}
		}
	}
	
	public String getItemShowName(ItemQty ip) {
		// TODO Auto-generated method stub
		return ip.item.name;
	}

	public void drawPointToItem(Canvas canvas, ItemQty ip) {
		// TODO Auto-generated method stub
		
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

}
