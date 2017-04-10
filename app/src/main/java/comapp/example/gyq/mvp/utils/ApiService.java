package comapp.example.gyq.mvp.utils;

import java.util.Map;

import comapp.example.gyq.mvp.main.m.bean.Joke;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface ApiService {

    //    pagenum=10&pagesize=3&appkey=9814b57c706d0a23
    @GET("/xiaohua/text/")
    Observable<Joke> getMyNews(@Query("pagenum") String pagenum,
                               @Query("pagesize") String pagesize,
                               @Query("appkey") String appkey);


    @GET("/xiaohua/text/")
    Observable<Joke> getMyNews(@QueryMap Map<String, String> map);
}
