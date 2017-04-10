package comapp.example.gyq.mvp.utils;

import android.util.Log;

import java.io.File;
import java.io.IOException;

import comapp.example.gyq.mvp.BuildConfig;
import comapp.example.gyq.mvp.Contract.MyConstants;
import comapp.example.gyq.mvplibrary.baseapp.BaseApp;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import okhttp3.Response;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

final class RetrofitClient {

    private static volatile Retrofit mRetrofit;

    private RetrofitClient() {
    }


    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            synchronized (RetrofitClient.class) {
                if (mRetrofit == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    OkHttpClient okHttpClient = null;
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(loggingInterceptor);

                        File cacheFile = new File(BaseApp.getContext().getCacheDir(), "mvp");
                        Cache cache = new Cache(cacheFile, 1024 * 1024 * 10); //10Mb
                        okHttpClient = builder.cache(cache).addInterceptor(new CacheIntereptor()).addNetworkInterceptor(new CacheIntereptor()).build();

                        Log.d("RetrofitClient", "正好" + cacheFile.getAbsolutePath());
//                        okHttpClient.cache();

                    }
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(MyConstants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();
                }
            }
        }
        return mRetrofit;
    }

      static class CacheIntereptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            int maxAge = 100; // read from cache
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        }
    }
}
