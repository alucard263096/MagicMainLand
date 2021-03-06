package com.helpfooter.magicmainland.tools;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.net.MalformedURLException;  
import java.net.URL;  

import android.util.Log;
  
public class HttpDownloader {  
      
    
      
    /**  
     * ����URL�����ļ�,ǰ��������ļ����е��������ı�,�����ķ���ֵ�����ı����е�����  
     * 1.����һ��URL����  
     * 2.ͨ��URL����,����һ��HttpURLConnection����  
     * 3.�õ�InputStream  
     * 4.��InputStream���ж�ȡ����  
     * @param urlStr  
     * @return  
     */  
    public static String download(String urlStr){  
    	 URL url = null;   
        StringBuffer sb = new StringBuffer();  
        String line = null;  
        BufferedReader buffer = null;  
        try {  
            url = new URL(urlStr);  
            HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();  
            buffer = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));  
            while( (line = buffer.readLine()) != null){  
                sb.append(line);  
            }  
              
        }   
        catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally{  
            try {  
                buffer.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return sb.toString();  
    }  
  
    /**  
     *   
     * @param urlStr  
     * @param path  
     * @param fileName  
     * @return   
     *      -1:�ļ����س���  
     *       0:�ļ����سɹ�  
     *       1:�ļ��Ѿ�����  
     */  
    public static  int downFile(String urlStr, String path, String fileName,boolean isReplace){  
    	 URL url = null;   
        InputStream inputStream = null;  
        try {  
            FileUtils fileUtils = new FileUtils();  
              if(isReplace){
            	  if(fileUtils.isFileExist(path + fileName)){
            		  fileUtils.deleteFile(path + fileName);
                  }
                  inputStream = getInputStreamFromURL(urlStr);  
                  Log.d("down", urlStr);
                  File resultFile = fileUtils.write2SDFromInput(path, fileName, inputStream);  
                  if(resultFile == null){  
                      return -1;  
                  } 
              }else{

                  if(fileUtils.isFileExist(path + fileName)){  
                      return 1;  
                  } else {  
                      inputStream = getInputStreamFromURL(urlStr);  
                      Log.d("down", urlStr);
                      File resultFile = fileUtils.write2SDFromInput(path, fileName, inputStream);  
                      if(resultFile == null){  
                          return -1;  
                      }  
                  }  
              }
        }   
        catch (Exception e) {  
            e.printStackTrace();  
            return -1;  
        }  
        finally{  
            try {  
                inputStream.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return 0;  
    }  
      
    /**  
     * ����URL�õ�������  
     * @param urlStr  
     * @return  
     */  
    public static  InputStream getInputStreamFromURL(String urlStr) {  
    	 URL url = null;   
        HttpURLConnection urlConn = null;  
        InputStream inputStream = null;  
        try {  
            url = new URL(urlStr);  
            urlConn = (HttpURLConnection)url.openConnection();  
            inputStream = urlConn.getInputStream();  
              
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        return inputStream;  
    }  
}  
