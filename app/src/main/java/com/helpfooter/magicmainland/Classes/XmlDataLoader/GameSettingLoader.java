package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.helpfooter.magicmainland.ClassesItemExtends.Item;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;

import com.helpfooter.magicmainland.tools.XmlReader;


public class GameSettingLoader extends ObjectLoader {
	
	private static GameSettingLoader instance=null;
	
	public static GameSettingLoader GetInstance(){
		if(instance==null){
			instance=new GameSettingLoader();
		}
		return instance;
	}
	
	public static void init(){
		instance=null;
	}
	
	
	private GameSettingLoader() {
		
		super("main");
		// TODO Auto-generated constructor stub
		XmlReader reader=new XmlReader(this.StartNode);
        this.StartScene=reader.getText("startscene");
        this.InitMoney=Integer.parseInt(reader.getText("initmoney"));
        this.Star=reader.getText("star");
        this.PositionX=Integer.parseInt(reader.getText("positionx"));
        this.PositionY=Integer.parseInt(reader.getText("positiony"));
        this.StartEvent=reader.getText("startevent");
        
        NodeList itns = reader.getNode("items").getChildNodes();
        getItems(itns);
	}

	

	public String StartScene="";
	public int InitMoney=0;
	public String Star="";
	public int PositionX=0;
	public int PositionY=0;
	public String StartEvent="";
	public ArrayList<ItemQty> Items=new ArrayList<ItemQty>();
	

	private void getItems(NodeList nodes) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nodes.getLength(); i++){
			Node result = nodes.item(i);
			if(result.getNodeType() == Node.ELEMENT_NODE
            		&& result.getNodeName().equals("item")){
				NodeList nss = result.getChildNodes();
				XmlReader reader=new XmlReader(nss);
				int qty=Integer.parseInt(reader.getText("qty"));
        		String id=reader.getText("id");
        		Item item=ItemLoader.GetInstance().GetItem(id);
        		ItemQty iq=new ItemQty(item, qty);
        		Items.add(iq);
			}
		}
	}
	
}
