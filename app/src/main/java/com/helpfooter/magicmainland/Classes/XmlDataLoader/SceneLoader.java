package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.helpfooter.magicmainland.Utils.ConstSpaceType;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.helpfooter.magicmainland.tools.XmlReader;

import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Classes.EventExtends.SceneAppearCondition;
import com.helpfooter.magicmainland.Classes.MapSpaceExtends.EventSpace;
import com.helpfooter.magicmainland.Classes.MapSpaceExtends.MapSpace;
import com.helpfooter.magicmainland.Classes.PersonExtends.GameObject;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Classes.PersonExtends.TreasureBox;
import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;
import com.helpfooter.magicmainland.Classes.SceneCore.Scene;
import com.helpfooter.magicmainland.Classes.SceneCore.SceneMap;
import com.helpfooter.magicmainland.ClassesItemExtends.Item;

public class SceneLoader extends ObjectLoader {

	Dictionary<String,XmlReader> dictRecord=new Hashtable<String,XmlReader>();

	private static SceneLoader instance=null;
		
	public static SceneLoader GetInstance(){
		if(instance==null){
			instance=new SceneLoader();
		}
		return instance;
	}
	
	
	private SceneLoader() {
		super("scene");
		// TODO Auto-generated constructor stub
	}
	
	public Scene getScene(String sceneId){
		
		XmlReader xml=getNodeReader(sceneId,"id");
		String name=xml.getText("name");
		int width=Integer.parseInt(xml.getText("width"));
		int height=Integer.parseInt(xml.getText("height"));
		//Bitmap bmpBack = BitmapFactory.decodeFile(this.imgPath+bgimg);
		//SceneMap map=new SceneMap(bmpBack,length,height);
		SceneMap map=new SceneMap(width, height);
		Node backNode=xml.getNode("background");
		getMap(map,backNode);
		
		Node stuffNode=xml.getNode("stuffs");
		getStuff(map,stuffNode);
		
		//Node spaceNode=xml.getNode("spaces");
		
		//setSpace(map,spaceNode);
		
		ArrayList<ObjectPosition> alPerson=new ArrayList<ObjectPosition>();
//
		Node npcsNode=xml.getNode("npcs");
//		
		setPerson(alPerson,npcsNode);
//
		Node treasuresNode=xml.getNode("treasures");
//
		setTreasure(alPerson,treasuresNode);
		
		Scene scene=new Scene(map);
		scene.alPerson=alPerson;
		
		return scene;
	}
	
	private void getStuff(SceneMap map, Node stuffNode) {
		// TODO Auto-generated method stub

		NodeList backNs= stuffNode.getChildNodes();
		for (int i = 0; i < backNs.getLength(); i++)
        {
			Node back=backNs.item(i);
			if (back.getNodeType() == Node.ELEMENT_NODE){
				NodeList ns = back.getChildNodes();
				XmlReader xml=new XmlReader(ns);	

				 String value=xml.getText("id");
				 int x=Integer.parseInt(xml.getText("x"));
				 int y=Integer.parseInt(xml.getText("y"));
				 
				GameObject obj=StuffLoader.GetInstance().getStuff(value);
				ObjectPosition op=new ObjectPosition(obj, x, y);
				 map.setObject(x, y, op);
				
			}
        }
	}


	private void getMap(SceneMap map,Node backNode) {
		// TODO Auto-generated method stub
		
		NodeList backNs= backNode.getChildNodes();
		for (int i = 0; i < backNs.getLength(); i++)
        {
			Node back=backNs.item(i);
			if (back.getNodeType() == Node.ELEMENT_NODE){
				NodeList ns = back.getChildNodes();
				XmlReader xml=new XmlReader(ns);	

				 String value=xml.getText("value");
				 int x=Integer.parseInt(xml.getText("x"));
				 int y=Integer.parseInt(xml.getText("y"));
				 
				 MapSpace ms=MapLoader.GetInstance().getMapSpace(value);
				 map.setMap(x, y, ms);
				
			}
        }
	}


	private void setTreasure(ArrayList<ObjectPosition> alPerson, Node treasuresNode) {
		// TODO Auto-generated method stub
		NodeList treasureNs= treasuresNode.getChildNodes();
		for (int i = 0; i < treasureNs.getLength(); i++)
        {
			Node treasure=treasureNs.item(i);
			if (treasure.getNodeType() == Node.ELEMENT_NODE){
			 NodeList ns = treasure.getChildNodes();
			 XmlReader xml=new XmlReader(ns);		 
			 String value=xml.getText("value");
			 int x=Integer.parseInt(xml.getText("x"));
			 int y=Integer.parseInt(xml.getText("y"));
			 
			 TreasureBox tb=TreasureLoader.GetInstance().getTreasureBox(value);
//			 tb.x=x;
//			 tb.y=y;
				ObjectPosition obj=new ObjectPosition(tb, x, y);
				alPerson.add(obj);
			}
        }
	}


	private void setPerson(ArrayList<ObjectPosition> alPerson, Node npcsNode) {
		// TODO Auto-generated method stub
		NodeList npcNs= npcsNode.getChildNodes();
		for (int i = 0; i < npcNs.getLength(); i++)
        {
			Node npc=npcNs.item(i);
			if (npc.getNodeType() == Node.ELEMENT_NODE){
				NodeList ns = npc.getChildNodes();
				 XmlReader xml=new XmlReader(ns);
				 
				 String notdocondition=xml.getText("notdocondition");			 
				 String docodition=xml.getText("docodition");			 
				 String value=xml.getText("value");
				 
				 int x=Integer.parseInt(xml.getText("x"));
				 int y=Integer.parseInt(xml.getText("y"));
				 
				 SceneAppearCondition appcod=new SceneAppearCondition();
				 if(notdocondition.length()>0){
					 appcod.AddNotOccurEvent(notdocondition);
				 }
				 if(docodition.length()>0){
					 appcod.AddOccurEvent(docodition);
				 }
					
				if(appcod.getAppearStatus()){
					Person person=NpcLoader.GetInstance().getNpc(value);
//					person.x=x;
//					person.y=y;
					Log.d("addperson", value);
					ObjectPosition obj=new ObjectPosition(person, x, y);
					alPerson.add(obj);
				}
			}
			 
			 
			 
        }
	}


//	private void setSpace(SceneMap map, Node spaceNode) {
//		// TODO Auto-generated method stub
//		NodeList spaceNs= spaceNode.getChildNodes();
//        Log.d("setSpaces",String.valueOf( spaceNs.getLength()));
//		for (int i = 0; i < spaceNs.getLength(); i++)
//        {
//			Node space=spaceNs.item(i); 
//			if (space.getNodeType() == Node.ELEMENT_NODE){
//			 NodeList ns = space.getChildNodes();
//
//	         Log.d("setSpace", "1");
//			 XmlReader xml=new XmlReader(ns);
//			 String type=xml.getText("type");
//			 String value=xml.getText("value");
//			 int x=Integer.parseInt(xml.getText("x"));
//			 int y=Integer.parseInt(xml.getText("y"));
//			 if(type.equals(ConstSpaceType.event)){
//				 
//				 Event event=EventLoader.GetInstance().getEvent(value);
//				 EventSpace esp=new EventSpace(event);
//				 map.setMap(x, y, esp);//.mapGuid[x][y]=esp;
//				 
//			 }
//			 else if(type.equals(ConstSpaceType.wall)){
//				 Wall wall=new Wall();
//				 map.setMap(x, y, wall);
//			 }
//			}
//        }
//	}
}
