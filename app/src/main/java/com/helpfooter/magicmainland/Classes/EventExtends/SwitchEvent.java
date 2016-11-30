package com.helpfooter.magicmainland.Classes.EventExtends;

import android.graphics.Canvas;
import android.util.Log;
import com.helpfooter.magicmainland.Utils.EnumControllerButton;
import com.helpfooter.magicmainland.Utils.EnumDialogOption;
import com.helpfooter.magicmainland.Classes.EventManager;
import com.helpfooter.magicmainland.Classes.KeyEventManager;
import com.helpfooter.magicmainland.Classes.DialogExtends.Dialog;
import com.helpfooter.magicmainland.Classes.DialogExtends.YesNoDialog;
import com.helpfooter.magicmainland.Classes.PersonExtends.Person;
import com.helpfooter.magicmainland.Interface.IDialog;

public class SwitchEvent extends Event {
	Event yEvent;
	Event nEvent;

	EnumDialogOption dialogSelected;
	
	YesNoDialog ynDialog;
	
	public SwitchEvent(String id,String name,String msg,Event yEvent,Event nEvent) {
		super( id, name,msg);
		// TODO Auto-generated constructor stub
		this.yEvent=yEvent;
		this.nEvent=nEvent;
		dialogSelected=EnumDialogOption.YES;
		
		
	}
	
	public void SetSelectEvent(boolean tOrf){
		
		super.setNextEvent(tOrf?yEvent:nEvent);
		
	}
	public void doAction(){
		dialogSelected=EnumDialogOption.YES;
		super.doAction();
	}
	
	public IDialog getDialog() {
		// TODO Auto-generated method stub
		ynDialog=new YesNoDialog(this.msg, talkerName);
		return ynDialog;
	}
	
	public void setControll(EnumControllerButton irButton) {
		// TODO Auto-generated method stub
		if(irButton==EnumControllerButton.DOWN){
			dialogSelected=EnumDialogOption.NO;
			ynDialog.setYesNo(dialogSelected);
		}
		else if(irButton==EnumControllerButton.UP){
			dialogSelected=EnumDialogOption.YES;
			ynDialog.setYesNo(dialogSelected);
		}
		else if(irButton==EnumControllerButton.A){
//			DialogManager dm=DialogManager.getInstance();
//			dm.pollDialog(dialogSelected==EnumDialogOption.YES);
			
			this.SetSelectEvent(dialogSelected==EnumDialogOption.YES);
			this.setNextDialog();
		}
	}
}
