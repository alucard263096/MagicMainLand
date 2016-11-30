package com.helpfooter.magicmainland.Classes.XmlDataLoader;

import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

import com.helpfooter.magicmainland.tools.XmlReader;

import com.helpfooter.magicmainland.Common.StaticObject;

public abstract class ObjectLoader {
	
	Dictionary<String,XmlReader> cacheRecord=new Hashtable<String,XmlReader>();
	
	public ObjectLoader(String filename){
		this.filename=filename+".xml";
		RootInitialization();
		imgPath=StaticObject.GameCpu.getXmlFilePath()+filename+"/";
	}
	protected String filename;
	protected String imgPath;
	protected NodeList StartNode;
	private void RootInitialization(){
		try
        {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = factory.newDocumentBuilder();
	        Log.d("fll", StaticObject.GameCpu.getXmlFilePath()+filename);
	        Document doc = db.parse(new File(StaticObject.GameCpu.getXmlFilePath()+filename));
	        Element elmtInfo = doc.getDocumentElement();
	        StartNode = elmtInfo.getChildNodes();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	

	protected XmlReader getNodeReader(String searchId,String pkKey){
		XmlReader targetReader=cacheRecord.get(searchId);
		 //Log.d("searchId", "kk"+searchId+"bb");
		if(targetReader==null){
			for (int i = 0; i < this.StartNode.getLength(); i++)
	        {
				 Node result = this.StartNode.item(i);
				 if (result.getNodeType() == Node.ELEMENT_NODE){
					 NodeList ns = result.getChildNodes();
					 XmlReader xml=new XmlReader(ns);
					 String id=xml.getText(pkKey);
					 //Log.d("xmlreaderid", "kk"+id+"bb");
					 if(id.equals(searchId)){
						 //Log.d("shot", "kk"+id+"bb");
						 targetReader=xml;
						 cacheRecord.put(searchId, targetReader);
					 }
				 }
	        }
		}
		if(targetReader==null){
			Log.d("xmlreader null", searchId);
		}
		return targetReader;
	}
	
	
}
