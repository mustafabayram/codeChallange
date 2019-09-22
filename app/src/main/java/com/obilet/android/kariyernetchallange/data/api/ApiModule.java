package com.obilet.android.kariyernetchallange.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obilet.android.kariyernetchallange.BuildConfig;
import com.obilet.android.kariyernetchallange.di.ApplicationScope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @ApplicationScope
    @Provides
    public Gson provideGson() {
        return new GsonBuilder().setPrettyPrinting()
                .setDateFormat(BuildConfig.API_DATE_FORMAT)
                .create();
    }

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(BuildConfig.NETWORKING_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(BuildConfig.NETWORKING_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }

    @ApplicationScope
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @ApplicationScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @ApplicationScope
    @Provides
    static ApiService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}

