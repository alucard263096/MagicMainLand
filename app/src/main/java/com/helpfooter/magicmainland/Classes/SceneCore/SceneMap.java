package com.helpfooter.magicmainland.Classes.SceneCore;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.MapSpaceExtends.MapSpace;
import com.helpfooter.magicmainland.Classes.PersonExtends.GameObject;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;


public class SceneMap {
	
	MapSpace[][] mapGuid;
	ObjectPosition[][] ArrObject;
	public int width=0;
	public int height=0;
	
	int screenMaxLength;
	int screenMaxHeight;
	

	
	public SceneMap(int width,int height){
				
		this.width=width;
		this.height=height;
		mapGuid=new MapSpace[width][height];
		
		screenMaxLength=GameConfig.SCREENWIDTH/GameConfig.OBJECTBITSIZE;
		screenMaxHeight=GameConfig.SCREENHEIGHT/GameConfig.OBJECTBITSIZE;
		
		ArrObject=new ObjectPosition[width][height];
	}
	
	void DrawBack(Canvas canvas, int heroX, int heroY,int moveX,int moveY){
		
		int centerX=GameConfig.SCREENWIDTH/2;
		int centerY=GameConfig.SCREENHEIGHT/2;
		
		
		int stS=heroX-screenMaxLength/2-2;
		int stE=heroX+screenMaxLength/2+2;

		int htS=heroY-screenMaxHeight/2-2;
		int htE=heroY+screenMaxHeight/2+2;
		
		for(int i=stS;i<stE;i++){
			if(i >= 0 && i < width){
				for(int j=htS;j<htE;j++){
					if(j>=0&&j<height){
						//Log.d("shit", String.valueOf(width)+"+"+String.valueOf(height)+":"+String.valueOf(i)+"+"+String.valueOf(j));
						if(mapGuid[i][j]!=null){
							mapGuid[i][j].Draw(canvas,
									(i-heroX)*GameConfig.OBJECTBITSIZE+centerX-GameConfig.OBJECTBITSIZE/2-moveX,
									(j-heroY)*GameConfig.OBJECTBITSIZE+centerY-GameConfig.OBJECTBITSIZE-moveY,null);
						}
//						if(ArrObject[i][j]!=null){
//							ArrObject[i][j].Draw(canvas,heroX,heroY,moveX,moveY);
//						}
					}
				}
			}
		}for(int i=stS;i<stE;i++){
			if(i >= 0 && i < width){
				for(int j=htS;j<htE;j++){
					if(j>=0&&j<height){
						//Log.d("shit", String.valueOf(width)+"+"+String.valueOf(height)+":"+String.valueOf(i)+"+"+String.valueOf(j));
						if(ArrObject[i][j]!=null){
							ArrObject[i][j].Draw(canvas,heroX,heroY,moveX,moveY);
						}
					}
				}
			}
		}
	}
	
	public void setMap(int x,int y,MapSpace space){
		
		mapGuid[x][y]=space;
		
	}
	

	public void setObject(int x,int y,ObjectPosition obj){
		ArrObject[x][y]=obj;
	}
	
	
	
}
