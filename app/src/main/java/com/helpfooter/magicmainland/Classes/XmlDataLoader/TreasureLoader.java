package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import com.helpfooter.magicmainland.Utils.ImageFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.helpfooter.magicmainland.tools.XmlReader;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Classes.EventExtends.ItemEvent;
import com.helpfooter.magicmainland.Classes.PersonExtends.TreasureBox;

public class TreasureLoader extends ObjectLoader {
	
	public TreasureLoader() {
		super("treasure");
		// TODO Auto-generated constructor stub
		 
	}

	private static TreasureLoader instance=null;
	
	public static TreasureLoader GetInstance(){
		if(instance==null){
			instance=new TreasureLoader();
		}
		return instance;
	}
	
	public TreasureBox getTreasureBox(String treasureId){
		XmlReader xml=getNodeReader(treasureId,"id");
		

		String id=xml.getText("id");
		String closeimg=xml.getText("closeimg");
		String openimg=xml.getText("openimg");
		String event=xml.getText("event");
		String direct=xml.getText("direct");
		Bitmap closeBitmap = ImageFactory.GetInstance().getImage(this.imgPath+closeimg);
		Bitmap openBitmap = ImageFactory.GetInstance().getImage(this.imgPath+openimg);
		Event e=EventLoader.GetInstance().getEvent(event);
		
		TreasureBox tb=new TreasureBox(id, closeBitmap, openBitmap,(ItemEvent)e);
		
		return tb;
		
	}

}
