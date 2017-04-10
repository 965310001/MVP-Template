package comapp.example.gyq.mvplibrary.baseapp;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import com.trello.rxlifecycle.components.RxActivity;

import butterknife.ButterKnife;
import comapp.example.gyq.mvplibrary.R;
import comapp.example.gyq.mvplibrary.utils.LogImpl;
import comapp.example.gyq.mvplibrary.utils.LogUtils;
import comapp.example.gyq.mvplibrary.utils.ToastUtils;

public abstract class BaseActivity extends RxActivity implements BaseActivityImpl, LogImpl {

    //加载框可以自己定义
    private ProgressDialog progressDialog;

    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("正在加载中...");
            progressDialog.setCancelable(false);
        }

        setContentView(initLayout());
        mContext = this;
        bindIoc();

        initToastUtilsContext();

//        initWindow();
    }

//    @TargetApi(19)
//    private void initWindow() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindIoc();
    }


    @Override
    public void bindIoc() {
        ButterKnife.bind(this);
    }

    @Override
    public void unbindIoc() {
        ButterKnife.unbind(this);
    }


    @Override
    public void showDialog() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void initToastUtilsContext() {
        ToastUtils.initToastUtilsContext(this);
    }

    @Override
    public void showMessage(@NonNull CharSequence message) {
        ToastUtils.showMessage(message);
    }

    @Override
    public void showMessage(@IdRes @NonNull int message) {
        ToastUtils.showMessage(message);
    }



    /**
     * 打印日志
     */
    @Override
    public void i(String msg) {
        LogUtils.i(msg);
    }

    @Override
    public void d(String msg) {
        LogUtils.d(msg);
    }

    @Override
    public void e(String msg) {
        LogUtils.e(msg);
    }

    @Override
    public void v(String msg) {
        LogUtils.v(msg);
    }

    @Override
    public void w(String msg) {
        LogUtils.w(msg);
    }

    @Override
    public void json(String msg) {
        LogUtils.json(msg);
    }

    @Override
    public void i(String tag, String msg) {
        LogUtils.i(tag, msg);
    }

    @Override
    public void d(String tag, String msg) {
        LogUtils.d(tag, msg);
    }

    @Override
    public void e(String tag, String msg) {
        LogUtils.e(tag, msg);
    }

    @Override
    public void v(String tag, String msg) {
        LogUtils.v(tag, msg);
    }

    @Override
    public void w(String tag, String msg) {
        LogUtils.w(tag, msg);
    }

    @Override
    public void json(String tag, String msg) {
        LogUtils.json(tag, msg);
    }
}
