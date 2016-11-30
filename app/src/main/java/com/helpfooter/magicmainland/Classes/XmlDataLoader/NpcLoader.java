package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import com.helpfooter.magicmainland.Utils.ImageFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.helpfooter.magicmainland.tools.XmlReader;
import com.helpfooter.magicmainland.Classes.PersonExtends.NPC;

public class NpcLoader  extends ObjectLoader {
	
	private NpcLoader() {
		super("npc");
		// TODO Auto-generated constructor stub
		 
	}

	private static NpcLoader instance=null;
	
	public static NpcLoader GetInstance(){
		if(instance==null){
			instance=new NpcLoader();
		}
		return instance;
	}
	
	public NPC getNpc(String npcId){
		XmlReader xml=getNodeReader(npcId,"id");

		String id=xml.getText("id");
		String name=xml.getText("name");
		String img=xml.getText("img");
		String event=xml.getText("event");
		String direct=xml.getText("direct");
		
		Bitmap imageBitmap = ImageFactory.GetInstance().getImage(this.imgPath+img);
		NPC npc=new NPC(id, name, imageBitmap);
		npc.direct=direct;
		npc.SetTalkingEvent(EventLoader.GetInstance().getEvent(event));
		
		return npc;
		
	}
	
}
