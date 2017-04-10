package comapp.example.gyq.mvplibrary.baseapp;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

/**
 * Created by zkw on 2017/3/29.
 */

public interface BaseActivityImpl {

    /**
     * 初始化布局
     *
     * @return
     */
    @LayoutRes
    @NonNull
    int initLayout();

    /**
     * 初始化注解
     */
    void bindIoc();

    /**
     * 取消注解
     */
    void unbindIoc();

    void showDialog();

    void dismissDialog();


    void showMessage(@NonNull CharSequence message);

    void showMessage(@IdRes @NonNull int message);

    void initToastUtilsContext();
}
