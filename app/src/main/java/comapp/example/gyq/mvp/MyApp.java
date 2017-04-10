package comapp.example.gyq.mvp;

import android.util.Log;

import comapp.example.gyq.mvplibrary.baseapp.BaseApp;


/**
 * Created by zkw on 2017/3/30.
 */

public class MyApp extends BaseApp {

    @Override
    public void initConfig() {
        Log.d("MyApp", "第三方的初始化");
    }
}
