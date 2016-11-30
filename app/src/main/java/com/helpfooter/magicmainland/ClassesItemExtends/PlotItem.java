package com.helpfooter.magicmainland.ClassesItemExtends;

public class PlotItem extends Item {
	

	public PlotItem(String id,String name,String eventId) {
		super(id,name,false);
		// TODO Auto-generated constructor stub
		this.eventId=eventId;
	}

	String eventId;
}
