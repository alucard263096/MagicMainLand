package com.helpfooter.magicmainland.Classes.MenuExtendes;

import java.util.ArrayList;

import com.helpfooter.magicmainland.Classes.EventManager;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.MenuManager;
import com.helpfooter.magicmainland.Classes.SceneBuilder;
import com.helpfooter.magicmainland.Classes.DialogExtends.Dialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.OptionDialog;
import com.helpfooter.magicmainland.ClassesItemExtends.Luggage;
import com.helpfooter.magicmainland.Interface.IDialog;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.EnumDialogOption;
import android.graphics.Canvas;
import android.util.Log;

public class Menu {
	String name;
	Menu superMenu;
	Menu selectedMenu;
	IDialog dialog;
	OptionDialog optionDialog;
	int menuStartX=0;
	int menuStartY=0;
	
	ArrayList<Menu> alOp=new  ArrayList<Menu>();
	public int colNum=2;
	public int cursor=0;
	boolean isOptionSeleted=false;
	
	public Menu(String name,int colNum){
		
		this.name=name;
		this.colNum=colNum;
	}
	
	public void setSuperMenu(Menu superMenu){

		this.superMenu=superMenu;
	}

	public void addOption(Menu op) {
		// TODO Auto-generated method stub
		op.setSuperMenu(this);
		alOp.add(op);
	}

	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		if(dialog!=null){
			dialog.draw(canvas);
			if(isOptionSeleted){
				if(selectedMenu!=null){
					selectedMenu.draw(canvas);
				}
			}
		}
		
	}

	public void setControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(isOptionSeleted){
			seletedSetControll(irButton);
		}
		else{
			notSelectedSetControll(irButton);
		}
	}
	
	public void seletedSetControll(EnumControllerButton irButton){
		
		if(selectedMenu!=null){
			selectedMenu.setControll(irButton);
		}
	}
	
	public void notSelectedSetControll(EnumControllerButton irButton){
		
			if(irButton==EnumControllerButton.DOWN){
				if(cursor+colNum<alOp.size()){
					cursor+=colNum;
				}
			}
			else if(irButton==EnumControllerButton.UP){
	
				if(cursor-colNum>=0){
					cursor-=colNum;
				}
			}
			else if(irButton==EnumControllerButton.RIGHT){
				cursor++;
				if(cursor>=alOp.size()){
					cursor=alOp.size()-1;
				}
			}
			else if(irButton==EnumControllerButton.LEFT){
				cursor--;
				if(cursor<0){
					cursor=0;
				}
			}
			else if(irButton==EnumControllerButton.A){
				Menu option=alOp.get(cursor);
				if(option!=null){
					option.initialization();
					option.doAction();
					isOptionSeleted=true;
					selectedMenu=option;
				}
			}
			else if(irButton==EnumControllerButton.B){			
				if(this.superMenu==null){
					MenuManager manager=MenuManager.getInstance();
					manager.isMenuModel=false;
				}
				else{
					superMenu.isOptionSeleted=false;
				}
			}
			if(optionDialog!=null){
				optionDialog.setCursor(cursor);
			}
		
	}
	
	public IDialog getDialog() {
		// TODO Auto-generated method stub
		
		return null;
	}
	

	public void initialization() {
		// TODO Auto-generated method stub
		
		ArrayList<String> alOption=new ArrayList<String>();
		for(Menu menuOption:alOp){
			alOption.add(menuOption.name);
			Log.d("s", menuOption.name);
		}
		selectedMenu=null;
		isOptionSeleted=false;
		cursor=0;
		optionDialog= new OptionDialog(menuStartX,menuStartY,colNum,alOption);
		dialog=optionDialog;
	}
	
	public void doAction(){
		
	}
}
