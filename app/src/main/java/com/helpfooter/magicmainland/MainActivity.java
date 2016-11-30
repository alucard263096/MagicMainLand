package com.helpfooter.magicmainland;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.helpfooter.magicmainland.Classes.GameController;
import com.helpfooter.magicmainland.Common.GameCpu;
import com.helpfooter.magicmainland.Common.StaticObject;
import com.helpfooter.magicmainland.Utils.GameConfig;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        StaticObject.Resources=getResources();


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        {
            GameConfig.SCREENWIDTH=this.getWindowManager().getDefaultDisplay().getHeight();
            GameConfig.SCREENHEIGHT=this.getWindowManager().getDefaultDisplay().getWidth();
        }
        Log.d("s", String.valueOf(GameConfig.SCREENHEIGHT));
        Log.d("s", String.valueOf(GameConfig.SCREENWIDTH));

        GameController gameController=GameController.getInstance();
        gameController.setButtonImage(getResources());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        try {
            GameCpu gl;
            gl = new GameCpu(this, this);
            //StaticObject.GameCpu=gl;
            setContentView(gl);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }
}
