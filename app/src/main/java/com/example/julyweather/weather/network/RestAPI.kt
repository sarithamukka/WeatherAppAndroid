package com.example.julyweather.weather.network

import com.example.julyweather.data.model.WeatherApiRes
import com.example.julyweather.data.model.WeatherResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface RestAPI {
  @GET
  fun fetchWeather(@Url url:String) : Observable<WeatherApiRes>
}