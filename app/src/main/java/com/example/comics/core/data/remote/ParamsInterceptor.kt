package com.example.comics.core.data.remote

import com.example.comics.core.util.Constant
import com.example.comics.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Constant.API_KEY_PARAM_COMICS, BuildConfig.API_KEY_COMICS)
            .addQueryParameter(Constant.API_TS_PARAM_COMICS, BuildConfig.TS_COMICS)
            .addQueryParameter(Constant.API_HASH_PARAM_COMICS, BuildConfig.HASH_COMICS)
            .build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }

}