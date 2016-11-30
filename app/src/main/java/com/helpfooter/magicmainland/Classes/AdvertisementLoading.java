package com.helpfooter.magicmainland.Classes;

import java.util.ArrayList;



import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.helpfooter.magicmainland.Classes.DataObject.Advertisement;
import com.helpfooter.magicmainland.Classes.GameLoadObject.AbstractGameLoadObject;
import com.helpfooter.magicmainland.Classes.GameLoadObject.Banner;
import com.helpfooter.magicmainland.Classes.XmlDataLoader.AdvertisementLoader;
import com.helpfooter.magicmainland.Common.DrawThread;
import com.helpfooter.magicmainland.Common.GameCpu;
import com.helpfooter.magicmainland.Interface.IGameUnit;
import com.helpfooter.magicmainland.R;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;

public class AdvertisementLoading  implements IGameUnit {
	GameCpu cpu;
	DrawThread dt;
	ArrayList<AbstractGameLoadObject> alGameLoadShowObject=new ArrayList<AbstractGameLoadObject>();
	boolean showIsComlpete=false;
	
	public AdvertisementLoading(GameCpu cpu,Resources r) {
		// TODO Auto-generated constructor stub ArrayList<AbstractGameLoadObject> alGameLoadShowObject=new ArrayList<AbstractGameLoadObject>();
		this.cpu=cpu;

		alGameLoadShowObject.clear();
		
		alGameLoadShowObject.add(new Banner(2,BitmapFactory.decodeResource(r, R.drawable.banner)));
		String xmlFilePath=this.cpu.getXmlFilePath();
		ArrayList<Advertisement> advs= AdvertisementLoader.GetInstance().GetAdvertisements();
		for(Advertisement ad:advs){
			Log.d("path", ad.PlayFilePath);
			Bitmap imageBitmap = BitmapFactory.decodeFile(ad.PlayFilePath);
			alGameLoadShowObject.add(new Banner(ad.PlaySeconds,imageBitmap));
		}
	}

	@Override
	public void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		if(showIsComlpete==false){
			canvas.drawColor(Color.BLACK);
			int bannerCount=0;
			for(AbstractGameLoadObject abs : alGameLoadShowObject ){
				if(abs.IsCompleted()){
					bannerCount++;
					continue;
				}
				if(abs.IsActive()==false){
					abs.Active(System.currentTimeMillis());
				}
				abs.doDraw(canvas, System.currentTimeMillis());
				break;
			}
			showIsComlpete=bannerCount==alGameLoadShowObject.size();
		}
		//Log.d("a",String.valueOf(showIsComlpete) );
		if(showIsComlpete==true){
			//gameActivity.myHandler.sendEmptyMessage(3);
			this.cpu.ChangeGameStatu(new GameStart(this.cpu));
		}
	}


	@Override
	public void getControllerInput(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getScreenTouch(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialization(Resources r) {
		// TODO Auto-generated method stub

		showIsComlpete=false;
		
		for(AbstractGameLoadObject ad:alGameLoadShowObject){
			ad.reset();
		}
		
	}

}
