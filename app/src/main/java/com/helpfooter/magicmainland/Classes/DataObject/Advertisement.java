package com.helpfooter.magicmainland.Classes.DataObject;

import com.helpfooter.magicmainland.Utils.EnumAdvertisementType;

/**
 * Created by steve on 2016/12/1.
 */
public class Advertisement {

//    <type>image</type>
//    <playseconds>3</playseconds>
//    <name>1015498285bd332310.jpg</name>
//    <filename>1015498285bd332310.jpg</filename>

    public EnumAdvertisementType Type;
    public int PlaySeconds;
    public String Name;
    public String PlayFilePath;

    public Advertisement(String type,int playSeconds,String name,String filepath){
        if(type=="image"){
            this.Type=EnumAdvertisementType.Image;
        }
        this.PlaySeconds=playSeconds;
        this.Name=name;

        PlayFilePath=filepath;
    }

}

