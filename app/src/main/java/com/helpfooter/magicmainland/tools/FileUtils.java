package com.helpfooter.magicmainland.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class FileUtils {
	private String SDPATH;  
    
    private int FILESIZE = 128 ;   
      
    public String getSDPATH(){  
        return SDPATH;  
    }  
      
    public FileUtils(){  
        //�õ���ǰ�ⲿ�洢�豸��Ŀ¼( /SDCARD )  
        SDPATH = Environment.getExternalStorageDirectory() + "/";  
    }  
      
    /**  
     * ��SD���ϴ����ļ�  
     * @param fileName  
     * @return  
     * @throws IOException  
     */  
    public File createSDFile(String fileName) throws IOException{  
        File file = new File(SDPATH + fileName);  
        file.createNewFile();  
        return file;  
    }  
      
    /**  
     * ��SD���ϴ���Ŀ¼  
     * @param dirName  
     * @return  
     */
    public File createSDDir(String dirName){  
        File dir = new File(SDPATH + dirName);  
        dir.mkdir();  
        return dir;  
    }  
      
    /**  
     * �ж�SD���ϵ��ļ����Ƿ����  
     * @param fileName  
     * @return  
     */  
    public boolean isFileExist(String fileName){  
        File file = new File(SDPATH + fileName);  
        return file.exists();  
    }  
      
    /**  
     * ��һ��InputStream���������д�뵽SD����  
     * @param path  
     * @param fileName  
     * @param input  
     * @return  
     */  
    public File write2SDFromInput(String path,String fileName,InputStream input){  
        File file = null;  
        OutputStream output = null;  
        try {  
            createSDDir(path);  
            file = createSDFile(path + fileName);  
            output = new FileOutputStream(file);  
            byte[] buffer = new byte[FILESIZE];  
           do{
        	   int numread=input.read(buffer);
        	   if(numread<=0){
        		   break;
        	   }
        	   output.write(buffer, 0, numread);
           }while(true);
            output.flush();  
        }   
        catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally{  
            try {  
                output.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return file;  
    }

	public void deleteFile(String fileName) {
		// TODO Auto-generated method stub
		 File file = new File(SDPATH + fileName);  
		 file.delete();
		
	}  
	
	public File getFile(String fileName){
		File file = new File(SDPATH + fileName);  
		return file;
	}

	public static String getPath(String str) {
		// TODO Auto-generated method stub
		String[] strings=str.split("/");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<strings.length-1;i++){
			sb.append(strings[i]);
			sb.append("/");
		}
		return sb.toString();
	}

	public static String getFileName(String str) {
		// TODO Auto-generated method stub
		String[] strings=str.split("/");
		return strings[strings.length-1];
	}
	
}
