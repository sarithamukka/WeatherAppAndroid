package com.example.julyweather.data.repository

import com.example.julyweather.common.Util
import com.example.julyweather.data.model.WeatherApiRes
import com.example.julyweather.data.model.WeatherResponse
import com.example.julyweather.weather.network.RestAPI
import com.example.julyweather.weather.network.RestAPIClient
import io.reactivex.rxjava3.core.Observable

//https://api.openweathermap.org/data/2.5/weather?units=metric&lat=12.97&lon=77.59&exclude=minutely,hourly,dail&appid=2ce11c7e062a8a80425e3d0f91f6eda7
class WeatherRepository {
  fun getWeatherInfo() : Observable<WeatherApiRes>{
    val apiInterface: RestAPI = RestAPIClient.client.create(RestAPI::class.java)
    val apiObservable = apiInterface.fetchWeather("data/2.5/weather?units=metric&lat=12.97&lon=77.59&exclude=minutely,hourly,dail&appid="+ Util.Companion.API_KEY)
    return apiObservable
  }
}