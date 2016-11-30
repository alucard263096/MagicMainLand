package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.helpfooter.magicmainland.Utils.ImageFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.helpfooter.magicmainland.tools.XmlReader;

import com.helpfooter.magicmainland.Classes.Ability;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;

public class PersonLoader extends ObjectLoader {
	
	public PersonLoader() {
		super("character");
		// TODO Auto-generated constructor stub
		 
	}

	private static PersonLoader instance=null;
	
	public static PersonLoader GetInstance(){
		if(instance==null){
			instance=new PersonLoader();
		}
		return instance;
	}
	
	public Hero getHero(String characterId){
		
		XmlReader xml=getNodeReader(characterId,"id");
		 String id=xml.getText("id");String name=xml.getText("name");
		 String img=xml.getText("img");
		 Bitmap imageBitmap = ImageFactory.GetInstance().getImage(this.imgPath+img);
			int level=Integer.parseInt(xml.getText("defaultLevel"));
		 
		 Node ablitity=xml.getNode("ability");
		 
		 Hero hero=new Hero(id, name, imageBitmap, GetAbility(ablitity));
		 hero.level=level;
		 return hero;
		
	}
	
	public FightPerson getFightPerson(String characterId){
		XmlReader xml=getNodeReader(characterId,"id");
		 String id=xml.getText("id");String name=xml.getText("name");
		 String img=xml.getText("img");
		 Bitmap imageBitmap = BitmapFactory.decodeFile(this.imgPath+img);
		int level=Integer.parseInt(xml.getText("defaultLevel"));
		 
		 Node ablitity=xml.getNode("ability");
		 
		 FightPerson hero=new FightPerson(id, name, imageBitmap, GetAbility(ablitity));
		 hero.level=level;
		 return hero;
	}
	
	
	
	
	public static Ability GetAbility(Node ablitity){
		NodeList abilityNS = ablitity.getChildNodes();
		XmlReader xml=new XmlReader(abilityNS);
		int hp=Integer.parseInt(xml.getText("hp"));
		int mp=Integer.parseInt(xml.getText("mp"));
		int act=Integer.parseInt(xml.getText("act"));
		int def=Integer.parseInt(xml.getText("def"));
		int spd=Integer.parseInt(xml.getText("spd"));
		int tec=Integer.parseInt(xml.getText("tec"));
		int mgact=Integer.parseInt(xml.getText("mgact"));
		int mgdef=Integer.parseInt(xml.getText("mgdef"));
		int lck=Integer.parseInt(xml.getText("lck"));
		
		Ability abs=new Ability(hp, mp, act, def, spd, tec, mgact, mgdef, lck);
		return abs;
		
	}
}
