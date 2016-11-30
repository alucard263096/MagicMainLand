package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import android.graphics.Bitmap;
import com.helpfooter.magicmainland.Utils.ImageFactory;
import com.helpfooter.magicmainland.Classes.MapSpaceExtends.MapSpace;
import com.helpfooter.magicmainland.tools.XmlReader;

public class MapLoader extends ObjectLoader {
	
	private MapLoader() {
		super("map");
		// TODO Auto-generated constructor stub
		 
	}

	private static MapLoader instance=null;
	
	public static MapLoader GetInstance(){
		if(instance==null){
			instance=new MapLoader();
		}
		return instance;
	}
	
	public MapSpace getMapSpace(String id){
		
		XmlReader xml=getNodeReader(id,"id");

		 String img=xml.getText("img");
		 int positionx=Integer.parseInt(xml.getText("positionx"));
		 int positiony=Integer.parseInt(xml.getText("positiony"));
		 int width=Integer.parseInt(xml.getText("width"));
		 int height=Integer.parseInt(xml.getText("height"));
		 
		Bitmap bitmap=ImageFactory.GetInstance().getImage(this.imgPath+img);
		 
		 
		 
		MapSpace map=new MapSpace(bitmap, positionx, positiony, width, height);
		
		return map;
	}

}
