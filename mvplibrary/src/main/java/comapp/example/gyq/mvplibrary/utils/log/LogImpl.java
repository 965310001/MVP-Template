package comapp.example.gyq.mvplibrary.utils.log;

/**
 * Created by zkw on 2017/4/10.
 */

public abstract class LogImpl {

    public static boolean ISDEBUG = true;
    public static String TAG = "zls";

    public static void init(String tag) {
        TAG = tag;
    }

    public static void init(String tag, boolean isDebug) {
        TAG = tag;
        ISDEBUG = isDebug;
    }

    protected abstract void i(String msg);

    protected abstract void d(String msg);

    protected abstract void e(String msg);

    protected abstract void v(String msg);

    protected abstract void w(String msg);

    protected abstract void json(String msg);

}
