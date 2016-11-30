package com.helpfooter.magicmainland.Classes.PersonExtends.ActionExtends;

import com.helpfooter.magicmainland.Utils.GameConfig;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;

public class WalkThread extends Thread {
	int detaX;
	int detaY;
	Person person;
	ObjectPosition objPosition;
	int detaMove=0;
	public WalkThread(int detaX,int detaY,Person person,ObjectPosition objPosition){
		
		this.detaX=detaX;
		this.detaY=detaY;
		this.person=person;
		this.objPosition=objPosition;
	}
	
	public void run(){
		while(true){
			if(detaX!=0||detaY!=0){
				person.addActPix(GameConfig.PERSONMOVEPIXELS);
				
				detaMove+=GameConfig.PERSONMOVEPIXELS;
				if(detaMove>=GameConfig.OBJECTBITSIZE){
					objPosition.subMoveX=0;
					objPosition.subMoveY=0;
					objPosition.x+=detaX;
					objPosition.y+=detaY;
					person.isDoSomething=false;
					return;
				}
				else{
					objPosition.subMoveX=detaMove*detaX;
					objPosition.subMoveY=detaMove*detaY;
				}
			}
			else{
				return;
			}
			try{
				Thread.sleep(GameConfig.PERSONMOVETIMESPAN);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
