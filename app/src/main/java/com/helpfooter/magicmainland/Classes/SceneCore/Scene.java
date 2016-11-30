package com.helpfooter.magicmainland.Classes.SceneCore;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.util.Log;

import com.helpfooter.magicmainland.Classes.MapSpaceExtends.MapSpace;
import com.helpfooter.magicmainland.Classes.PersonExtends.FightPerson;
import com.helpfooter.magicmainland.Classes.PersonExtends.GameObject;
import com.helpfooter.magicmainland.Classes.PersonExtends.Hero;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Utils.ConstDirect;

public class Scene {
	
	SceneMap map;
	public ArrayList<ObjectPosition> alPerson;
	ObjectPosition hero;
	
	public Scene(SceneMap map){
		
		this.map=map;
		//,ArrayList<Person> alPerson,Hero hero
		//this.alPerson=alPerson;
		//this.hero=hero;
	}
	
	public void Draw(Canvas canvas){
		map.DrawBack(canvas, hero.x, hero.y,hero.subMoveX,hero.subMoveY);
		hero.Draw(canvas, hero.x, hero.y,hero.subMoveX,hero.subMoveY);
		for(ObjectPosition npc:this.alPerson){
			npc.Draw(canvas, hero.x, hero.y,hero.subMoveX,hero.subMoveY);
		}
	}
	
	public void addPerson(ObjectPosition npc){
		this.alPerson.add(npc);
	}
	
	public void removePerson(Person npc){
		this.alPerson.remove(npc);
	}
	
	public void removePersonById(String id){
		for(ObjectPosition npc:this.alPerson){
			if(npc.obj.id.equals(id)){
				this.alPerson.remove(npc);
				break;
			}
		}
	}
	
	public void setHero(ObjectPosition hero){
		this.hero=hero;
	}

	public boolean checkCanGo(int nextX, int nextY) {
//		// TODO Auto-generated method stub
//		int nextX=hero.x+detaX;
//		int nextY=hero.y+detaY;
		
		if(nextX<0||nextY<0||nextX>=map.width||nextY>=map.height){
			return false;
		}

		
		if(IsCanPass(nextX,nextY)==false){
			return false;
		}
		
		if(IsHaveObject(nextX,nextY)==false){
			return false;
		}

		if(checkHaveNpc(nextX,nextY)==true){
			return false;
		}
		
		return true;
	}

	private boolean IsHaveObject(int nextX, int nextY) {
		// TODO Auto-generated method stub
		for(int j=0;j<map.height;j++){
			if(j>nextY){
				break;
			}
			for(int i=0;i<map.width;i++){
				if(map.ArrObject[i][j]!=null){
					GameObject obj=(map.ArrObject[i][j]).obj;
					int absX=nextX-i;
					int absY=nextY-j;
					if(obj.isSpace(absX, absY)==false){
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean IsCanPass(int nextX, int nextY) {
		// TODO Auto-generated method stub

		MapSpace space=map.mapGuid[nextX][nextY];
		if(space==null){
			return true;
		}
		return space.canPass();
	}

	private boolean checkHaveNpc(int X, int Y) {
		// TODO Auto-generated method stub
		for(ObjectPosition p:alPerson){
			if(p.x==X&&p.y==Y){
				return true;
			}
		}
		return false;
	}
	
	private Person getNpc(int X, int Y){
		for(ObjectPosition p:alPerson){
			if(p.x==X&&p.y==Y){
				return (Person)p.obj;
			}
		}
		return null;
	}

	public void heroGo(int detaX, int detaY) {
		// TODO Auto-generated method stub
		//
		
	}

	public void heroToDo() {
		// TODO Auto-generated method stub
		Hero heroObj=(Hero)this.hero.obj;
		int heroFrontX=hero.x;
		int heroFrontY=hero.y;
		if(heroObj.direct==ConstDirect.NORTH){
			heroFrontY--;
		}else if(heroObj.direct==ConstDirect.SOUTH){
			heroFrontY++;
		}else if(heroObj.direct==ConstDirect.EAST){
			heroFrontX++;
		}else if(heroObj.direct==ConstDirect.WEST){
			heroFrontX--;
		}
		if(checkHaveNpc(heroFrontX,heroFrontY)){
			Person p=getNpc(heroFrontX,heroFrontY);
			p.Talking(heroObj.direct);
		}else{
		 MapSpace ms=	map.mapGuid[hero.x][hero.y];
		 if(ms!=null){
			 ms.forCheckDo();
		 }
		}
		
		
		
	}

	public void setHeroDirect(String direct) {
		// TODO Auto-generated method stub
		//hero.direct=direct;
	}

	public void heroGo(String direct) {
		// TODO Auto-generated method stub
		Hero heroObj=(Hero)this.hero.obj;
		if(heroObj.isDoSomething==false){
			heroObj.setDirect(direct);
			int detaX=0;
			int detaY=0;
			if(direct==ConstDirect.NORTH){
				detaY--;
			}
			else if(direct==ConstDirect.SOUTH){
				detaY++;
			}
			else if(direct==ConstDirect.WEST){
				detaX--;
			}
			else if(direct==ConstDirect.EAST){
				detaX++;
			}
			if(detaX!=0||detaY!=0){
				boolean canGo=this.checkCanGo(hero.x+detaX,hero.y+ detaY);
				if(canGo){
					heroObj.Go(detaX, detaY, this.hero);
					//hero.x+=detaX;
					//hero.y+=detaY;
					
				}
			}
		}
	}

	
}
