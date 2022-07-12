package com.example.julyweather.data.model

import com.example.julyweather.domain.model.WeatherModel
import com.google.gson.annotations.SerializedName

data class WeatherResponse (

  /*@SerializedName("dt")
  val dt: Long = 0,
  @SerializedName("sunrise")
  val sunrise: Long = 0,
  @SerializedName("sunset")
  val sunset: Long = 0,*/
  @SerializedName("temp")
  val temp: Double = 0.0,
  @SerializedName("humidity")
  val humidity: Long = 0,
  @SerializedName("pressure")
  val pressure: Long = 1014
)
