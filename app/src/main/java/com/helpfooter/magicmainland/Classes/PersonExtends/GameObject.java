package com.helpfooter.magicmainland.Classes.PersonExtends;

import com.helpfooter.magicmainland.tools.ImageShower;
import com.helpfooter.magicmainland.Utils.ConstDirect;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class GameObject {
	public String id;
	
	//public int actPix=0;
	
	//public String direct=ConstDirect.SOUTH;

	ImageShower img;
	int width;
	int height;
	int[][] occu;
	
	public GameObject(String id,Bitmap bitmap,int positionx,int positiony,int width,int height){
		this.id=id;
		this.width=width;
		this.height=height;
		img=new ImageShower(bitmap, positionx, positiony, width, height);
		occu=new int[width][height];
	}
	
	public void setSpace(int x,int y){
		occu[x][y]=1;
	}
	
	public void drawImage(Canvas canvas,int x,int y,Paint p){
		img.Draw(canvas, x, y, p);
	}
	
	public boolean isSpace(int x,int y){
		if(x>=width||x<0||y<0||y>=height){
			return true;
		}
		if(occu[x][y]==1){
			return true;
		}
		return false;
	}
	
//	public void drawDirectImage(Canvas canvas,int x,int y,Paint p){
//		
//		drawDirectImage(direct,canvas,x,y,p);
//		
//	}
//	
//	public void addActPix(){
//		
//		actPix+=GameConfig.OBJECTBITSIZE;
//		if(actPix>3*GameConfig.OBJECTBITSIZE){
//			actPix=0;
//		}
//	}
//	int ac=0;
//	public void addActPix(int ack){
//		ac+=ack;
//		if(ac>=GameConfig.OBJECTBITSIZE/2){
//			ac=0;
//			addActPix();
//		}
//	}
//	private void drawDirectImage(String direct2, Canvas canvas, int x,
//			int y, Paint p) {
//		// TODO Auto-generated method stub
//		//getStartXByDirect(direct2);
//
//		img.Draw(canvas, x, y, p);
//	}

//	private void getStartXByDirect(String direct2) {
//		// TODO Auto-generated method stub
//		if(ConstDirect.SOUTH==direct2){
//			img.positionx=positionx+0;
//		}
//		else if(ConstDirect.WEST==direct2){
//			img.positionx=positionx+1;
//		}
//		else if(ConstDirect.EAST==direct2){
//			img.positionx=positionx+2;
//		}
//		else if(ConstDirect.NORTH==direct2){
//			img.positionx=positionx+3;
//		}
//		
//		
//	}
	

	
}
