package com.helpfooter.magicmainland.Classes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Common.DrawThread;
import com.helpfooter.magicmainland.Common.GameCpu;
import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;
import com.helpfooter.magicmainland.Classes.SceneCore.Scene;
import com.helpfooter.magicmainland.Classes.XmlDataLoader.GameSettingLoader;
import com.helpfooter.magicmainland.Classes.XmlDataLoader.PersonLoader;
import com.helpfooter.magicmainland.Classes.XmlDataLoader.SceneLoader;
import com.helpfooter.magicmainland.ClassesItemExtends.ItemQty;
import com.helpfooter.magicmainland.Interface.IGameUnit;
import com.helpfooter.magicmainland.MainActivity;
import com.helpfooter.magicmainland.Utils.ConstDirect;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SceneView implements IGameUnit {

	MainActivity gameActivity;
	DrawThread dt;
	
	//SceneBuilder sb;
	Scene scene=null;
	
	
	
	
	GameController gameController;
	EventManager eventManager;
	MenuManager menuManager;

	GameCpu cpu;
	public SceneView(GameCpu cpu,Resources r) {

		this.cpu=cpu;
		//sb=new SceneBuilder(r);
		//GameSetting gameSetting=new GameSetting(xmlFilePath, "main.xml");

		//StaticObject.StarHero=
		Hero hero=PersonLoader.GetInstance().getHero(GameSettingLoader.GetInstance().Star);
		StaticObject.StarHero=hero;
		hero.luggage.addMoney(GameSettingLoader.GetInstance().InitMoney);
//		hero.x=GameSettingLoader.GetInstance().PositionX;
//		hero.y=GameSettingLoader.GetInstance().PositionY;
		ArrayList<ItemQty> alItem=GameSettingLoader.GetInstance().Items;
		int qtySize=alItem.size();
		for(int i=0;i<qtySize;i++){
			ItemQty itemqty=alItem.get(i);
			hero.luggage.addItem(itemqty);
		}
		scene=SceneLoader.GetInstance().getScene(GameSettingLoader.GetInstance().StartScene);
		scene.setHero(new ObjectPosition(hero, GameSettingLoader.GetInstance().PositionX, GameSettingLoader.GetInstance().PositionY));
		StaticObject.CurrentScene=scene;
	}

	@Override
	public void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawColor(Color.BLACK);
		
		scene.Draw(canvas);
		
		//Log.d("drawset", "1");
		//Hero hero=scene.hero;
		//Log.d("drawset", "2");
//		
//		canvas.drawBitmap(scene.map.btMapSrc, 
//				centerCorrectionX-hero.x*GameConfig.OBJECTBITSIZE-hero.detaX*hero.detaMove ,  
//				centerCorrectionY-hero.y*GameConfig.OBJECTBITSIZE-hero.detaY*hero.detaMove ,null);
//
//		//Log.d("drawset", "3");
//		int npcsize=scene.alPerson.size();
//
//		//Log.d("drawset", "4");
//		for(int i=0;i<npcsize;i++){
//			Person p=scene.alPerson.get(i);
//			p.drawDirectImage(canvas,  
//				 centerCorrectionX-(hero.x-p.x)*GameConfig.OBJECTBITSIZE-hero.detaX*hero.detaMove,
//				 centerCorrectionY-(hero.y-p.y)*GameConfig.OBJECTBITSIZE-hero.detaY*hero.detaMove,null);
//		}
		//Log.d("drawset", "5");
		
		//hero.drawDirectImage(canvas, centerCorrectionX, centerCorrectionY,null);

		//Log.d("drawset", "6");
		
		eventManager.drawDialog(canvas);
		//Log.d("drawset", "7");
		menuManager.draw(canvas);
		//Log.d("drawset", "8");
		gameController.setController(canvas);
		//Log.d("drawset", "9");
	}

	public void doControllerInteraction(EnumControllerButton irButton) {
		// TODO Auto-generated method stub

		if(irButton==EnumControllerButton.UP){
			scene.heroGo(ConstDirect.NORTH);
		}
		else if(irButton==EnumControllerButton.DOWN){
				scene.heroGo(ConstDirect.SOUTH);
		}
		else if(irButton==EnumControllerButton.LEFT){
			scene.heroGo(ConstDirect.WEST);
		}
		else if(irButton==EnumControllerButton.RIGHT){
			scene.heroGo(ConstDirect.EAST);
		}
		else if(irButton==EnumControllerButton.A){
			scene.heroToDo();
		}
		else if(irButton==EnumControllerButton.B){
			gameController.callMenu();
		}
		
//		if(scene==null){
//			return;
//		}
//		Hero hero=scene.hero;
//		if(hero.isDoSomething==false){
//			int detaX=0;
//			int detaY=0;
//			if(irButton==EnumControllerButton.UP){
//				detaY=-1;
//				scene.setHeroDirect(ConstDirect.NORTH);
//			}
//			else if(irButton==EnumControllerButton.DOWN){
//					detaY=1;
//					scene.setHeroDirect(ConstDirect.SOUTH);
//			}
//			else if(irButton==EnumControllerButton.LEFT){
//				detaX=-1;
//				scene.setHeroDirect(ConstDirect.WEST);
//			}
//			else if(irButton==EnumControllerButton.RIGHT){
//				detaX=1;
//				scene.setHeroDirect(ConstDirect.EAST);
//			}
//			else if(irButton==EnumControllerButton.A){
//				scene.heroToDo();
//			}
//			else if(irButton==EnumControllerButton.B){
//				gameController.callMenu();
//			}
//			
//			if(detaX!=0||detaY!=0){
//				boolean canGo=scene.checkCanGo(detaX,detaY);
//				if(canGo){
//					scene.heroGo(detaX,detaY);
//				}
//			}
//		}
	}

	@Override
	public void getControllerInput(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(eventManager.currentEvent!=null){
    		eventManager.setOperationButtonForDialog(irButton);
    	}
    	else{
    		if(menuManager.isMenuModel){
    			menuManager.setOperationButton(irButton);
    		}
    		else{

        		doControllerInteraction(irButton);
    		}
    	}
	}

	@Override
	public void getScreenTouch(float x, float y) {
		// TODO Auto-generated method stub
		EnumControllerButton irButton=gameController.getButton(x,y);
    	this.getControllerInput(irButton);
    	
	}

	@Override
	public void initialization(Resources r) {
		// TODO Auto-generated method stub
		
		//sb=new SceneBuilder(r);

		gameController=GameController.getInstance();
		eventManager=EventManager.getInstance();
		menuManager= MenuManager.getInstance();
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}



}
