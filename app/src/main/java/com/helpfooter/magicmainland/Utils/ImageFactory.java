package com.helpfooter.magicmainland.Utils;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageFactory {
	class ImageCount{
		public String name="";
		public int count=0;
		public Bitmap image=null; 
		
	}
	int maxCount=0;
	Dictionary<String,ImageCount> cacheRecord=new Hashtable<String,ImageCount>();
	
	private static ImageFactory instance=null;
	public static ImageFactory GetInstance(){
		if(instance==null){
			instance=new ImageFactory();
		}
		return instance;
	}
	
	private   ImageFactory() {
		// TODO Auto-generated constructor stub
	}

	public Bitmap getImage(String path){
		ImageCount imf=cacheRecord.get(path);
		if(imf==null){
			imf=new ImageCount();
			imf.name=path;
			imf.count=0;
			Bitmap imageBitmap = BitmapFactory.decodeFile(path);
			imf.image=imageBitmap;
			sortCache();
			cacheRecord.put(path, imf);
		}
		else{
			imf.count++;
			if(maxCount<imf.count){
				maxCount=imf.count;
			}
		}
		return imf.image;
	}
	
	private void sortCache(){
		if(cacheRecord.size()>=100){
			int newMaxCount=0;
			int arverCount=maxCount/5;
			Enumeration<ImageCount> enums=cacheRecord.elements();
			 while(enums.hasMoreElements()){//�ж��Ƿ�������
				ImageCount ic=enums.nextElement();
				if(ic!=null){
					if(newMaxCount<ic.count){
						newMaxCount=ic.count;
					}
					if(ic.count<=arverCount){
						cacheRecord.remove(ic.name);
					}
				}
			 }
			 maxCount=newMaxCount;
		}
	}
	
	
	
}
