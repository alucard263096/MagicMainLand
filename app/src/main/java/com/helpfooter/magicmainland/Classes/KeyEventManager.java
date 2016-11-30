package com.helpfooter.magicmainland.Classes;

import java.util.Dictionary;
import java.util.Hashtable;

import android.util.Log;

public class KeyEventManager {
	
	Dictionary<String,EventRecord> dictEventRecord=new Hashtable<String,EventRecord>();
	
	
	private static KeyEventManager instance=null;
	public static KeyEventManager getInstance(){
		
		if(instance==null){
			instance=new KeyEventManager();
		}
		return instance;
	}

	private KeyEventManager(){
		
	}
	
	public void registerKeyEvent(String dictKey){
		EventRecord er=dictEventRecord.get(dictKey);
		if(er==null){
			Log.d("aa", dictKey);
			er=new EventRecord(dictKey);
			dictEventRecord.put(dictKey, er);
		}
		Log.d("ab",String.valueOf( dictEventRecord.size()));
	}
	
	public void completedEvent(String dictKey){
		
			EventRecord er=dictEventRecord.get(dictKey);
			if(er!=null){
				
				er.completed=true;
				dictEventRecord.remove(dictKey);
				dictEventRecord.put(dictKey, er);

				Log.d("ba", String.valueOf(getEventIsCompleted(dictKey)));
			}
			Log.d("bb", "cao");
//		
//		
	}
	
	public boolean getEventIsCompleted(String dictKey){

		EventRecord er=dictEventRecord.get(dictKey);
		if(er!=null){
			Log.d("ca", String.valueOf(er.completed));
			return er.completed;
			
		}else{
			Log.d("cb", "cb");
			return false;
		}
	}
	
	
}
