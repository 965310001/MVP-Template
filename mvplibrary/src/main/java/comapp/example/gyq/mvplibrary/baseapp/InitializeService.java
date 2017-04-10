package comapp.example.gyq.mvplibrary.baseapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

public class InitializeService extends IntentService {

    private static final String TAG = InitializeService.class.getSimpleName();

    public InitializeService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        serviceimpl.initConfig();
    }

    public static void start(Context context, ServiceImpl serviceimpl) {
        InitializeService.serviceimpl = serviceimpl;
        Intent intent = new Intent(context, InitializeService.class);
        context.startService(intent);
    }

    public static ServiceImpl serviceimpl;

    public interface ServiceImpl {
        void initConfig();
    }

}