package com.helpfooter.magicmainland.Classes;


import com.helpfooter.magicmainland.R;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.GameConfig;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class GameController  {	
	
	int screenHeight=GameConfig.SCREENHEIGHT;
	int screenWidth=GameConfig.SCREENWIDTH;
	
	public float upArrowX=0;
	public float upArrowY=0;
	

	public float downArrowX=0;
	public float downArrowY=0;
	

	public float leftArrowX=0;
	public float leftArrowY=0;
	

	public float rightArrowX=0;
	public float rightArrowY=0;
	


	Bitmap bmUpArrow;
	Bitmap bmDownArrow;
	Bitmap bmLeftArrow;
	Bitmap bmRightArrow;
	Bitmap bmButtonA;
	Bitmap bmButtonB;
	
	public float buttonAX=0;
	public float buttonAY=0;
	
	public float buttonBX=0;
	public float buttonBY=0;
	
	
	
	private static GameController instance=null;
	
	public static GameController getInstance(){
		
		if(instance==null){
			instance=new GameController();
		}
		return instance;
	}
	
	
	private GameController(){
		
		 upArrowX=GameConfig.BUTTON_SIZE+GameConfig.BUTTON_ARGIN;
		 upArrowY=screenHeight-3*GameConfig.BUTTON_SIZE-2*GameConfig.BUTTON_ARGIN;
		

		 downArrowX=GameConfig.BUTTON_SIZE+GameConfig.BUTTON_ARGIN;
		 downArrowY=screenHeight-GameConfig.BUTTON_SIZE;
		

		 leftArrowX=0;
		 leftArrowY=screenHeight-2*GameConfig.BUTTON_SIZE-GameConfig.BUTTON_ARGIN;
		

		 rightArrowX=2*GameConfig.BUTTON_SIZE+2*GameConfig.BUTTON_ARGIN;
		 rightArrowY=screenHeight-2*GameConfig.BUTTON_SIZE-GameConfig.BUTTON_ARGIN;
		 
		 buttonAX=screenWidth-GameConfig.BUTTON_SIZE-GameConfig.BUTTON_ARGIN;
		 buttonAY=screenHeight-2*GameConfig.BUTTON_SIZE-3*GameConfig.BUTTON_ARGIN;
		 

		 buttonBX=screenWidth-2*GameConfig.BUTTON_SIZE-3*GameConfig.BUTTON_ARGIN;
		 buttonBY=screenHeight-GameConfig.BUTTON_SIZE-3*GameConfig.BUTTON_ARGIN;
		 
		 
	}
	
	public void setButtonImage(Resources r){
		
		
		bmUpArrow=BitmapFactory.decodeResource(r, R.drawable.uparrow);
		bmDownArrow=BitmapFactory.decodeResource(r, R.drawable.downarrow);
		bmLeftArrow=BitmapFactory.decodeResource(r, R.drawable.leftarrow);
		bmRightArrow=BitmapFactory.decodeResource(r, R.drawable.rightarrow);
		bmButtonA=BitmapFactory.decodeResource(r, R.drawable.buttona);
		bmButtonB=BitmapFactory.decodeResource(r, R.drawable.buttonb);
		 
	}
	
	public void setController(Canvas canvas) {

		canvas.drawBitmap(bmDownArrow, downArrowX, downArrowY,null);
		canvas.drawBitmap(bmUpArrow, upArrowX, upArrowY,null);
		canvas.drawBitmap(bmLeftArrow, leftArrowX, leftArrowY,null);
		canvas.drawBitmap(bmRightArrow, rightArrowX, rightArrowY,null);
		
		canvas.drawBitmap(bmButtonA, buttonAX, buttonAY,null);
		canvas.drawBitmap(bmButtonB, buttonBX, buttonBY,null);
		
	}

	public EnumControllerButton getButton(float touchX, float touchY) {
		// TODO Auto-generated method stub
		
		if(touchX>=upArrowX
				&&touchX<=upArrowX+GameConfig.BUTTON_SIZE
				&&touchY>=upArrowY
				&&touchY<=upArrowY+GameConfig.BUTTON_SIZE){
			return EnumControllerButton.UP;
		}
		else if(touchX>=downArrowX
					&&touchX<=downArrowX+GameConfig.BUTTON_SIZE
					&&touchY>=downArrowY
					&&touchY<=downArrowY+GameConfig.BUTTON_SIZE){
				return EnumControllerButton.DOWN;
			}
		else if(touchX>=leftArrowX
				&&touchX<=leftArrowX+GameConfig.BUTTON_SIZE
				&&touchY>=leftArrowY
				&&touchY<=leftArrowY+GameConfig.BUTTON_SIZE){
			return EnumControllerButton.LEFT;
		}
		else if(touchX>=rightArrowX
				&&touchX<=rightArrowX+GameConfig.BUTTON_SIZE
				&&touchY>=rightArrowY
				&&touchY<=rightArrowY+GameConfig.BUTTON_SIZE){
			return EnumControllerButton.RIGHT;
		}
		else if(touchX>=buttonAX
				&&touchX<=buttonAX+GameConfig.BUTTON_SIZE
				&&touchY>=buttonAY
				&&touchY<=buttonAY+GameConfig.BUTTON_SIZE){
			return EnumControllerButton.A;
		}
		else if(touchX>=buttonBX
				&&touchX<=buttonBX+GameConfig.BUTTON_SIZE
				&&touchY>=buttonBY
				&&touchY<=buttonBY+GameConfig.BUTTON_SIZE){
			return EnumControllerButton.B;
		}
		
		
		return EnumControllerButton.NONE;
	}

	public void callMenu() {
		// TODO Auto-generated method stub
		MenuManager manager=MenuManager.getInstance();
		manager.showMenu();
		
	}
	
}
