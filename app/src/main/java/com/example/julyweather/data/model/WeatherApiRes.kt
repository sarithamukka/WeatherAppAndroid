package com.example.julyweather.data.model

import com.example.julyweather.domain.model.WeatherModel
import com.google.gson.annotations.SerializedName

data class WeatherApiRes(
  @SerializedName("dt")
  val dt: Long = 0,
  @SerializedName("main")
  val main: WeatherResponse? = null,
  @SerializedName("sys")
  val sys : OtherWeatherData? = null

  )
fun WeatherApiRes.convertToDomainWrapper() : WeatherModel {
  return WeatherModel(this.dt, this.sys?.sunrise?:0, this.sys?.sunset?:0,this.main?.temp?:0.0, this.main?.humidity?:0, this.main?.pressure?:0 )
}