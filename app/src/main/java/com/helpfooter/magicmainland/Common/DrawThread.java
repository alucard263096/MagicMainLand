package com.helpfooter.magicmainland.Common;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by steve on 2016/12/1.
 */
public class DrawThread extends Thread{
    GameCpu bv;
    SurfaceHolder surfaceHolder;
    public boolean flag=false;
    int sleepSpan=0;
    long start=System.nanoTime();
    int count=0;

    public DrawThread(GameCpu ballView, SurfaceHolder holder,int sleepSpan) {
        // TODO Auto-generated constructor stub

        this.bv=ballView;
        this.surfaceHolder=holder;
        this.flag=true;
        this.sleepSpan=sleepSpan;
    }


    public void run(){

        Canvas canvas=null;
        while(flag){
            try{
                canvas=surfaceHolder.lockCanvas(null);
                synchronized(surfaceHolder){
                    bv.doDraw(canvas);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                if(canvas!=null){
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
//			this.count++;
//			if(count==20){
//				count=0;
//				long tempStamp=System.nanoTime();
//				long span=tempStamp-start;
//				start=tempStamp;
//				double fps=Math.round(100000000000.0/span*20)/100;
//				//bv.fps="FPS:"+fps;
//			}
            if(sleepSpan>0)
                try{
                    Thread.sleep(sleepSpan);
                }catch(Exception e){
                    e.printStackTrace();
                }
        }

    }

}
