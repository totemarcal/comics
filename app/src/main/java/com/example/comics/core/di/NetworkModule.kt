package com.example.comics.core.di

import com.example.comics.BuildConfig
import com.example.comics.core.data.remote.ComicsService
import com.example.comics.core.data.remote.ParamsInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT_SECONDS = 15L

    @Provides
    fun provideParamsInterceptor(): ParamsInterceptor {
        return ParamsInterceptor()
    }

    @Provides
    fun provideLogginInterceptor(): HttpLoggingInterceptor {
          return HttpLoggingInterceptor().apply {
              setLevel(
                  if (BuildConfig.DEBUG) {
                      HttpLoggingInterceptor.Level.BODY
                  } else {
                      HttpLoggingInterceptor.Level.NONE
                  }
              )
          }
    }

    @Provides
    fun provideOkHttpClient(
        paramsInterceptor: ParamsInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(paramsInterceptor)
            .addInterceptor(loggingInterceptor)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideComicsService(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) : ComicsService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_COMICS)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
            .create(ComicsService::class.java)
    }

}