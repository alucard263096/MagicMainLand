package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.graphics.Bitmap;
import android.util.Log;
import com.helpfooter.magicmainland.Utils.ImageFactory;
import com.helpfooter.magicmainland.Classes.MapSpaceExtends.MapSpace;
import com.helpfooter.magicmainland.Classes.PersonExtends.GameObject;
import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;
import com.helpfooter.magicmainland.tools.XmlReader;

public class StuffLoader extends ObjectLoader {
	
	private static StuffLoader instance=null;
	
	public static StuffLoader GetInstance(){
		if(instance==null){
			instance=new StuffLoader();
		}
		return instance;
	}
	
	private StuffLoader() {
		super("stuff");
		// TODO Auto-generated constructor stub
	}
	
	public GameObject getStuff(String id){
		
		XmlReader xml=getNodeReader(id,"id");

		 String img=xml.getText("img");
		 int positionx=Integer.parseInt(xml.getText("positionx"));
		 int positiony=Integer.parseInt(xml.getText("positiony"));
		 int width=Integer.parseInt(xml.getText("width"));
		 int height=Integer.parseInt(xml.getText("height"));
		 
		Bitmap bitmap=ImageFactory.GetInstance().getImage(this.imgPath+img);
		Log.d("ung", this.imgPath+img);
		GameObject obj=new GameObject(id, bitmap, positionx, positiony, width, height);
		
		Node spaceNode=xml.getNode("spaces");
		setSpaces(obj,spaceNode);
		
		return obj;
		
		
		
	}

	private void setSpaces(GameObject obj, Node spaceNode) {
		// TODO Auto-generated method stub
		NodeList backNs= spaceNode.getChildNodes();
		for (int i = 0; i < backNs.getLength(); i++)
        {
			Node back=backNs.item(i);
			if (back.getNodeType() == Node.ELEMENT_NODE){
				NodeList ns = back.getChildNodes();
				XmlReader xml=new XmlReader(ns);	

				 int x=Integer.parseInt(xml.getText("x"));
				 int y=Integer.parseInt(xml.getText("y"));
				 
				 obj.setSpace(x, y);
			}
        }
	}

}
