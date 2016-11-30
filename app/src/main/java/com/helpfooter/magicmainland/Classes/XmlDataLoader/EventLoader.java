package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import java.util.Dictionary;
import java.util.Hashtable;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

import com.helpfooter.magicmainland.Utils.ConstEventType;

import com.helpfooter.magicmainland.Classes.EventExtends.BusinessEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.Event;
import com.helpfooter.magicmainland.Classes.EventExtends.ItemEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.JoinQueueEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.MoneyEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.SwitchCheckYesEvent;
import com.helpfooter.magicmainland.Classes.EventExtends.SwitchEvent;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.ClassesItemExtends.Item;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPrice;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemPriceCatalog;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;

import com.helpfooter.magicmainland.tools.XmlReader;

public class EventLoader extends ObjectLoader  {

	Dictionary<String,XmlReader> dictRecord=new Hashtable<String,XmlReader>();

	private static EventLoader instance=null;
		
	public static EventLoader GetInstance(){
		if(instance==null){
			instance=new EventLoader();
		}
		return instance;
	}
	
	
	private EventLoader() {
		super("event");
		// TODO Auto-generated constructor stub
	}
	
	public Event getEvent(String eventId){
		Log.d("eventkey", eventId);
		XmlReader xml=getNodeReader(eventId,"id");
		Event event=null;
		String type=xml.getText("type");
		String id=xml.getText("id");
		String registerkey=xml.getText("registerkey");
		String name=xml.getText("name");
		String nextevent=xml.getText("nextevent");
		
		if(type.equals(ConstEventType.money)){
			int amount=Integer.parseInt(xml.getText("amount"));
			MoneyEvent me=new MoneyEvent(id,name,amount);
			event=me;
		}
		else if(type.equals(ConstEventType.item)){
			String itemid=xml.getText("item");
			Item item=ItemLoader.GetInstance().GetItem(itemid);
			int amount=Integer.parseInt(xml.getText("amount"));
			ItemEvent itemEvent=new ItemEvent(id,name,new ItemQty(item,amount));
			event=itemEvent;
		}
		else if(type.equals(ConstEventType.talk)){
			
			String msg=xml.getText("msg");
			event=new Event(id, name, msg);
			
		}
		else if(type.equals(ConstEventType.join)){

			String friend=xml.getText("friend");
			FightPerson fp=PersonLoader.GetInstance().getFightPerson(friend);
			JoinQueueEvent jqe=new JoinQueueEvent(id,name,fp);
			event=jqe;
			
		}
		else if(type.equals(ConstEventType.select)){
			String msg=xml.getText("msg");
			String yesevent=xml.getText("yesevent");
			String noevent=xml.getText("noevent");
			Event yevent=getEvent(yesevent);
			Event nevent=getEvent(noevent);
			SwitchEvent se=new SwitchEvent(id,name,msg,yevent,nevent);
			event=se;
		}
		else if(type.equals(ConstEventType.validate)){
			String msg=xml.getText("msg");
			String yesevent=xml.getText("yesevent");
			String noevent=xml.getText("noevent");
			String checkkey=xml.getText("checkkey");
			String onlycheck=xml.getText("onlycheck");
			Event yevent=getEvent(yesevent);
			Event nevent=getEvent(noevent);
			SwitchCheckYesEvent scye=new SwitchCheckYesEvent(id, name, msg, yevent, nevent, 
					checkkey, onlycheck.equals("1"));
			event=scye;
		}
		else if(type.equals(ConstEventType.business)){
			ItemPriceCatalog ipc=new ItemPriceCatalog();
			NodeList itemsNode=xml.getNode("items").getChildNodes();
			
			for (int i = 0; i < itemsNode.getLength(); i++){
				Node itemNode=itemsNode.item(i);
				if (itemNode.getNodeType() == Node.ELEMENT_NODE){
					NodeList itemValueNodeList=itemNode.getChildNodes();
					XmlReader itemReader=new XmlReader(itemValueNodeList);
					//XmlReader.ShowLog(itemValueNodeList);
					String itemId=itemReader.getText("itemid");
					int itemprice=Integer.parseInt(itemReader.getText("amount"));
					Item item=ItemLoader.GetInstance().GetItem(itemId);
					ItemPrice ip=new ItemPrice(item, itemprice);
					
					ipc.addItem(ip);
				}
			}
			BusinessEvent be=new BusinessEvent(id, name,ipc);
			event=be;
		}
		if(event!=null){
			if(registerkey!=""){
				event.RegisterKeyEvent(registerkey);
			}
			if(nextevent!=""){
				Event nextEvent=getEvent(nextevent);
				event.setNextEvent(nextEvent);
			}
		}
		
		return event;
	}


	
}
