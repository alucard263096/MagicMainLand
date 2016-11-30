package com.helpfooter.magicmainland.Common;

import com.helpfooter.magicmainland.tools.FileUtils;
import com.helpfooter.magicmainland.tools.HttpDownloader;
import com.helpfooter.magicmainland.tools.ZipUtils;

import java.io.IOException;
import java.util.zip.ZipException;

/**
 * Created by steve on 2016/12/1.
 */

public class GameBuilder {
    private String GameId;

    public GameBuilder(String gameId){
        this.GameId=gameId;
    }

    public void GainGame() {
//		try {
//		 downloadGameZipFile();
//		} catch(Exception e){
//
//		}
//		 try {
//			unzipGameZipFile();
//		} catch (ZipException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Log.d("aa", "fuck");
        xmlFilePath="";
    }

    private void unzipGameZipFile() throws ZipException, IOException {
        // TODO Auto-generated method stub
        FileUtils fu=new FileUtils();

        ZipUtils.upZipFile(fu.getFile("MagicMainLand/GameData/"+this.GameId+".zip"), "MagicMainLand/GameData/"+this.GameId);
    }

    private boolean downloadGameZipFile() {
        // TODO Auto-generated method stub

        String url="http://192.168.1.104:8080/MagicMainLandDownload/"+this.GameId+".zip";
        int i= HttpDownloader.downFile(url, "MagicMainLand/GameData/", this.GameId+".zip",true);
        return i>=0;

    }
    String xmlFilePath="";
    public String getXmlFilePath() {
        // TODO Auto-generated method stub
        if(xmlFilePath==""){
            xmlFilePath=new FileUtils().getSDPATH()+"MagicMainLand/GameData/"+this.GameId+"/";
        }
        return xmlFilePath;
    }
}
