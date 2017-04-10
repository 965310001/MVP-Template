package comapp.example.gyq.mvplibrary.baseapp;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public abstract class BaseApp extends Application implements InitializeService.ServiceImpl {

    private static BaseApp INSTANCE;

    public static Context getContext() {
        return INSTANCE.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        InitializeService.start(this, this);
    }

}
