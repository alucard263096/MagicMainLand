package com.helpfooter.magicmainland.Classes.PersonExtends;

import com.helpfooter.magicmainland.Utils.ConstDirect;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.helpfooter.magicmainland.Classes.PersonExtends.ActionExtends.WalkThread;
import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;
import com.helpfooter.magicmainland.Interface.IPerson;

public class Person extends GameObject implements IPerson {

	public String direct=ConstDirect.SOUTH;
	
	public Person(String id,String name, Bitmap bitmap) {
		super(id, bitmap, 0, 0, 1, 1);
		// TODO Auto-generated constructor stub
		this.name=name;
		//pt=new PersonThread(this);
		//pt.start();
	}

	public String name;


//	public Person(String id,String name,Bitmap image) {
//		super(id,image);
//		// TODO Auto-generated constructor stub
//		
//		
//		pt=new PersonThread(this);
//		pt.start();
//		
//	}

	
	//PersonThread pt;
	
	public boolean isDoSomething=false;
	
	
	@Override
	public void Talking(String talkerDirect) {

		// TODO Auto-generated method stub
		if(talkerDirect==ConstDirect.EAST){
			this.direct=ConstDirect.WEST;
		}else if(talkerDirect==ConstDirect.WEST){
			this.direct=ConstDirect.EAST;
		}else if(talkerDirect==ConstDirect.NORTH){
			this.direct=ConstDirect.SOUTH;
		}else if(talkerDirect==ConstDirect.SOUTH){
			this.direct=ConstDirect.NORTH;
		}
		
		SetImagePosition();
	}


	@Override
	public void Go(int detaX, int detaY,ObjectPosition objPosition) {
		// TODO Auto-generated method stub
		isDoSomething=true;
//		detaMove=0;
//		this.detaX=detaX;
//		this.detaY=detaY;
		WalkThread wt=new WalkThread(detaX, detaY, this, objPosition);
		wt.start();
	}
	private void SetImagePosition() {
		// TODO Auto-generated method stub
		if(ConstDirect.SOUTH==this.direct){
			img.positiony=0;
		}
		else if(ConstDirect.WEST==this.direct){
			img.positiony=1;
		}
		else if(ConstDirect.EAST==this.direct){
			img.positiony=3;
		}
		else if(ConstDirect.NORTH==this.direct){
			img.positiony=2;
		}
	}
	public void setDirect(String direct){
		this.direct=direct;
		SetImagePosition();
	}
	public void addActPix(){
		
		img.positionx++;
		if(img.positionx>3){
			img.positionx=0;
		}
	}
	int ac=0;
	public void addActPix(int ack){
		ac+=ack;
		if(ac>=GameConfig.OBJECTBITSIZE/2){
			ac=0;
			addActPix();
		}
	}
}
