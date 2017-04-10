package comapp.example.gyq.mvp.utils;


import android.support.annotation.NonNull;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import rx.Observable;
import rx.Subscriber;

import rx.android.schedulers.AndroidSchedulers;

import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;



/**
 * Created by zkw on 2017/3/17.
 */

public class HttpUtils {

    private static volatile CompositeSubscription compositeSubscription = null;
    public static final  ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

    public static  void addSubscription(Observable observable, Subscriber subscriber) {
        if (compositeSubscription == null) {
            synchronized (HttpUtils.class) {
                if (compositeSubscription == null) {
                    compositeSubscription = new CompositeSubscription();
                }
            }
        }
        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
        );
    }

    public static  void addSubscription(@NonNull String url, HttpParams params, @NonNull Subscriber subscriber) {

        Observable<Result> result = new RxVolley.Builder()
                .url(url)
                //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .httpMethod(RxVolley.Method.GET)
                .cacheTime(6)
                .params(params)
                .contentType(RxVolley.ContentType.JSON)
                .getResult();

        if (compositeSubscription == null) {
            synchronized (HttpUtils.class) {
                if (compositeSubscription == null) {
                    compositeSubscription = new CompositeSubscription();
                }
            }
        }
        compositeSubscription.add(result
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
        );

    }


}
