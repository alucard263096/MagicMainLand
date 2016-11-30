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


import com.helpfooter.magicmainland.tools.XmlReader;
import com.helpfooter.magicmainland.Classes.DataObject.Advertisement;

public class AdvertisementLoader extends ObjectLoader {

private static AdvertisementLoader instance=null;
	
	public static AdvertisementLoader GetInstance(){
		if(instance==null){
			instance=new AdvertisementLoader();
		}
		return instance;
	}
	
	private   AdvertisementLoader() {
		super("advertisement");
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Advertisement> GetAdvertisements(){
		ArrayList<Advertisement> lst=new ArrayList<Advertisement>();
		
            for (int i = 0; i < this.StartNode.getLength(); i++)
            {
                Node result = this.StartNode.item(i);
                if (result.getNodeType() == Node.ELEMENT_NODE && result.getNodeName().equals("Advertisement"))
                {
                	
                    NodeList ns = result.getChildNodes();
                    XmlReader reader=new XmlReader(ns);
                    
                    String type=reader.getText("type");
                    int playSeconds=Integer.parseInt(reader.getText("playseconds"));;
                    String filepath=reader.getText("name");;
                    String name=reader.getText("filename");;
                    
                    Advertisement advertisement=new Advertisement(type, playSeconds, name, this.imgPath+filepath);
                    lst.add(advertisement);
                }
            }
      
        return lst;
	}
}
