package com.helpfooter.magicmainland.Common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.helpfooter.magicmainland.Classes.AdvertisementLoading;
import com.helpfooter.magicmainland.Classes.SceneView;
import com.helpfooter.magicmainland.Interface.IGameUnit;
import com.helpfooter.magicmainland.MainActivity;
import com.helpfooter.magicmainland.tools.FileUtils;

/**
 * Created by steve on 2016/12/1.
 */

public class GameCpu  extends SurfaceView implements SurfaceHolder.Callback {

    MainActivity gameActivity=null;
    DrawThread dt;
    Resources r;
    AdvertisementLoading ad;
    SceneView sv;
    GameBuilder gameBuilder;
    IGameUnit currentGameUnit;

    public GameCpu(Context context, MainActivity activity ){
        super(context);
        getHolder().addCallback(this);
        r=getResources();
        dt=new DrawThread(this,getHolder(),0);
        gameActivity=activity;

        FileUtils fu=new FileUtils();
        fu.createSDDir("MagicMainLand");

        gameBuilder=new GameBuilder("GacCpy");
        gameBuilder.GainGame();

        StaticObject.GameCpu=this;

        AdvertisementLoading advertisementLoading=new AdvertisementLoading(this, r);
        ChangeGameStatu(advertisementLoading);
    }

    public void ChangeGameStatu(IGameUnit gameUnit){

        currentGameUnit=gameUnit;
        currentGameUnit.initialization(r);
    }

    public void doDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        currentGameUnit.doDraw(canvas);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        if(!dt.isAlive()){
            dt.start();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        dt.flag=false;
        dt= null;
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_DOWN)
        {

            float touchX=event.getX();
            float touchY=event.getY();
            currentGameUnit.getScreenTouch(touchX, touchY);
        }
        return false;
    }

    public String getXmlFilePath() {
        // TODO Auto-generated method stub
        return gameBuilder.getXmlFilePath();
    }
}
