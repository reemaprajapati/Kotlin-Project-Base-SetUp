package com.yipl.labelstep.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yipl.labelstep.BuildConfig
import com.yipl.labelstep.MainApplication
import com.yipl.labelstep.api.ApiService
import com.yipl.labelstep.data.AppPreferences
import com.yipl.labelstep.data.database.LabelDatabase
import com.yipl.labelstep.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule{

    var DATABASE_NAME = "label_database"

//    lateinit var mMyApplication: MainApplication

//    fun ApplicationModule(application: MainApplication) {
//        mMyApplication = application
//

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application):Context= application.applicationContext

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(application: Application): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

//        val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
//        // 10 MiB cache
//        val cache = Cache(cacheDir, 10 * 1024 * 1024)
//
        return OkHttpClient.Builder()
//                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(gson: Gson, okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL_DEBUG)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): LabelDatabase {
        val labelDatabase: LabelDatabase = Room
                .databaseBuilder(
                        application.applicationContext,
                        LabelDatabase::class.java, DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        return labelDatabase
    }

    @Provides
    @Singleton
    fun provideDao(database: LabelDatabase) = database.daoAccess()


    @Provides
    @Singleton
    fun provideAppPreferences(application: Application): AppPreferences {
        return AppPreferences(application)
    }
}