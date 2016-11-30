package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import java.util.Dictionary;
import java.util.Hashtable;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.helpfooter.magicmainland.tools.XmlReader;
import com.helpfooter.magicmainland.Utils.ConstEquipmentType;
import com.helpfooter.magicmainland.Utils.ConstItemType;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.ClassesItemExtends.ConsumableItem;
import com.helpfooter.magicmainland.ClassesItemExtends.Equipment;
import com.helpfooter.magicmainland.ClassesItemExtends.IncreaseDrug;
import com.helpfooter.magicmainland.ClassesItemExtends.Item;
import com.helpfooter.magicmainland.ClassesItemExtends.PlotItem;
import com.helpfooter.magicmainland.ClassesItemExtends.RehabilitationDrug;
import com.helpfooter.magicmainland.ClassesItemExtends.RehabilitationPercentageDrug;

public class ItemLoader extends ObjectLoader {

	private ItemLoader() {
		super("item");
		// TODO Auto-generated constructor stub
	}

	private static ItemLoader instance=null;
		
	public static ItemLoader GetInstance(){
		if(instance==null){
			instance=new ItemLoader();
		}
		return instance;
	}
		
	public Item GetItem(String itemid){
		XmlReader xml=this.getNodeReader(itemid, "id");
		 Item item=null;
		 String id=xml.getText("id");
		 String type=xml.getText("type");
		 String name=xml.getText("name");
		 String description=xml.getText("description");
		 if(type.equals(ConstItemType.RehabilitationDrug)){
			 int hp=Integer.parseInt(xml.getText("hp"));
			 int mp=Integer.parseInt(xml.getText("mp"));
			 String resurrect=xml.getText("resurrect");
			 String unlimited=xml.getText("unlimited");
			 String queue=xml.getText("queue");
			 ConsumableItem ci=new RehabilitationDrug(id,name,hp,mp,resurrect.equals("1"));
			 ci.isNotConsumable=unlimited.equals("1");
			 ci.isQueueUse=unlimited.equals("1");
			 item=ci;
				item.description=description;
		 }
		 else if(type.equals(ConstItemType.RehabilitationPercentageDrug)){
			 int hp=Integer.parseInt(xml.getText("hp"));
			 int mp=Integer.parseInt(xml.getText("mp"));
			 String resurrect=xml.getText("resurrect");
			 String unlimited=xml.getText("unlimited");
			 String queue=xml.getText("queue");
			 ConsumableItem ci=new RehabilitationPercentageDrug(id, name,hp,mp,resurrect.equals("1"));
			 ci.isNotConsumable=unlimited.equals("1");
			 ci.isQueueUse=unlimited.equals("1");
			 item=ci;
				item.description=description;
		 }
		 else if(type.equals(ConstItemType.IncreaseDrug)){
			 Ability abs=PersonLoader.GetAbility(xml.getNode("ability"));
			 ConsumableItem ci=new IncreaseDrug(id, name,abs);
			 item=ci;
				item.description=description;
		 }
		 else if(type.equals(ConstItemType.Equipment)){
			 String dept=xml.getText("dept");
			Ability abs=PersonLoader.GetAbility(xml.getNode("ability"));
			Equipment ep= new Equipment(id, name, dept, abs);
			item=ep;
			item.description=description;
		 }
		 else if(type.equals(ConstItemType.Plot)){

			 String event=xml.getText("event");
				PlotItem pi=new PlotItem(id,name,event );
				item=pi;
				item.description=description;
		}
		 return item;
	}
	
}
