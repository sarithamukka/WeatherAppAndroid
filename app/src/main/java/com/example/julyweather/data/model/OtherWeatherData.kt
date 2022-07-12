package com.example.julyweather.data.model

import com.google.gson.annotations.SerializedName

data class OtherWeatherData(
  @SerializedName("sunrise")
  val sunrise: Long = 0,
  @SerializedName("sunset")
  val sunset: Long = 0,
)
