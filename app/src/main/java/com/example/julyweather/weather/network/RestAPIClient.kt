package com.example.julyweather.weather.network

import com.example.julyweather.common.Util
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestAPIClient {
  private var retrofit: Retrofit? = null
  private val gson = GsonBuilder().setLenient().create()

  val client: Retrofit
    get() {
      if (retrofit == null) {
        synchronized(Retrofit::class.java) {
          if (retrofit == null) {

            val httpClient = OkHttpClient.Builder()
              .addInterceptor(APIInterceptor())

            val client = httpClient.build()

            retrofit = Retrofit.Builder()
              .baseUrl(Util.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
              .client(client)
              .build()
          }
        }

      }
      return retrofit!!
    }
}