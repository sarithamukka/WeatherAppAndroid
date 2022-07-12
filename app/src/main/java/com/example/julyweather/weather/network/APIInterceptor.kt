package com.example.julyweather.weather.network

import com.example.julyweather.common.Util
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val url = chain.request().url().newBuilder()
      .addQueryParameter("appid", Util.API_KEY)
      .build()

    val request = chain.request().newBuilder()
      .url(url)
      .build()

    return chain.proceed(request)
  }
}