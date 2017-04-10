package comapp.example.gyq.mvplibrary.utils.log;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TimeWatchAspect {
    private static final String POINTCUT_TIME_WATCH =
            "execution(@com.example.administrator.aopdemo.SingleClickAspect * *(..))";

//    private static final String POINTCUT_TIME_WATCH =
//            "execution(* com.example.administrator.myapplication.MainActivity.onCreate(..))";

    @Pointcut(POINTCUT_TIME_WATCH)
    public void timeWatch() {
    }

    @Around("timeWatch()")
    public Object waveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        SingleClickAspect annotations = ms.getMethod().getAnnotation(SingleClickAspect.class);
        Log.d(TAG, "weaveJoinPoint: " + annotations.value() + "开始");
        Object result = joinPoint.proceed();
        Log.d(TAG, "weaveJoinPoint: " + annotations.value() + "结束");
        return result;
    }

    private static final String TAG = "TimeWatchAspect";
}