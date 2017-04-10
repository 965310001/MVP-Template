package comapp.example.gyq.mvp.main.m;

import android.util.Log;


import java.util.Map;

import comapp.example.gyq.mvp.Contract.ParameterMap;
import comapp.example.gyq.mvp.main.m.bean.Joke;
import comapp.example.gyq.mvp.main.p.JokeContract;
import comapp.example.gyq.mvp.main.v.MVPListener;
import comapp.example.gyq.mvplibrary.ApiCallback;
import comapp.example.gyq.mvplibrary.utils.RxBus;



import static android.content.ContentValues.TAG;
import static comapp.example.gyq.mvp.utils.HttpUtils.addSubscription;
import static comapp.example.gyq.mvp.utils.HttpUtils.apiService;


/**
 * Created by zkw on 2017/3/17.
 */

@SuppressWarnings("ALL")
public class JokeModel implements JokeContract.JokeModel {

//    public static final String REQUEST_SERVER_URL = "http://api.jisuapi.com/xiaohua/text?";
//
//    public static final String APPKEY = "&appkey=9814b57c706d0a23";

    //http://api.jisuapi.com/xiaohua/text?pagenum=10&pagesize=3&appkey=9814b57c706d0a23

    @Override
    public void requestJoke(String pNum, String pSize, final MVPListener pMVPListener) {
//        VolleyRequest.newInstance().newGsonRequest(REQUEST_SERVER_URL + "pagenum=" + pNum + "&" + "pagesize=" + pSize + "&sort=addtime" + APPKEY,
//
//                Joke.class, new Response.Listener<Joke>() {
//                    @Override
//                    public void onResponse(Joke pJoke) {
//                        if (pJoke != null) {
//                            pMVPListener.onSuccess(pJoke);
//                        } else {
//                            pMVPListener.onError();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        pMVPListener.onError();
//                    }
//                });

        //请求网络

        Map<String, String> map = ParameterMap.put("pagenum", "10").put("pagesize", "3").put("appkey", "9814b57c706d0a23").getMap();
//        Map<String, String> map = new HashMap<>();
//        map.put("pagenum", "10");
//        map.put("pagesize", "3");
//        map.put("appkey", "9814b57c706d0a23");

        addSubscription(apiService.getMyNews(map), new ApiCallback<Joke>() {
            @Override
            public void onSuccess(Joke joke) {
                Log.d(TAG, "onSuccess: " + joke.toString());
                pMVPListener.onSuccess(joke);
                if (joke != null) {
                    RxBus.getInstance().post(joke);
                } else {
                    RxBus.getInstance().post("数据为空");
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.d(TAG, "onFailure: " + msg);
                pMVPListener.onError(msg);
                RxBus.getInstance().post(msg);
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: ");
                pMVPListener.onFinish();
            }
        });


//        addSubscription("http://api.jisuapi.com/xiaohua/text?pagenum=10&pagesize=3&appkey=9814b57c706d0a23", null,
//                new ApiCallback<Result>() {
//                    @Override
//                    public void onSuccess(Result joke) {
//                        Log.d(TAG, "onSuccess: " + joke.toString());
//                        Gson gson=new Gson();
////                        gson.fromJson(new String(joke.data),Joke.class);
//                        if (null!=joke.data) {
////                            pMVPListener.onSuccess(gson.fromJson(new String(joke.data),Joke.class));
//                            RxBus.getInstance().post(gson.fromJson(new String(joke.data),Joke.class));
//                        } else {
//                            RxBus.getInstance().post("数据为空");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(String msg) {
//                        pMVPListener.onError(msg);
//                        RxBus.getInstance().post(msg);
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        Log.d(TAG, "");
//                        pMVPListener.onFinish();
//                    }
//                });
//
//        Log.d(TAG, RxVolley.CACHE_FOLDER.getAbsolutePath().toString());
//
    }
}