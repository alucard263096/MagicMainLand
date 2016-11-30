package com.helpfooter.magicmainland.ClassesItemExtends;

import android.util.Log;


public abstract class Item implements Cloneable {
	public String id;
	public String name;
	public String description;
	public boolean canCombine=true;
	
	public Item(String id,String name,boolean canCombine){
		this.name=name;
		this.id=id;
		this.canCombine=canCombine;
	}
	
	public void setDescription(String description){
		this.description= description;
	}
	
	public Object clone() { 
        try { 
            return super.clone(); 
        } catch (CloneNotSupportedException e) { 
        	Log.d("cloneerror", "cloneerror");
            return null; 
        } 
    } 
}
