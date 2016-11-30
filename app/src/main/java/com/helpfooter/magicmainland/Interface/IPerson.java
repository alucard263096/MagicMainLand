package com.helpfooter.magicmainland.Interface;


import com.helpfooter.magicmainland.Classes.SceneCore.ObjectPosition;

public interface IPerson {
	void Talking(String defaultDirect);
	
	void Go(int detaX,int detaY,ObjectPosition objPosition);
	
}
