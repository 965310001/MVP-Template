package comapp.example.gyq.mvplibrary.utils;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Toast统一管理类
 *
 * @author Mr Guo
 */
public final class ToastUtils {

    public static boolean isShow = true;

    private static volatile Context mContext;

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void initToastUtilsContext(Context context) {
        ToastUtils.mContext = context;
    }

    public static void showMessage(@NonNull CharSequence message) {
        if (isShow)
            try {
                ToastUtils.showMessage(ToastUtils.mContext, message);
            } catch (Exception e) {
                LogUtils.d("Exception", e.toString());
            }
    }

    public static void showMessage(@IdRes @NonNull int message) {
        if (isShow)
            try {
                ToastUtils.showMessage(ToastUtils.mContext, message);
            } catch (Exception e) {
                LogUtils.d("Exception", e.toString());
            }
    }


    static volatile Toast toast;

    public static void showMessage(Context context, @NonNull CharSequence message) {
        if (isShow) {
            try {
//				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                if (toast == null) {
                    toast = Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(message);
                }
            } catch (Exception e) {
                LogUtils.d("Exception", e.toString());
            }
            toast.show();
        }
    }

    @SuppressWarnings("ResourceType")
    public static void showMessage(Context context, @IdRes @NonNull int message) {
        if (isShow) {
            try {
                if (toast == null) {
                    toast = Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(message);
                }
//				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                LogUtils.d("Exception", e.toString());
            }
            toast.show();
        }
    }

}  
