package comapp.example.gyq.mvplibrary.utils;

/**
 * Created by zkw on 2017/3/30.
 */

public interface LogImpl {

    void i(String msg);

    void d(String msg);

    void e(String msg);

    void v(String msg);

    void w(String msg);

    void json(String msg);


    void i(String tag, String msg);

    void d(String tag, String msg);

    void e(String tag, String msg);

    void v(String tag, String msg);

    void w(String tag, String msg);

    void json(String tag, String msg);
}
