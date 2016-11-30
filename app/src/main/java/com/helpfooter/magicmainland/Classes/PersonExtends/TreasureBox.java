package com.helpfooter.magicmainland.Classes.PersonExtends;

import com.helpfooter.magicmainland.tools.ImageShower;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Classes.EventExtends.ItemEvent;
import android.graphics.Bitmap;
import android.util.Log;

public class TreasureBox extends NPC {

	ImageShower openedImage;
	ItemEvent itemEvent;
	
	
	public TreasureBox(String id, Bitmap image,Bitmap openedImage,ItemEvent itemEvent) {
		super( id,"", image);
		// TODO Auto-generated constructor stub
	
		this.openedImage=new ImageShower(openedImage, 0, 0, 1, 1);
		this.itemEvent=itemEvent;
		
		KeyEventManager kem=KeyEventManager.getInstance();
		boolean isOpened=kem.getEventIsCompleted(itemEvent.eventId);
		if(isOpened){
			this.img=this.openedImage;
		}
	}

	public void Talking(String defaultDirect){
		
		KeyEventManager kem=KeyEventManager.getInstance();
		boolean isOpened=kem.getEventIsCompleted(itemEvent.eventId);
		Log.d("diao",String.valueOf(isOpened) );
		
		if(isOpened){
			Event event=new Event("","","�����ǿյġ�");
			event.doAction();
		}else{
			itemEvent.doAction();
			this.img=this.openedImage;
		}
	}

}
